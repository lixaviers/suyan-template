import { defineStore } from 'pinia';

import { getSidebarOpenCache, setSidebarOpenCache } from '/@/utils/cache';

const useAppStore = defineStore('app', {
  state: () => ({
    sidebar: {
      open: getSidebarOpenCache(),
    },
  }),
  actions: {
    setSidebarOpen() {
      this.sidebar.open = !this.sidebar.open;
      console.log(this.sidebar.open);
      setSidebarOpenCache(this.sidebar.open);
    },
  },
});

export default useAppStore;
