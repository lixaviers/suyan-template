<template>
  <el-breadcrumb>
    <el-breadcrumb-item v-for="(item, index) in breadcrumbs" :key="item.path">
      <span v-if="item.redirect === 'noRedirect' || index === breadcrumbs.length - 1" class="no-redirect">
        {{ item.meta.title }}
      </span>
      <a v-else @click.prevent="onLink(item)">
        {{ item.meta.title }}
      </a>
    </el-breadcrumb-item>
  </el-breadcrumb>
</template>

<script setup>
  import { computed, ref } from 'vue';
  import { useRouteListener } from '/@/utils/useRouteListener';
  import { useRoute, useRouter } from 'vue-router';

  const { listenerRouteChange } = useRouteListener();
  const route = useRoute();
  const router = useRouter();

  const breadcrumbs = ref([]);

  /**
   * 获取面包屑导航信息
   */
  const getBreadcrumb = () => {
    breadcrumbs.value = route.matched.filter((item) => item.meta.title);
  };

  /**
   * 处理面包屑导航点击事件
   */
  function onLink(item) {
    const { redirect, path } = item;
    if (redirect) return router.push(redirect);
    router.push(pathCompile(path));
  }

  /**
   * 监听路由变化，更新面包屑导航信息
   */
  listenerRouteChange((route) => {
    if (route.path.startsWith('/redirect/')) return;
    getBreadcrumb();
  }, true);
</script>

<style lang="scss" scoped>
  .el-breadcrumb {
    line-height: 50px;
    flex: 1;
    .no-redirect {
      color: var(--el-text-color-placeholder);
    }
    a {
      font-weight: normal;
    }
  }
</style>
