<template>
  <el-contianer>
    <el-header class="header">
      <el-page-header
          @back="goBack"
          content="意见反馈"
          class="page-header"
      ></el-page-header>
    </el-header>

    <el-main>
      <div class="comment">
        <el-input
            v-model="comment"
            style="width: 100%;margin: auto"
            :autosize="{ minRows: 4, maxRows: 10}"
            type="textarea"
            placeholder="请输入你的意见"
        />
        <el-button type="primary" @click="submit" class="submit-button">提交意见</el-button>
      </div>
    </el-main>
  </el-contianer>
</template>

<script>
import axios from 'axios';
export default {
  name: 'commentPage',
  data() {
    return {
      comment:null
    };
  },
  methods: {
    goBack() {
      this.$router.push('/');
    },
    submit(){
      if(this.comment===null) alert("请填入意见！")
      else{
        console.log(this.comment)
        axios.post('http://localhost:8181/comment/insert',{commentText:this.comment}).then(res=>{
          alert(res.data);
        },err=>{
          console.log(err);
        })
      }
    }
  }
};
</script>

<style>
.header {
  font-size: 70px;
  padding-top: 15px;
  padding-left: 5px;
  background: #fff;
  box-shadow: 0 2px 8px rgba(0,0,0,0.08);
}
.page-header {
  font-size: 24px;
  line-height: 60px;
  padding-left: 40px;
}
.submit-button{
  display: flex;
  justify-content: center;
  width: 100px;
  height: 40px;
}
.comment{
  background: #fff;
  border-radius: 12px;
  padding: 32px;
  margin-bottom: 40px;
  box-shadow: 0 4px 16px rgba(0,0,0,0.06);
}
</style>
