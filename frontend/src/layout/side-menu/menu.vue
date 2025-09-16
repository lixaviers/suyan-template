<template>
  <el-menu
    background-color="#545c64"
    text-color="#ffffffa6"
    active-text-color="#fff"
    :collapse="props.collapsed"
    :default-active="activeMenu"
    @open="handleOpen"
    @close="handleClose"
    mode="vertical"
  >
    <menuItem v-for="item in noHiddenRoutes" :item="item" :base-path="item.path" />
  </el-menu>
</template>

<script setup>
  import { computed, ref } from 'vue';
  import { useRoute } from 'vue-router';
  import menuItem from './menu-item.vue';
  import usePermissionStore from '/@/store/module/permission';

  const route = useRoute();
  const permissionStore = usePermissionStore();

  const props = defineProps({
    collapsed: {
      type: Boolean,
      default: false,
    },
  });

  const activeMenu = computed(() => route.meta.activeMenu || route.path);
  const noHiddenRoutes = computed(() => permissionStore.routes.filter((item) => !item.meta?.hidden));

  const handleOpen = (key, keyPath) => {
    // console.log(key, keyPath);
  };
  const handleClose = (key, keyPath) => {
    // console.log(key, keyPath);
  };
</script>
