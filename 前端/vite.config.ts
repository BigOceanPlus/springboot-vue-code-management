import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [vue()],

  server: {
    //https: true, //(使用https)启用 TLS + HTTP/2。注意：当 server.proxy 选项 也被使用时，将会仅使用 TLS
    host: true, // 监听所有地址
    port: 80, //指定开发服务器端口：默认80
    open: true, //启动时自动在浏览器中打开
  }

  
  
})
