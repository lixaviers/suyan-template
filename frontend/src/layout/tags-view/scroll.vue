<template>
  <el-scrollbar ref="scrollContainerRef" :vertical="false" class="scroll-container">
    <slot />
  </el-scrollbar>
</template>

<script setup>
  import { computed, nextTick, onMounted, ref } from 'vue';
  import { useRoute } from 'vue-router';
  import { useTagsViewStore } from '/@/store/module/tags-view';
  import { useRouteListener } from '/@/utils/useRouteListener';

  const route = useRoute();
  const tagsViewStore = useTagsViewStore();
  const { listenerRouteChange } = useRouteListener();

  const scrollContainerRef = ref();

  const visitedViews = computed(() => tagsViewStore.visitedViews);

  function moveToTarget() {
    const container = scrollContainerRef.value.$el;
    const containerWidth = container.offsetWidth;
    const scrollWrapper = scrollContainerRef.value;

    let firstTag = null;
    let lastTag = null;

    if (visitedViews.value.length > 0) {
      firstTag = visitedViews.value[0];
      lastTag = visitedViews.value[visitedViews.value.length - 1];
    }

    if (firstTag.name === route.name || firstTag.path === route.path) {
      scrollWrapper.setScrollLeft(0);
    } else {
      const tagListDom = document.getElementsByClassName('tags-view-item');

      let scrollWidth = 0;
      for (const k in tagListDom) {
        if (k !== 'length' && Object.hasOwnProperty.call(tagListDom, k)) {
          scrollWidth += tagListDom[k].scrollWidth + 12;
          if (tagListDom[k].dataset.path === route.path) {
            break;
          }
        }
      }
      if (scrollWidth > containerWidth) {
        scrollWrapper.setScrollLeft(scrollWidth - containerWidth);
      } else {
        scrollWrapper.setScrollLeft(0);
      }
    }
  }

  onMounted(() => {
    nextTick(() => {
      moveToTarget();
    });
  });

  listenerRouteChange(() => {
    nextTick(moveToTarget());
  });
</script>

<style lang="scss" scoped>
  .scroll-container {
    white-space: nowrap;
    position: relative;
    overflow: hidden;
    width: 100%;
    :deep(.el-scrollbar__bar) {
      bottom: 0px;
    }
  }
</style>
