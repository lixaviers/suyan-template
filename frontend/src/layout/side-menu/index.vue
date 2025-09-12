<template>
  <div>
    <suyanLogo />
    <el-scrollbar wrap-class="scrollbar-wrapper">
      <suyanMenu :collapsed="collapsed" ref="menuRef" />
    </el-scrollbar>
  </div>
</template>

<script setup>
  import { ref } from 'vue';
  import suyanMenu from './menu.vue';
  import suyanLogo from './logo.vue';

  const collapsed = ref(false);
</script>
