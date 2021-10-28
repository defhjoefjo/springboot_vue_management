<template>
  <div style="padding: 20px">
    <div style="margin-bottom: 5px">
      <el-button type="primary" @click="add">Add</el-button>
      <el-button type="primary">Import</el-button>
      <el-button type="primary">Export</el-button>
    </div>
    <el-input v-model="search" placeholder="type to search" style="width: 20%; margin-bottom: 10px" clearable />
    <el-button style="margin: 5px 10px" @click="load"> Search</el-button>
    <el-table :data="tableData" border style="width: 100%">
      <el-table-column prop="username" label="用户名" />
      <el-table-column prop="nickName" label="昵称" />
      <el-table-column prop="age" label="年龄" />
      <el-table-column prop="sex" label="性别" />
      <el-table-column prop="address" label="地址" />
      <el-table-column label="Operations">
        <template #default="scope">
          <el-button type="text" size="small" @click="handleEdit(scope.row)"
          >Edit</el-button
          >
          <el-popconfirm
              confirm-button-text="OK"
              cancel-button-text="No, Thanks"
              icon="el-icon-info"
              icon-color="red"
              title="Are you sure to delete this?"
          @confirm="handleDelete(scope.row.id)">
            <template #reference>
              <el-button type="text" size="small">Delete</el-button>
            </template>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>
    <div style="margin: 10px 0">
      <el-pagination
          v-model:currentPage="currentPage1"
          :page-sizes="[5,10,15,20]"
          :page-size="pageSize"
          layout="total, sizes, prev, pager, next, jumper"
          :total="total"
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
      >
      </el-pagination>
      <el-dialog
          v-model="dialogVisible"
          title="Tips"
          width="30%"
      >
        <el-form label-width="120 px">
          <el-form-item :model="form" label="用户名" style="width: 80%">
            <el-input v-model="form.username"></el-input></el-form-item>
          <el-form-item :model="form" label="昵称" style="width: 80%">
            <el-input v-model="form.nickName"></el-input></el-form-item>
          <el-form-item :model="form" label="年龄" style="width: 80%">
            <el-input v-model="form.age"></el-input></el-form-item>
          <el-form-item :model="form" label="性别" style="width: 80%">
            <el-input v-model="form.sex"></el-input></el-form-item>
          <el-form-item :model="form" label="地址" style="width: 80%">
            <el-input type="textarea" v-model="form.address"></el-input></el-form-item>
        </el-form>
        <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogVisible = false">Cancel</el-button>
        <el-button type="primary" @click="save"
        >Confirm</el-button
        >
      </span>
        </template>
      </el-dialog>
    </div>

  </div>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import request from "@/utils/request";
import {ElMessage} from "element-plus";

export default defineComponent({
  name: 'Home',
  components: {
  },
  data() {
    return {
      form:{},
      tableData: [],
      currentPage1:0,
      pageSize:10,
      total:100,
      dialogVisible:false,
      search:''
    }
  },
  created(){
    this.load()
  },
  methods: {
    load(){
      request.get("/api/user",{params:{
          pageNum: this.currentPage1,
          pageSize: this.pageSize,
          search: this.search
        }
      }).then(res=>{
        console.log(res)
        this.tableData=res.data.records;
        this.total =res.data.total
      })
    },

    add() {
      this.dialogVisible=true;
      this.form = {};
      this.load()
    },
    save(){
      if ((this.form as any).id) {
        request.put("/api/user",this.form).then(
            (res: any) => {
              console.log(res);
              ElMessage("更改！")
            })
      } else {
      request.post("/api/user",this.form).then(
            (res: any) => {
              console.log(res);
              ElMessage("新增！")
            }
      )}
      this.dialogVisible = false
},
    handleEdit(row) {
        this.form = JSON.parse(JSON.stringify(row))
        this.dialogVisible = true;
    },
    handleSizeChange(pageSize) {
      this.pageSize = pageSize
      this.load()
    },
    handleCurrentChange(pageNum){
      this.currentPage1 = pageNum
      this.load()
    },
    handleDelete(id){
      console.log(id)
      request.delete("/api/user/"+id).then(res=>{
        ElMessage("删除！")
        this.load()
      })
    }
  }
},
);
</script>
