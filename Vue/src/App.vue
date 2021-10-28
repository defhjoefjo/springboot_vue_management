<template>
  <div>
  <Header />
    <div style="display: flex">
      <Menu_me />
      <router-view style="flex: 1"/>
    </div>

  </div>

</template>


<style>
</style>
<script>
import Header from "@/components/header";
import Menu_me from "@/components/menu"
export default {
  name: "Layout",
  components: {
    Header,
    Menu_me
  }
}
</script>