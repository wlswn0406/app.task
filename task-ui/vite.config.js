import { defineConfig, loadEnv } from 'vite'
import react from '@vitejs/plugin-react'
import path from 'path'

export default defineConfig(({ mode }) => {

  const env = loadEnv(mode, process.cwd());

  return {
    plugins: [react()],
    server: {
      port: parseInt(env.VITE_PORT),
    },
    resolve: {
      alias: {
        '@': path.resolve(__dirname, 'src'),
      },
    },
  }

})