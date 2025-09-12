<template>
  <div class="home">
    <el-card class="mb-4">
      <template #header>
        <div class="card-header">
          <span>欢迎使用 Vue 3 项目</span>
        </div>
      </template>
      <div>
        <el-button type="primary" @click="count++">点击计数</el-button>
        <p class="mt-4">计数: {{ count }}</p>
      </div>
    </el-card>
    <el-card>
      <template #header>
        <div class="card-header">
          <span>功能导航</span>
        </div>
      </template>
      <div class="flex gap-4">
        <el-button @click="$router.push('/about')">关于页面</el-button>
        <el-button type="success" @click="saveCount">保存计数</el-button>
      </div>
    </el-card>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import { useCounterStore } from '../store/counter'
import { ElMessage } from 'element-plus'

const count = ref(0)
const counterStore = useCounterStore()

const saveCount = () => {
  counterStore.setCount(count.value)
  counterStore.saveToLocal()
  ElMessage.success('计数已保存')
}
</script>

<style scoped>
.home {
  padding: 20px;
}

.card-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.flex {
  display: flex;
}

.gap-4 {
  gap: 16px;
}

.mt-4 {
  margin-top: 16px;
}

.mb-4 {
  margin-bottom: 16px;
}
</style>