<template>
  <div class="app-wrapper">
    <suyanSider :class="collapsed ? 'collapse' : ''" class="sidebar-container" :collapsed="collapsed" />
    <div class="main-container" :class="collapsed ? 'collapse' : ''">
      <suyanNavbar />
      <router-view />
    </div>
  </div>
</template>

<script setup>
  import suyanSider from './side-menu/index.vue';
  import suyanNavbar from './navbar/index.vue';
  import useAppStore from '/@/store/module/app';
  import { computed } from 'vue';

  const appStore = useAppStore();

  const collapsed = computed(() => appStore.sidebar.open);
</script>

<style lang="scss">
  @use './index.scss';
</style>
