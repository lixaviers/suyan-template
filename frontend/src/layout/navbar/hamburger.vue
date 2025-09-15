<template>
  <div class="hamburger" @click="onClick">
    <el-icon v-if="props.active" :size="22"><Expand /></el-icon>
    <el-icon v-else :size="22"><Fold /></el-icon>
  </div>
</template>

<script setup>
  const props = defineProps({
    active: {
      type: Boolean,
      default: false,
    },
  });

  const emit = defineEmits();

  const onClick = () => {
    emit('toggleClick');
  };
</script>

<style lang="scss" scoped>
  .hamburger {
    margin: 0 10px;
    line-height: 60px;
    height: 100%;
    float: left;
    cursor: pointer;
    transition: background 0.3s;
    -webkit-tap-highlight-color: transparent;
  }
</style>
