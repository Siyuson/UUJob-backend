<template>
  <el-menu
  ref="myHeader"
  :default-active="activeIndex"
  mode="horizontal"
  @select="handleSelect"
  >

    <!-- <img src="@/assets/logo.png" alt="logo" class="logo"> -->
    <div class="logo">
      LOGO OF UUJOB
    </div>


    <div class="flex-grow" />

    <el-input
      v-model="input1"
      class="myinput"
      size="small"
      placeholder="Please Input"
      :prefix-icon="Search"
    />

    <router-link class="alink" to="../home">
      <el-menu-item index="1">
        <el-icon><HomeFilled /></el-icon>
        <span>首页</span>
      </el-menu-item>
    </router-link>

    <router-link class="alink" to="../myspace">
      <el-menu-item index="2">
        <el-icon><User /></el-icon>
        <span>个人中心</span>
      </el-menu-item>
    </router-link>

    <router-link class="alink" to="../login">
      <el-menu-item index="3">
        <el-icon><SwitchButton /></el-icon>
        <span>退出</span>
      </el-menu-item>
    </router-link>

    <el-menu-item index="5">更多</el-menu-item>
  </el-menu>

</template>
<script>

import { Search } from '@element-plus/icons-vue'
export default {
    data() {
      return {
        activeIndex: '1',
        activeIndex2: '1',
        input1: '',
        Search,
      }
    },
    methods: {
      handleSelect(key, keyPath) {
        console.log(key, keyPath)
      },
    },
  }
</script>

<style>
.alink{
  text-decoration: none;
}

.flex-grow {
  flex-grow: 1;
}

.logo{
  margin-top: 20px;
  font-size: large;
  font-style: italic;
}

.myinput{
  height: 40px;
  width: 300px;
  margin-top: 10px;
  margin-right: 10px;
}
</style>