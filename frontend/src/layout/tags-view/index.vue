<template>
  <div class="tags-view-container">
    <div class="tags-view">
      <suyanScroll>
        <router-link
          v-for="item in tagsViewStore.visitedViews"
          :to="{ path: item.path, query: item.query }"
          :data-path="item.path"
          class="tags-view-item"
          :class="{ active: isActive(item), affix: isAffix(item) }"
        >
          {{ item.meta?.title }}
          <el-icon v-if="!isAffix(item)" :size="12" @click.prevent.stop="closeSelectedTag(item)">
            <Close />
          </el-icon>
        </router-link>
      </suyanScroll>
    </div>
    <el-dropdown @command="onCommand">
      <div class="tags-view-operate">
        <div class="tags-view-operate-icon">
          <el-icon><Menu /></el-icon>
        </div>
      </div>
      <template #dropdown>
        <el-dropdown-menu>
          <el-dropdown-item command="closeOther">关闭其他</el-dropdown-item>
          <el-dropdown-item command="closeAll">关闭所有</el-dropdown-item>
        </el-dropdown-menu>
      </template>
    </el-dropdown>
  </div>
</template>

<script setup>
  import { onMounted, ref } from 'vue';
  import { useRoute, useRouter } from 'vue-router';
  import { useTagsViewStore } from '/@/store/module/tags-view';
  import usePermissionStore from '/@/store/module/permission';
  import path from 'path-browserify';
  import { useRouteListener } from '/@/utils/useRouteListener';
  import suyanScroll from './scroll.vue';

  const route = useRoute();
  const router = useRouter();
  const tagsViewStore = useTagsViewStore();
  const permissionStore = usePermissionStore();
  const { listenerRouteChange } = useRouteListener();

  const affixTags = ref([]);

  /**
   * 判断标签页是否激活
   */
  function isActive(tag) {
    return tag.path === route.path;
  }

  /**
   * 判断标签页是否固定
   */
  function isAffix(tag) {
    return tag.meta?.affix;
  }

  /**
   * 筛选出固定标签页
   */
  function filterAffixTags(routes, basePath = '/') {
    const tags = [];
    routes.forEach((route) => {
      if (isAffix(route)) {
        const tagPath = path.resolve(basePath, route.path);
        tags.push({
          fullPath: tagPath,
          path: tagPath,
          name: route.name,
          meta: { ...route.meta },
        });
      }
      if (route.children) {
        const childTags = filterAffixTags(route.children, route.path);
        tags.push(...childTags);
      }
    });
    return tags;
  }

  /**
   * 添加标签页
   */
  function addTags(route) {
    if (route.name) {
      tagsViewStore.addVisitedView(route);
      tagsViewStore.addCachedView(route);
    }
  }

  const closeSelectedTag = (view) => {
    tagsViewStore.delVisitedView(view);
    tagsViewStore.delCachedView(view);
    isActive(view) && toLastView(tagsViewStore.visitedViews);
  };

  /**
   * 跳转到最后一个标签页
   */
  function toLastView(visitedViews) {
    const latestView = visitedViews.slice(-1)[0];
    const fullPath = latestView?.fullPath;
    if (fullPath !== undefined) {
      router.push(fullPath);
    } else {
      router.push({ path: affixTags.value[0].path, query: affixTags.value[0].query });
    }
  }

  function onCommand(command) {
    if (command === 'closeOther') {
      tagsViewStore.delOthersVisitedViews(route);
      tagsViewStore.delOthersCachedViews(route);
    } else if (command === 'closeAll') {
      tagsViewStore.delAllVisitedViews();
      tagsViewStore.delAllCachedViews();
      if (affixTags.value.some((tag) => tag.path === route.path)) return;
      toLastView(tagsViewStore.visitedViews);
    }
  }

  /**
   * 初始化标签页
   */
  function initTags() {
    affixTags.value = filterAffixTags(permissionStore.routes);
    for (const tag of affixTags.value) {
      // 必须含有 name 属性
      tag.name && tagsViewStore.addVisitedView(tag);
    }
  }

  initTags();

  // 监听路由变化
  listenerRouteChange((route) => {
    addTags(route);
  }, true);
</script>
