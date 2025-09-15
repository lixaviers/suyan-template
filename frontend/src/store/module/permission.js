import { defineStore } from 'pinia';
import { routerArray } from '/@/router/routers';

const usePermissionStore = defineStore('permission', {
  state: () => ({
    routes: undefined,
  }),
  actions: {
    setRoutes() {
      this.set();
    },
    set() {
      this.routes = routerArray;
      console.log('routes', this.routes);
    },
  },
});

export default usePermissionStore;
