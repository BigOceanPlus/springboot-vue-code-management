import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [vue()],

  server: {
    //https: true, //(ʹ��https)���� TLS + HTTP/2��ע�⣺�� server.proxy ѡ�� Ҳ��ʹ��ʱ�������ʹ�� TLS
    host: true, // �������е�ַ
    port: 80, //ָ�������������˿ڣ�Ĭ��80
    open: true, //����ʱ�Զ���������д�
  }

  
  
})
