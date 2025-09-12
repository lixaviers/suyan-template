<template>
  <template v-if="!item.children">
    <el-menu-item :index="props.item.path">
      <template #title>
        <component v-if="props.item.meta.icon" :is="props.item.meta.icon" class="el-icon" />
        <span v-if="props.item.meta.title" class="title">{{ props.item.meta.title }}</span>
      </template>
    </el-menu-item>
  </template>
  <el-sub-menu v-else :index="props.item.path">
    <template #title>
      <component v-if="props.item.meta.icon" :is="props.item.meta.icon" class="el-icon" />
      <span v-if="props.item.meta.title" class="title">{{ props.item.meta.title }}</span>
    </template>

    <template v-if="item.children">
      <menuItem v-for="item in item.children" :item="item" />
    </template>
  </el-sub-menu>
</template>

<script setup>
  import { isExternal } from '/@/utils/index';

  const props = defineProps({
    item: {
      type: Object,
    },
  });
</script>
