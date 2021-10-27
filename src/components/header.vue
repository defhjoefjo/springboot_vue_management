<template>
<div style="height:50px;line-height: 50px;border-bottom: 1px solid #ccc; display: flex">
  <div style="width: 200px; padding-left: 30px; font-weight: bold; color: cadetblue">backgound </div>
  <div style="flex: 1"></div>
  <div style="width: 100px">
    <el-dropdown>
    <span class="el-dropdown-link">
      Name<i class="el-icon-arrow-down el-icon--right"></i>
    </span>
      <template #dropdown>
        <el-dropdown-menu>
          <el-dropdown-item>Profile</el-dropdown-item>
          <el-dropdown-item>Quit</el-dropdown-item>
        </el-dropdown-menu>
      </template>
    </el-dropdown>
  </div>
</div>
</template>

<script>
export default {
  name: "Header"
}
</script>

<style scoped>
.el-dropdown-link {
  cursor: pointer;
  color: #409eff;
}
.el-icon-arrow-down {
  font-size: 12px;
}
</style>