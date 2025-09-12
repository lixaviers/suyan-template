<template>
  <el-menu
    background-color="#545c64"
    text-color="#fff"
    active-text-color="#ffd04b"
    :collapse="props.collapsed"
    :default-active="activeMenu"
    @open="handleOpen"
    @close="handleClose"
    mode="vertical"
  >
    <menuItem v-for="item in menuList" :item="item" />
  </el-menu>
</template>

<script setup>
  import { computed, ref } from 'vue';
  import { useRoute } from 'vue-router';
  import menuItem from './menu-item.vue';

  const route = useRoute();

  const props = defineProps({
    collapsed: {
      type: Boolean,
      default: false,
    },
  });

  const activeMenu = computed(() => route.meta.activeMenu || route.path);

  const menuList = [
    {
      path: '/1',
      name: '2',
      meta: { title: '1', icon: 'Plus' },
      component: undefined,
      children: [{ path: '/111', name: '111', meta: { title: '4', icon: 'Plus' }, component: undefined }],
    },
    { path: '/2', name: '2', meta: { title: '2', icon: 'Plus' }, component: undefined },
    { path: '/3', name: '3', meta: { title: '3', icon: 'Plus' }, component: undefined },
  ];

  const handleOpen = (key, keyPath) => {
    console.log(key, keyPath);
  };
  const handleClose = (key, keyPath) => {
    console.log(key, keyPath);
  };
</script>
