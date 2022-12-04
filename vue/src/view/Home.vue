<template>
    <div class="home" style="height:100%">
        <el-container>
              <div class="main">
                  <div class="recruit">
                    <RecruitArea></RecruitArea>
                  </div>

                  <div class="function">
                    <FunctionArea></FunctionArea>
                  </div>

                  
              </div>
        </el-container>
    </div>
</template>

<script lang="ts">
import  RecruitArea   from "@/components/home/RecruitArea.vue";
import FunctionArea from "@/components/home/FunctionArea.vue";

export default{
    name:"Home",
    components:{
      RecruitArea,
      FunctionArea,
    },

};
</script>

<style>
.home{
    background-color: rgb(245, 245, 245);
    width: 100%;
    height: 100%;
    position: absolute;
    left: 0;
}
.main{
  width: 100%;
  height: 100%;
}

.recruit{
  float: left;
  position: relative;
  left: 20%;
}

.function{
  float: right;
  position: relative;
  right: 10%;
}


.el-row {
    margin-bottom: 20px;
  }
  .el-row:last-child {
    margin-bottom: 0;
  }
  .el-col {
    border-radius: 4px;
  }
  
  .grid-content {
    border-radius: 4px;
    min-height: 36px;
  }

</style>