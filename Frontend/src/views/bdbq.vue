<template>
  <el-container>
    <el-header class="header">
      <el-page-header
          @back="goBack"
          content="百毒不侵（防范技巧）"
          class="page-header"
      ></el-page-header>
    </el-header>

    <el-main class="main">
      <el-collapse v-model="activeNames" accordion>
        <!-- 心防策略 -->
        <el-collapse-item name="1" class="strategy-item">
          <template #title>
            <span class="strategy-title">心防策略</span>
          </template>
          <div class="strategy-content">
            <div class="sub-item">
              <h3 class="sub-title">1. 提高安全意识</h3>
              <el-text class="text-content">
                <p>时刻绷紧安全这根弦，意识到钓鱼邮件的陷阱就在身边潜伏着。通过板块"独具慧眼"了解钓鱼邮件的常见套路。同时建议积极参加网络安全培训、阅读相关安全资讯等，更新自己的安全知识储备。在许多大学和企业内都有公安机关组织的网络安全讲座，邀请行业内专家讲解最新的钓鱼邮件案例和防范方法。</p>
              </el-text>
            </div>

            <div class="sub-item" style="margin-top: 30px;">
              <h3 class="sub-title">2. 养成核实信息的习惯</h3>
              <el-text class="text-content">
                <p>任何要求提供个人信息、进行转账汇款或点击链接登录账户等操作的邮件，都要留一百个心眼。可以通过其他可靠的渠道进行多方面核实。例如，当收到来自银行的邮件，告知账户存在异常，要求点击链接进行处理，那么可以直接拨打银行的官方客服电话，询问邮件内容是否属实。如果是公司、学校内部邮件，涉及到重要工作事项或敏感信息，则可以直接通过面对面交流、内部通讯系统等方式与发件人或相关部门负责人确认邮件的真实性。</p>
              </el-text>
            </div>
          </div>
        </el-collapse-item>

        <!-- 物防策略 -->
        <el-collapse-item name="2" class="strategy-item">
          <template #title>
            <span class="strategy-title">物防策略</span>
          </template>
          <div class="strategy-content">
            <div class="sub-item">
              <h3 class="sub-title">1. 配齐安全防护软件</h3>
              <el-text class="text-content">
                <p>及时安装并定期更新诸如国家反诈中心、病毒查杀等，这些软件可以实时监控邮件的收发过程，对邮件内容、链接和附件进行扫描。当收到带有可疑附件的邮件时，杀毒软件可以及时检测出其中可能隐藏的病毒或木马，并阻止其运行，向收件人发出警告。</p>
              </el-text>
            </div>

            <div class="sub-item" style="margin-top: 30px;">
              <h3 class="sub-title">2. 启用邮件过滤功能</h3>
              <el-text class="text-content">
                <p>大多数邮件客户端和邮件服务提供商都提供了邮件过滤功能，除系统自身拦截外，用户还可以自行添加像"大奖""洗钱"等拦截词，即我们所熟知的骚扰拦截，自动将疑似恶意邮件标记为垃圾邮件或直接予以拦截。</p>
              </el-text>
            </div>
          </div>
        </el-collapse-item>

        <!-- 技防策略 -->
        <el-collapse-item name="3" class="strategy-item">
          <template #title>
            <span class="strategy-title">技防策略</span>
          </template>
          <div class="strategy-content">
            <div class="sub-item">
              <h3 class="sub-title">1. 使用双因子认证</h3>
              <el-text class="text-content">
                <p>双因子认证，顾名思义就是为我们的账户、信息加上两道门禁，进行双重验证，大幅降低被破解的可能性。现在，不少应用强制开启双因子验证，如掌上银行，需要同时验证手机号码与指纹，还有一些应用可选择性开启，如QQ登录可开启手势码搭配密码解锁，从用户减少钓鱼邮件的破坏性。</p>
              </el-text>
            </div>

            <div class="sub-item" style="margin-top: 30px;">
              <h3 class="sub-title">2. 设置强密码</h3>
              <el-text class="text-content">
                <p>密码也有强弱之分，弱密码就是单一元素的简单排列，通过爆破即可破解，强密码是包含多种元素，字母、字符、数字搭配组合使用，单字符避免重复使用等，具有较高的安全性，一般难以破解。</p>
              </el-text>
            </div>
          </div>
        </el-collapse-item>
      </el-collapse>
    </el-main>
  </el-container>
</template>

<script>
export default {
  name: "BaiDuBuQin",
  data() {
    return {
      activeNames: ['1'] // 默认展开第一个面板
    };
  },
  methods: {
    goBack() {
      this.$router.push('/');
    }
  }
}
</script>

<style scoped>
/* 头部样式 */
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

/* 主体内容样式 */
.main {
  margin: 0 50px;
  padding: 20px 0;
}

/* 策略标题样式 */
.strategy-title {
  font-size: 30px;
  color: steelblue;
  font-weight: bold;
  padding-left: 10px;
}

/* 折叠面板项样式 */
.strategy-item {
  margin-bottom: 15px;
  border-radius: 8px;
  box-shadow: 0 2px 12px 0 rgba(0,0,0,0.1);
}

/* 子项内容容器 */
.strategy-content {
  padding: 15px 30px;
  background-color: #f8f9fa;
}

/* 子标题样式 */
.sub-title {
  font-size: 20px;
  color: steelblue;
  margin: 15px 0;
  padding-left: 10px;
  border-left: 4px solid #409EFF;
}

/* 文本内容样式 */
.text-content {
  font-size: 16px;
  line-height: 1.8;
  color: #606266;
  margin-left: 20px;
  text-align: justify;
}

::v-deep .el-collapse-item__header {
  height: 70px !important;
  font-size: 24px !important;
  padding: 0 25px !important;
  background-color: #fff !important;
}

::v-deep .el-collapse-item__content {
  padding-bottom: 0 !important;
}

::v-deep .el-collapse {
  border-top: none;
  border-bottom: none;
}
</style>
