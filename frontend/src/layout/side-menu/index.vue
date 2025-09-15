<template>
  <div>
    <suyanLogo :collapsed="props.collapsed" />
    <el-scrollbar wrap-class="scrollbar-wrapper">
      <suyanMenu :collapsed="props.collapsed" ref="menuRef" />
    </el-scrollbar>
  </div>
</template>

<script setup>
  import suyanMenu from './menu.vue';
  import suyanLogo from './logo.vue';

  const props = defineProps({
    collapsed: {
      type: Boolean,
      default: false,
    },
  });
</script>
