<!-- 登录自定义组件 -->
<template>
  <el-form
    ref="loginForm"
    :model="loginUser"
    :rules="rules"
    label-width="100px"
    class="loginForm sign-in-form"
  >
    <el-form-item label="账号" prop="account">
      <el-input
        v-model="loginUser.account"
        placeholder="Enter your user name..."
      ></el-input>
    </el-form-item>
    <el-form-item label="密码" prop="password">
      <el-input
        v-model="loginUser.password"
        type="password"
        placeholder="Enter Password..."
      ></el-input>
    </el-form-item>

    <el-form-item>
      <el-button
        @click="handleLogin('loginForm')"
        type="primary"
        class="submit-btn"
        >提交</el-button
      >
    </el-form-item>

    <!-- 找回密码 -->
    <div class="tiparea">
      <p>忘记密码？ <a>立即找回</a></p>
    </div>
  </el-form>
</template>

<script lang="ts">
import { loginUser } from "@/utils/loginValidators";
import { ref, getCurrentInstance } from "vue";
import { useRouter } from "vue-router";
import { useStore } from "vuex";
import axios from "axios";
export default {
  components: {},
  props: {
    loginUser: {
      type: Object,
      required: true,
    },
    rules: {
      type: Object,
      required: true,
    },
  },
  setup() {
    // @ts-ignore
    const { ctx } = getCurrentInstance(); //获取实例
    const store = useStore();
    const router = useRouter();
    console.log(store.state.userId);

    // 触发登录方法
    const handleLogin = (formName: string) => {
      ctx.$refs[formName].validate((valid: boolean) => {
        if (valid) {
          alert("submit!");
          axios({
            method: "post",
            url: "http://localhost:9090/user/login",
            data: {
              account: ctx.loginUser.account,
              password: ctx.loginUser.password,
            },
          }).then(function (response) {
            // 登录成功
            if (response.data.code === 0) {
              // alert("登录成功");
              console.log(response.data.data);
              /*修改全局用户变量*/
              var userId = response.data.data.id;
              store.commit("set", userId);
              router.push("/");
            } // 登录失败输出错误信息
            else {
              alert(response.data.msg);
            }
          });
        } else {
          console.log("error submit!!");
          return false;
        }
      });
    };

    return { handleLogin };
  },
};
</script>
<style scoped>
/* form */
.loginForm {
  margin-top: 20px;
  background-color: #fff;
  padding: 20px 40px 20px 20px;
  border-radius: 5px;
  box-shadow: 0px 5px 10px #cccc;
}

.submit-btn {
  width: 100%;
}
.tiparea {
  text-align: right;
  font-size: 12px;
  color: #333;
}
.tiparea p a {
  color: #409eff;
}
</style>
