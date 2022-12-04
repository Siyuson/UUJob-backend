<template>  
    <el-card class="box-card">
        <el-descriptions
        class="margin-top"
        title="我的简历"
        :column="3"
        border
        >
            <template #extra>
                <el-button type="primary">Operation</el-button>
            </template>
            <el-descriptions-item>
                <template #label>
                <div class="cell-item">
                    <el-icon>
                    <user />
                    </el-icon>
                    Username
                </div>
                </template>
                kooriookami
            </el-descriptions-item>
            <el-descriptions-item>
                <template #label>
                <div class="cell-item">
                    <el-icon>
                    <iphone />
                    </el-icon>
                    Telephone
                </div>
                </template>
                18100000000
            </el-descriptions-item>
            <el-descriptions-item>
                <template #label>
                <div class="cell-item">
                    <el-icon>
                    <location />
                    </el-icon>
                    Place
                </div>
                </template>
                Suzhou
            </el-descriptions-item>
            <el-descriptions-item>
                <template #label>
                <div class="cell-item">
                    <el-icon>
                    <tickets />
                    </el-icon>
                    学历
                </div>
                </template>
                本科
            </el-descriptions-item>
            <el-descriptions-item>
                <template #label>
                <div class="cell-item">
                    <el-icon>
                    <office-building />
                    </el-icon>
                    Address
                </div>
                </template>
                No.1188, Wuzhong Avenue, Wuzhong District, Suzhou, Jiangsu Province
            </el-descriptions-item>
            
            </el-descriptions>

            <el-descriptions
                class="margin-top"
                direction="vertical"
                :column="1"
                border>
                <el-descriptions-item>
                    <template #label>
                        <div class="cell-item">
                           详细描述
                        </div>
                        </template>
                        空
                </el-descriptions-item>
            </el-descriptions>
        </el-card>
    
  
   
  </template>
  
  <script setup lang="ts">
  import { computed, ref } from 'vue'
  import {
    Iphone,
    Location,
    OfficeBuilding,
    Tickets,
    User,
  } from '@element-plus/icons-vue'
  
  
  </script>
  
  <style scoped>
  .el-descriptions {
    margin-top: 20px;
  }
  .cell-item {
    display: flex;
    align-items: center;
  }
  .margin-top {
    margin-top: 20px;
  }
  </style>
  