import { ref, watchEffect } from 'vue';
import { getVisitedViewsCache, setVisitedViewsCache, getCachedViewsCache, setCachedViewsCache } from '/@/utils/cache';

import { defineStore } from 'pinia';

export const useTagsViewStore = defineStore('tags-view', () => {
  const visitedViews = ref(getVisitedViewsCache());
  const cachedViews = ref(getCachedViewsCache());

  // 缓存标签栏数据
  watchEffect(() => {
    setVisitedViewsCache(visitedViews.value);
    setCachedViewsCache(cachedViews.value);
  });

  const addVisitedView = (view) => {
    // 检查是否已经存在相同的 visitedView
    const index = visitedViews.value.findIndex((v) => v.path === view.path);
    if (index !== -1) {
      // 防止 query 参数丢失
      visitedViews.value[index].fullPath !== view.fullPath && (visitedViews.value[index] = { ...view });
    } else {
      // 添加新的 visitedView
      visitedViews.value.push({ ...view });
    }
  };

  const addCachedView = (view) => {
    if (typeof view.name !== 'string') return;
    if (cachedViews.value.includes(view.name)) return;
    if (view.meta?.keepAlive) {
      cachedViews.value.push(view.name);
    }
  };

  const delVisitedView = (view) => {
    const index = visitedViews.value.findIndex((v) => v.path === view.path);
    if (index !== -1) {
      visitedViews.value.splice(index, 1);
    }
  };

  const delCachedView = (view) => {
    if (typeof view.name !== 'string') return;
    const index = cachedViews.value.indexOf(view.name);
    if (index !== -1) {
      cachedViews.value.splice(index, 1);
    }
  };

  const delOthersVisitedViews = (view) => {
    visitedViews.value = visitedViews.value.filter((v) => {
      return v.meta?.affix || v.path === view.path;
    });
  };

  const delOthersCachedViews = (view) => {
    if (typeof view.name !== 'string') return;
    const index = cachedViews.value.indexOf(view.name);
    if (index !== -1) {
      cachedViews.value = cachedViews.value.slice(index, index + 1);
    } else {
      cachedViews.value = [];
    }
  };

  const delAllVisitedViews = () => {
    visitedViews.value = visitedViews.value.filter((tag) => tag.meta?.affix);
  };

  const delAllCachedViews = () => {
    cachedViews.value = [];
  };

  return {
    visitedViews,
    cachedViews,
    addVisitedView,
    addCachedView,
    delVisitedView,
    delCachedView,
    delOthersVisitedViews,
    delOthersCachedViews,
    delAllVisitedViews,
    delAllCachedViews,
  };
});
