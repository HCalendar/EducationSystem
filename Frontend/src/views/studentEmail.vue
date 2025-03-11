<template>
  <el-container>
    <el-header>
      <el-page-header @back="goBack" content="找漏洞（学生邮件）" class="special-header" />
    </el-header>
    <el-main class="main">
      <el-text class="text">下图一共有5处漏洞，请点击找出的漏洞。目前已找到{{this.pointNumber}}个。</el-text>
      <img src="@/assets/fake1.png" class="fakeImg" @click="handleClick"/>
      <el-button type="primary" class="button" v-if="this.pointNumber===5" @click="this.$router.push('/policeEmail')">下一关</el-button>
    </el-main>
  </el-container>
  <el-dialog
    v-model="dialogVisible"
    title="成功"
    width="500">
    <span>恭喜你成功找到5处漏洞，是否前往下一关？</span>
    <template #footer>
      <div class="dialog-footer">
        <el-button @click="dialogVisible = false">取消</el-button>
        <el-button type="primary" @click="goOn()">确定</el-button>
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
    goOn(){
      this.dialogVisible = false
      this.$router.push('/policeEmail')
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
      if (x > 139 && x < 467 && y > 176 && y < 204) {
        this.points[0]=1
        this.changePoints()
        this.$notify({
          title: '成功',
          dangerouslyUseHTMLString: true,
          message: '发件人邮箱：jiaowuchu@cppu.edu.com<br>此处将“u”改为了“v”<br><img src="/images/img1.png" width="50%" height="auto"/>',
          type: 'success',
          duration: 3000,
          position: 'top-right'
        });
      }
      else if (x > 227 && x < 875 && y > 575 && y < 617) {
        this.points[1]=1
        this.changePoints()
        this.$notify({
          title: '成功',
          dangerouslyUseHTMLString: true,
          message: '如果注意学校官方通报会发现，一般都是用“2024-2025学年度”，不会直接说“2025学年”<br><img src="/images/img2.png" width="50%" height="auto"/>',
          type: 'success',
          duration: 3000,
          position: 'top-right'
        });
      }
      else if (x > 436 && x < 662 && y > 659 && y < 686) {
        this.points[2]=1
        this.changePoints()
        this.$notify({
          title: '成功',
          dangerouslyUseHTMLString: true,
          message: '今年还没到12号嘞~<br><img src="/images/img3.png" width="50%" height="auto"/>',
          type: 'success',
          duration: 3000,
          position: 'top-right'
        });
      }
      else if (x > 814 && x < 1074 && y > 1314 && y < 1340) {
        this.points[3]=1
        this.changePoints()
        this.$notify({
          title: '成功',
          dangerouslyUseHTMLString: true,
          message: '没有符号©，而且备案号也是假的<br><img src="/images/img4.png" width="50%" height="auto"/>',
          type: 'success',
          duration: 3000,
          position: 'top-right'
        });
      }
      else if (x > 437 && x < 606 && y > 1059 && y < 1119) {
        this.points[4]=1
        this.changePoints()
        this.$notify({
          title: '成功',
          dangerouslyUseHTMLString: true,
          message: '学校有企业微信，不会用邮箱申请的！<br><img src="/images/img5.png" width="50%" height="auto"/>',
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
