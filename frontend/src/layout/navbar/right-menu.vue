<template>
  <el-dropdown>
    <div class="right-menu-item">
      <el-avatar src="https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png" :size="30" />
      <span>管理员</span>
    </div>
    <template #dropdown>
      <el-dropdown-menu>
        <a target="_blank" href="https://github.com/lixaviers/suyan-template">
          <el-dropdown-item>GitHub</el-dropdown-item>
        </a>
        <el-dropdown-item divided @click="logout"> 退出登录 </el-dropdown-item>
      </el-dropdown-menu>
    </template>
  </el-dropdown>
</template>

<script setup>
  const logout = () => {
    console.log('等待实现');
  };
</script>
