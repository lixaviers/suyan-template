<template>
  <div class="login-container">
    <div class="login-background">
      <div class="decoration-circle circle-1"></div>
      <div class="decoration-circle circle-2"></div>
      <div class="decoration-circle circle-3"></div>
    </div>

    <el-card class="login-card">
      <div class="logo-section">
        <div class="logo">
          <i class="fas fa-lock"></i>
        </div>
        <h2>欢迎登录</h2>
        <p>请输入您的账号和密码</p>
      </div>

      <el-form :model="loginForm" :rules="loginRules" ref="loginFormRef" class="login-form" @keyup.enter="handleLogin">
        <el-form-item prop="username">
          <el-input v-model="loginForm.username" placeholder="请输入用户名" size="large" :prefix-icon="User" />
        </el-form-item>

        <el-form-item prop="password">
          <el-input v-model="loginForm.password" type="password" placeholder="请输入密码" size="large" :prefix-icon="Lock" show-password />
        </el-form-item>

        <el-form-item>
          <el-button class="login-btn" type="primary" size="large" :loading="loading" @click="handleLogin">
            {{ loading ? '登录中...' : '登录' }}
          </el-button>
        </el-form-item>
      </el-form>
    </el-card>
  </div>
</template>

<script setup>
  import { ref, reactive } from 'vue';
  import { ElMessage } from 'element-plus';
  import { User, Lock } from '@element-plus/icons-vue';
  import { setToken } from '/@/utils/cache';
  import { PAGE_PATH_HOME } from '/@/constants/common-const';

  const router = useRouter();

  // 表单数据
  const loginForm = reactive({
    username: '',
    password: '',
  });

  // 表单验证规则
  const loginRules = reactive({
    username: [
      { required: true, message: '请输入用户名', trigger: 'blur' },
      { min: 3, message: '用户名长度不能少于3个字符', trigger: 'blur' },
    ],
    password: [
      { required: true, message: '请输入密码', trigger: 'blur' },
      { min: 6, message: '密码长度不能少于6个字符', trigger: 'blur' },
    ],
  });

  // 引用和状态
  const loginFormRef = ref();
  const loading = ref(false);

  // 登录处理
  const handleLogin = async () => {
    if (!loginFormRef.value) return;

    try {
      const valid = await loginFormRef.value.validate();
      if (!valid) return;

      loading.value = true;
      // 模拟登录请求
      setTimeout(() => {
        loading.value = false;
        ElMessage.success('登录成功！');
        setToken('11111');
        router({ path: PAGE_PATH_HOME });
      }, 1500);
    } catch (error) {
      loading.value = false;
      ElMessage.error('请正确填写表单');
    }
  };
</script>

<style lang="scss" scoped>
  .login-container {
    display: flex;
    justify-content: center;
    align-items: center;
    min-height: 100vh;
    background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
    position: relative;
    overflow: hidden;

    .login-background {
      position: absolute;
      width: 100%;
      height: 100%;
      top: 0;
      left: 0;
      z-index: 0;
    }

    .decoration-circle {
      position: absolute;
      border-radius: 50%;
      background: rgba(255, 255, 255, 0.1);
    }

    .circle-1 {
      width: 300px;
      height: 300px;
      bottom: -150px;
      left: -150px;
    }

    .circle-2 {
      width: 200px;
      height: 200px;
      top: -100px;
      right: -100px;
    }

    .circle-3 {
      width: 150px;
      height: 150px;
      top: 20%;
      right: 10%;
    }

    .login-card {
      width: 400px;
      padding: 30px;
      border-radius: 12px;
      box-shadow: 0 15px 35px rgba(0, 0, 0, 0.2);
      background: rgba(255, 255, 255, 0.95);
      z-index: 1;
      transition: all 0.3s ease;

      &:hover {
        transform: translateY(-5px);
        box-shadow: 0 20px 40px rgba(0, 0, 0, 0.25);
      }
    }

    .logo-section {
      text-align: center;
      margin-bottom: 30px;

      .logo {
        width: 70px;
        height: 70px;
        margin: 0 auto 15px;
        background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
        border-radius: 50%;
        display: flex;
        align-items: center;
        justify-content: center;
        color: white;
        font-size: 30px;
      }

      h2 {
        color: #333;
        margin-bottom: 8px;
        font-weight: 600;
      }

      p {
        color: #666;
        font-size: 14px;
      }
    }

    .login-form {
      margin-top: 20px;

      :deep(.el-input__wrapper) {
        border-radius: 8px;
      }
    }

    .login-btn {
      width: 100%;
      height: 48px;
      font-size: 16px;
      border-radius: 8px;
      background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
      border: none;
      transition: all 0.3s;

      &:hover {
        transform: scale(1.02);
        box-shadow: 0 5px 15px rgba(102, 126, 234, 0.4);
      }
    }
  }
</style>
