<template>
  <div class="app-wrapper">
    <suyanSider class="sidebar-container" />
    <div class="main-container">
      <suyanNavbar />
      <router-view />
    </div>
  </div>
</template>

<script setup>
  import suyanSider from './side-menu/index.vue';
  import suyanNavbar from './navbar/index.vue';
</script>

<style lang="scss">
  @use './index.scss';
</style>
