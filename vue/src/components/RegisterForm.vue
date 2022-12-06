<!-- 自定义注册组件 -->
<template>
  <el-form
    ref="registerForm"
    :model="registerUser"
    :rules="registerRules"
    label-width="100px"
    class="registerForm sign-up-form"
  >
    <el-form-item label="账号" prop="account">
      <el-input
        v-model="registerUser.account"
        placeholder="Enter Account..."
      ></el-input>
    </el-form-item>
    <el-form-item label="姓名" prop="name">
      <el-input
          v-model="registerUser.name"
          placeholder="Enter UserName..."
      ></el-input>
    </el-form-item>
    <el-form-item label="密码" prop="password">
      <el-input
        v-model="registerUser.password"
        type="password"
        placeholder="Enter Password..."
      ></el-input>
    </el-form-item>
    <el-form-item label="确认密码" prop="password2">
      <el-input
        v-model="registerUser.password2"
        type="password"
        placeholder="Enter Password..."
      ></el-input>
    </el-form-item>
    <el-form-item label="电话号码" prop="phoneNumber">
      <el-input
        v-model="registerUser.phone"
        placeholder="Enter PhoneNumber..."
      ></el-input>
    </el-form-item>
    <el-form-item label="选择身份">
      <el-select v-model="registerUser.role" placeholder="请选择身份">
        <el-option label="求职者" value=0></el-option>
        <el-option label="招聘者" value=1></el-option>
      </el-select>
    </el-form-item>

    <el-form-item>
      <el-button
        @click="handleRegister('registerForm')"
        type="primary"
        class="submit-btn"
        >注册</el-button
      >
    </el-form-item>
  </el-form>
</template>

<script lang="ts">
import { ref, getCurrentInstance } from "vue";
import { useStore } from "vuex";
import axios from "axios";
import { tr } from 'element-plus/es/locale';
// import axios from 'axios' // 仅限在当前组件使用
export default {
  props: {
    registerUser: {
      type: Object,
      required: true,
    },
    registerRules: {
      type: Object,
      required: true,
    },
  },
  setup() {
    // @ts-ignore
    const { ctx } = getCurrentInstance();
    const store = useStore();

    //注册按钮响应函数
    const handleRegister = (formName: string) => {
      ctx.$refs[formName].validate((valid: boolean) => {
        if (true) {
          alert("submit!");
          axios({
            method: "post",
            url: "http://localhost:9090/user/register",
            data: {
              account: ctx.registerUser.account,
              password: ctx.registerUser.password,
              name: ctx.registerUser.name,
              phone: ctx.registerUser.phone,
              role: ctx.registerUser.role
            },
          }).then(function(response){
            // 注册成功
            if(response.data.code == 0){
                alert("注册成功");
                console.log(response.data.data);
            }
            // 注册失败提示信息
            else{
                alert(response.data.msg);
            }
          });
          console.log(store.state.userId);
        } else {
          console.log("error submit!!");

          return false;
        }
      });
    };
    return { handleRegister };
  },
};
</script>
<style scoped>
</style>
