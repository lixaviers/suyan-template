import { createRouter, createWebHashHistory } from 'vue-router';
import nProgress from 'nprogress';
import 'nprogress/nprogress.css';
import { PAGE_PATH_404, PAGE_PATH_LOGIN, PAGE_PATH_HOME } from '/@/constants/common-const';
import { getToken } from '/@/utils/cache';
import { routerArray } from './routers';
import { setRouteChange } from '/@/utils/useRouteListener';
import usePermissionStore from '/@/store/module/permission';

export const router = createRouter({
  history: createWebHashHistory(),
  routes: routerArray,
  strict: true,
  scrollBehavior: () => ({ left: 0, top: 0 }),
});

// ----------------------- 路由加载前 -----------------------
router.beforeEach(async (to, from, next) => {
  nProgress.start();

  if (to.path === PAGE_PATH_404) {
    next();
    return;
  }

  // 验证是否登录
  const token = getToken();
  if (!token) {
    if (to.path === PAGE_PATH_LOGIN) {
      next();
    } else {
      next({ path: PAGE_PATH_LOGIN });
    }
    return;
  }
  const permissionStore = usePermissionStore();
  permissionStore.setRoutes();

  // 登录页，则跳转到首页
  if (to.path === PAGE_PATH_LOGIN) {
    next({ path: PAGE_PATH_HOME });
    return;
  }

  next();
});

// ----------------------- 路由加载后 -----------------------
router.afterEach((to) => {
  console.log(to);
  setRouteChange(to);
  nProgress.done();
});
