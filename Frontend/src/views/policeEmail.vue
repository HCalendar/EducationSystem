<template>
  <el-container>
    <el-header>
      <el-page-header @back="goBack" content="找漏洞（公安邮件）" class="special-header" />
    </el-header>
    <el-main class="main">
      <el-text class="text">下图一共有5处漏洞，请点击找出的漏洞。目前已找到{{this.pointNumber}}个。</el-text>
      <img src="@/assets/fake2.png" class="fakeImg" @click="handleClick"/>
      <el-button type="primary" class="button" @click="this.$router.push('/studentEmail')">上一关</el-button>
    </el-main>
  </el-container>
  <el-dialog
    v-model="dialogVisible"
    title="成功"
    width="500">
    <span>恭喜你成功找到5处漏洞,是返回主页？</span>
    <template #footer>
      <div class="dialog-footer">
        <el-button @click="dialogVisible = false">取消</el-button>
        <el-button type="primary" @click="dialogVisible = false;goBack()">确定</el-button>
      </div>
    </template>
  </el-dialog>
</template>

<script>
export default {
  name: "studentEmail",
  data() {
    return{
      points:[0,0,0,0,0],
      pointNumber:0,
      dialogVisible:false
    }
  },
  methods:{
    goBack() {
      this.$router.push('/');
    },
    changePoints(){
      this.pointNumber=this.points.filter(number => number === 1).length
      if(this.pointNumber === 5)  this.dialogVisible=true
    },
    handleClick(event){
      const rect = event.target.getBoundingClientRect();
      const x = event.clientX - rect.left; // 点击位置相对于图片的 X 坐标
      const y = event.clientY - rect.top; // 点击位置相对于图片的 Y 坐标
      console.log(`Clicked at X: ${x}, Y: ${y}`);
      // 根据坐标判断是否在指定区域内
      if (x > 144 && x < 419 && y > 135 && y < 161) {
        this.points[0]=1
        this.changePoints()
        this.$notify({
          title: '成功',
          dangerouslyUseHTMLString: true,
          message: '发件人名称错误：法“制”总队<br>此处将“u”改为了“v”<br><img src="/images/img6.png" width="50%" height="auto"/>',
          type: 'success',
          duration: 3000,
          position: 'top-right'
        });
      }
      else if (x > 535 && x < 735 && y > 522 && y < 558) {
        this.points[1]=1
        this.changePoints()
        this.$notify({
          title: '成功',
          dangerouslyUseHTMLString: true,
          message: '公安出具官方文件案件会有编号，而非用名字<br><img src="/images/img7.png" width="50%" height="auto"/>',
          type: 'success',
          duration: 3000,
          position: 'top-right'
        });
      }
      else if (x > 263 && x < 520 && y > 573 && y < 602) {
        this.points[2]=1
        this.changePoints()
        this.$notify({
          title: '成功',
          dangerouslyUseHTMLString: true,
          message: '办案截止期限前3-5日，法制会通过电话、办案系统提醒<br><img src="/images/img8.png" width="50%" height="auto"/>',
          type: 'success',
          duration: 3000,
          position: 'top-right'
        });
      }
      else if (x > 153 && x < 374 && y > 874 && y < 902) {
        this.points[3]=1
        this.changePoints()
        this.$notify({
          title: '成功',
          dangerouslyUseHTMLString: true,
          message: '官方网站为gat.shandong.gov.cn<br><img src="/images/img9.png" width="50%" height="auto"/>',
          type: 'success',
          duration: 3000,
          position: 'top-right'
        });
      }
      else if (x > 712 && x < 881 && y > 1085 && y < 1237) {
        this.points[4]=1
        this.changePoints()
        this.$notify({
          title: '成功',
          dangerouslyUseHTMLString: true,
          message: '缺少公章<br><img src="/images/img10.png" width="50%" height="auto"/>',
          type: 'success',
          duration: 3000,
          position: 'top-right'
        });
      }
      else{
        this.$notify({
          title: '失败',
          message: '不是这里，再找找看',
          type: 'error',
          duration: 3000,
          position: 'top-right'
        });
      }
    }
  }
}
</script>

<style scoped>
.special-header {
  font-size:60px;
}
.main {
  justify-content: center;
  margin-left: 50px;
  margin-right: 50px;
}
.text{
  justify-content: center;
  font-size: 30px;
  color: steelblue;
}
.fakeImg{
  width: 1100px;
  height: auto;
  object-fit: contain;
}
.button{
  width: 200px;
  height: 60px;
  float: right;
}
</style>
