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
          icon: 'HomeOutlined',
          parentMenu: '_home',
        },
        component: () => import('/@/views/HomeView.vue'),
      },
    ],
  },
];

export const loginRouters = [
  {
    path: '/login',
    name: 'Login',
    component: () => import('/@/views/login/index.vue'),
  },
];
