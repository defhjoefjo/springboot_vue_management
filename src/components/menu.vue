<template>
      <el-menu
          style="width: 200px; min-height: calc(100vh - 50px)"
          default-active="2"
          class="el-menu-vertical-demo">
        <el-sub-menu index="1">
          <template #title>
            <i class="el-icon-location"></i>
            <span>Navigator One</span>
          </template>
          <el-menu-item-group title="Group One">
            <el-menu-item index="1-1">item one</el-menu-item>
            <el-menu-item index="1-2">item one</el-menu-item>
          </el-menu-item-group>
          <el-menu-item-group title="Group Two">
            <el-menu-item index="1-3">item three</el-menu-item>
          </el-menu-item-group>
          <el-sub-menu index="1-4">
            <template #title>item four</template>
            <el-menu-item index="1-4-1">item one</el-menu-item>
          </el-sub-menu>
        </el-sub-menu>
        <el-menu-item index="2">
          <i class="el-icon-document"></i>
          <span>Navigator Two</span>
        </el-menu-item>
        <el-menu-item index="3">
          <i class="el-icon-setting"></i>
          <span>Navigator Three</span>
        </el-menu-item>
      </el-menu>

</template>

<script>
export default {
  name: "Menu_me"
}
</script>

<style scoped>

</style>