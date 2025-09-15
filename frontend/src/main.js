import { createApp } from 'vue';
import './style.css';
import App from './App.vue';

// 引入 Element Plus
import ElementPlus from 'element-plus';
import 'element-plus/dist/index.css';
import * as ElementPlusIconsVue from '@element-plus/icons-vue';

// 引入 Vue Router
import { router } from './router';

// 引入 Pinia
import pinia from './store';

const app = createApp(App);

app.use(ElementPlus);
app.use(router);
app.use(pinia);

for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
  app.component(key, component);
}

// router 准备就绪后挂载应用
router.isReady().then(() => {
  app.mount('#app');
});
