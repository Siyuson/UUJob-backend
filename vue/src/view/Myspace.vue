<template>
  <div class="myspace">
    <el-container class="myspace">
      <el-aside >
        <el-radio-group v-model="isCollapse" >
          <el-radio-button :label="!isCollapse">
            <el-icon ><Grid /></el-icon>
          </el-radio-button>
        </el-radio-group>
        <el-menu
          default-active="2"
          class="el-menu-vertical-demo"
          :collapse="isCollapse"
          @open="handleOpen"
          @close="handleClose"
        >
      
          <router-link class="alink" to="../myspace/userInfo">
            <el-menu-item index="1">
              <el-icon><User /></el-icon>
              <template #title>
                我的账户信息
              </template>
            </el-menu-item>
          </router-link>
      
          <router-link class="alink" to="../myspace/myProfile">
            <el-menu-item index="2">
              <el-icon><icon-menu /></el-icon>
              <template #title>我的简历</template>
            </el-menu-item>
          </router-link>
          
          <router-link class="alink" to="../myspace/historyPostList">
            <el-menu-item index="3">
              <el-icon><document /></el-icon>
              <template #title>历史投递列表</template>
            </el-menu-item>
          </router-link>
          
          <router-link class="alink" to="../myspace/sysNotice">
            <el-menu-item index="4">
              <el-icon><setting /></el-icon>
              <template #title>通知</template>
            </el-menu-item>
          </router-link>
        </el-menu>
      </el-aside>
  
      <el-main class="pro">
        <div style="width: 80% ; float:left">
          <router-view></router-view>
        </div>
      </el-main>
    </el-container>
  </div>
  
  
</template>

<script lang="ts" setup>
import { ref } from 'vue'
import {
  Document,
  Menu as IconMenu,
  User,
  Setting,
} from '@element-plus/icons-vue'

const isCollapse = ref(true)

const handleOpen = (key: string, keyPath: string[]) => {
  console.log(key, keyPath)
}
const handleClose = (key: string, keyPath: string[]) => {
  console.log(key, keyPath)
}
</script>

<style>
.el-menu-vertical-demo:not(.el-menu--collapse) {
  width: 150px;
  min-height: 600px;
}
.alink{
  text-decoration: none;
}


.myspace{
  background-color: rgb(245, 245, 245);
    width: 100%;
    height: 100%;
    position: absolute;
    left: 0;
}
</style>
