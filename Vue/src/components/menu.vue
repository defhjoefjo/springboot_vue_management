<template>
      <el-menu
          style="width: 200px; min-height: calc(100vh - 50px)"
          default-active="2"
          class="el-menu-vertical-demo">
        <el-sub-menu index="1">
          <template #title>
            <i class="el-icon-location"></i>
            <span>Management</span>
          </template>
          <el-menu-item-group>
            <el-menu-item index="1-1">Users</el-menu-item>
          </el-menu-item-group>
        </el-sub-menu>
      </el-menu>

</template>

<script>
export default {
  name: "Menu_me"
}
</script>

<style scoped>

</style>