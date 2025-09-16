<template>
  <div class="navbar">
    <hamburger :active="appStore.sidebar.open" @toggle-click="onClickHamburger" />
    <breadcrumbs class="breadcrumb" />
    <rightMenu class="right-menu" />
  </div>
</template>

<script setup>
  import hamburger from './hamburger.vue';
  import breadcrumbs from './breadcrumb.vue';
  import rightMenu from './right-menu.vue';
  import useAppStore from '/@/store/module/app';

  const appStore = useAppStore();

  function onClickHamburger() {
    appStore.setSidebarOpen();
  }
</script>
