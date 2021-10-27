<template>
  <div style="padding: 20px">
    <el-input v-model="input" placeholder="type to search" style="width: 20%; margin-bottom: 10px" />
    <el-button style="margin: 5px 10px"> Search</el-button>
    <el-table :data="tableData" border style="width: 100%">
      <el-table-column prop="date" label="Date" />
      <el-table-column prop="name" label="Name" />
      <el-table-column prop="address" label="Address" />
      <el-table-column label="Operations">
        <template #default="scope">
          <el-button type="text" size="small" @click="handleEdit"
          >Edit</el-button
          >
          <el-popconfirm
              confirm-button-text="OK"
              cancel-button-text="No, Thanks"
              icon="el-icon-info"
              icon-color="red"
              title="Are you sure to delete this?"
          >
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
          :page-size="10"
          layout="total, sizes, prev, pager, next, jumper"
          :total="total"
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
      >
      </el-pagination>
    </div>
  </div>
</template>

<script lang="ts">
import { defineComponent } from 'vue';

export default defineComponent({
  name: 'Home',
  components: {
  },
  data() {
    return {
      tableData: [{
        date: "123",
        name: "shabi",
        address: "sss",
      }],
      currentPage1:0,
      total:100,
    }
  },
  methods: {
    handleEdit() {

    },
    handleSizeChange() {

    },
    handleCurrentChange(){

    }
  }
},
);
</script>
