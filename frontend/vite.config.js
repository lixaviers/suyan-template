import { defineConfig } from 'vite';
import vue from '@vitejs/plugin-vue';
import { resolve } from 'path';

const pathResolve = (dir) => {
  return resolve(__dirname, '.', dir);
};

// https://vite.dev/config/
export default defineConfig({
  resolve: {
    alias: [
      {
        find: /\/@\//,
        replacement: pathResolve('src') + '/',
      },
    ],
  },
  plugins: [vue()],
  server: {
    port: 9001,
    host: true,
    open: true,
  },
});
