<template>
  <template v-if="theOnlyOneChild && !theOnlyOneChild.children">
    <suyanLink v-if="theOnlyOneChild.meta" :to="resolvePath(theOnlyOneChild.path)">
      <el-menu-item :index="resolvePath(theOnlyOneChild.path)">
        <template #title>
          <component v-if="theOnlyOneChild.meta.icon" :is="theOnlyOneChild.meta.icon" class="el-icon" />
          <span v-if="theOnlyOneChild.meta.title" class="title">{{ theOnlyOneChild.meta.title }}</span>
        </template>
      </el-menu-item>
    </suyanLink>
  </template>
  <el-sub-menu v-else :index="props.item.path">
    <template #title>
      <component v-if="props.item.meta.icon" :is="props.item.meta.icon" class="el-icon" />
      <span v-if="props.item.meta.title" class="title">{{ props.item.meta.title }}</span>
    </template>

    <template v-if="props.item.children">
      <menuItem v-for="item in props.item.children" :item="item" :base-path="resolvePath(item.path)" />
    </template>
  </el-sub-menu>
</template>

<script setup>
  import { computed } from 'vue';
  import { isExternal } from '/@/utils/index';
  import suyanLink from './link.vue';
  import path from 'path-browserify';

  const props = defineProps({
    item: {
      type: Object,
    },
    basePath: String,
  });

  console.log(props.item);
  /**
   * 显示的子菜单
   */
  const showingChildren = computed(() => props.item.children?.filter((child) => !child.meta.hidden) ?? []);

  /**
   * 显示的子菜单数量
   */
  const showingChildNumber = computed(() => showingChildren.value.length);

  /**
   * 唯一的子菜单项
   */
  const theOnlyOneChild = computed(() => {
    const number = showingChildNumber.value;
    switch (true) {
      case number > 1:
        return null;
      case number === 1:
        return showingChildren.value[0];
      default:
        return { ...props.item, path: '' };
    }
  });

  /**
   * 解析路径
   */
  function resolvePath(routePath) {
    switch (true) {
      case isExternal(routePath):
        return routePath;
      case isExternal(props.basePath):
        return props.basePath;
      default:
        return path.resolve(props.basePath, routePath);
    }
  }
</script>
