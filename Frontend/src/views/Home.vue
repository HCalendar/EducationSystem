<template>
  <el-container class="home-container">
    <el-header class="main-header">
      <span class="header-text">防“钓”小助手</span>
    </el-header>

    <el-main class="main-content">
      <el-row :gutter="20">
        <el-col :span="12">
          <div class="button-container1">
            <button class="button" @click="djhy">独具慧眼<br>（识别）</button>
          </div>
        </el-col>
        <el-col :span="12">
          <div class="button-container1">
            <button class="button" @click="gsjm">故事解码<br>（案例分析）</button>
          </div>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="12">
          <div class="button-container2">
            <button class="button" @click="bdbq">百毒不侵<br>（防范技巧）</button>
          </div>
        </el-col>
        <el-col :span="12">
          <div class="button-container2">
            <button class="button" @click="test()">找漏洞</button>
          </div>
        </el-col>
      </el-row>
    </el-main>

    <el-footer class="main-footer">
      <el-button class="foot-button" @click="question">问卷调查</el-button>
      <el-button class="foot-button" @click="comment">意见反馈</el-button>
    </el-footer>
  </el-container>
</template>

<script>
export default {
  name: "HomePage",
  methods: {
    djhy() {
      this.$router.push('/DuJuHuiYan');
    },
    bdbq() {
      this.$router.push('/BaiDuBuQin');
    },
    gsjm() {
      this.$router.push('/GuShiJieMa');
    },
    test() {
      this.$router.push('/studentEmail')
    },
    question() {
      this.$router.push('/questionnaire')
    },
    comment() {
      this.$router.push('/comment')
    }
  }
}
</script>

<style>
/* 容器样式 */
.home-container {
  min-height: 100vh;
  background: linear-gradient(135deg, #f8f9fa 0%, #e9ecef 100%);
}

/* 头部样式 */
.main-header {
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 40px 0;
  background: rgba(255, 255, 255, 0.95);
  box-shadow: 0 2px 12px rgba(0, 0, 0, 0.1);
}

.header-text {
  font-size: 50px;
  background: linear-gradient(45deg, #0000CD, #4169E1);
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.1);
}

/* 主内容区 */
.main-content {
  padding: 40px 20px;
}

/* 按钮容器 */
.button-container1, .button-container2 {
  display: flex;
  align-items: center;
  justify-content: center;
  animation: slideIn 0.6s ease-out backwards;
}

.button-container1 {
  margin-bottom: 70px;
  animation-delay: 0.2s;
}

.button-container2 {
  margin-bottom: 10px;
  animation-delay: 0.4s;
}

/* 主按钮样式 */
.button {
  cursor: pointer;
  height: 150px;
  width: 200px;
  background: linear-gradient(145deg, #00008b, #0000cd);
  color: white;
  font-size: 20px;
  border: none;
  border-radius: 15px;
  box-shadow: 0 4px 15px rgba(0, 0, 0, 0.2);
  transition: all 0.3s ease;
  position: relative;
  overflow: hidden;
}

.button:hover {
  transform: translateY(-3px);
  box-shadow: 0 7px 20px rgba(0, 0, 0, 0.3);
}

.button:active {
  transform: translateY(1px);
}

/* 按钮流光效果 */
.button::after {
  content: '';
  position: absolute;
  top: -50%;
  left: -50%;
  width: 200%;
  height: 200%;
  background: linear-gradient(45deg,
  transparent 25%,
  rgba(255,255,255,0.1) 50%,
  transparent 75%);
  transform: rotate(45deg);
  opacity: 0;
  transition: all 0.5s;
}

.button:hover::after {
  opacity: 1;
  animation: shine 1.5s infinite;
}

/* 页脚样式 */
.main-footer {
  display: flex;
  justify-content: flex-end;
  padding: 20px 50px;
  background: rgba(255, 255, 255, 0.95);
  box-shadow: 0 -2px 12px rgba(0, 0, 0, 0.1);
}

.foot-button {
  height: 40px;
  width: 100px;
  margin-left: 50px;
  border-radius: 8px;
  background: linear-gradient(145deg, #f0f0f0, #ffffff);
  box-shadow: 0 2px 6px rgba(0, 0, 0, 0.1);
  transition: all 0.2s;
  border: none;
}

.foot-button:hover {
  box-shadow: 0 3px 8px rgba(0, 0, 0, 0.15);
  background: linear-gradient(145deg, #ffffff, #f0f0f0);
}

/* 动画定义 */
@keyframes slideIn {
  from {
    opacity: 0;
    transform: translateY(20px);
  }
  to {
    opacity: 1;
    transform: translateY(0);
  }
}

@keyframes shine {
  to {
    left: 150%;
    top: 150%;
  }
}

/* 响应式设计 */
@media (max-width: 768px) {
  .header-text {
    font-size: 40px;
  }

  .button {
    width: 180px;
    height: 130px;
    font-size: 18px;
  }

  .main-footer {
    padding: 15px 20px;
  }

  .foot-button {
    margin-left: 20px;
    width: 80px;
  }
}
</style>

