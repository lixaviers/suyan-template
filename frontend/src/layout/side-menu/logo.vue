<template>
  <div class="logo">
    <router-link class="logo-link" :to="PAGE_PATH_HOME">
      <div v-if="props.collapsed" class="title">后台</div>
      <div v-else class="title">后台管理系统</div>
    </router-link>
  </div>
</template>

<script setup>
  import { PAGE_PATH_HOME } from '/@/constants/common-const';
  const props = defineProps({
    collapsed: {
      type: Boolean,
    },
  });
</script>
