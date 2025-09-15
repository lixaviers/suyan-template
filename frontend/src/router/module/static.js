import { PAGE_PATH_HOME } from '/@/constants/common-const';
import SuyanLayout from '/@/layout/index.vue';

export const homeRouters = [
  {
    path: '/',
    name: '_home',
    redirect: { path: PAGE_PATH_HOME },
    component: SuyanLayout,
    children: [
      {
        path: PAGE_PATH_HOME,
        name: 'Home',
        meta: {
          title: '首页',
          icon: 'HomeFilled',
          parentMenu: '_home',
        },
        component: () => import('/@/views/HomeView.vue'),
      },
    ],
  },
  {
    path: '/test',
    name: 'test',
    redirect: { path: '/test1' },
    meta: {
      title: '测试1',
      icon: 'HomeFilled',
    },
    component: SuyanLayout,
    children: [
      {
        path: '/test1',
        name: 'test1',
        meta: {
          title: '测试1',
          icon: 'HomeFilled',
          parentMenu: 'test',
        },
        component: () => import('/@/views/test1.vue'),
      },
      {
        path: '/test2',
        name: 'test2',
        meta: {
          title: '测试2',
          icon: 'HomeFilled',
          parentMenu: 'test',
        },
        component: () => import('/@/views/test2.vue'),
      },
    ],
  },
];

export const loginRouters = [
  {
    path: '/login',
    name: 'Login',
    meta: {
      hidden: true,
    },
    component: () => import('/@/views/login/index.vue'),
  },
];
