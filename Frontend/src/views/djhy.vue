<template>
  <el-container class="container">
    <el-header class="header">
      <el-page-header
          @back="goBack"
          content="独具慧眼"
          class="page-header"
      ></el-page-header>
    </el-header>

    <el-main class="main">
      <!-- 1. 甄别发件人邮箱地址 -->
      <section class="section">
        <h2 class="section-title">甄别发件人邮箱地址</h2>
        <div class="section-divider"></div>
        <el-text class="content-text">
          <p class="paragraph">
            通常情况下，正规邮件的发件人邮箱地址来源于官方已认证的域名。以清华大学为例，其官方邮件多采用诸如
            <span class="highlight">mail.tsinghua.edu.cn</span>，
            含有教育行业专用字段<span class="highlight">"edu"</span>，
            相关信息可通过访问清华大学官方网站进行查询核实。
          </p>
          <div class="example-box warning">
            <h3 class="example-title">钓鱼邮件典型特征：</h3>
            <ul class="example-list">
              <li><span class="danger-text">名称伪装：</span>发件人显示"清华大学教务处"，邮箱地址为"guzhuyizhi@mianbei.com"</li>
              <li><span class="danger-text">字符替换：</span>使用"tqinghua"替代"tsinghua"（mail.tqinghua.edu.cn）</li>
              <li><span class="danger-text">管理员伪装：</span>wadmin@tsinghua.com</li>
            </ul>
          </div>
        </el-text>
      </section>

      <!-- 2. 警惕标志性主题 -->
      <section class="section">
        <h2 class="section-title">警惕标志性主题</h2>
        <div class="section-divider"></div>
        <el-text class="content-text">
          <div class="comparison-grid">
            <div class="phishing-column">
              <h3 class="column-title">钓鱼邮件主题特征</h3>
              <ul class="feature-list">
                <li v-for="(topic, index) in phishingTopics" :key="index">
                  <i class="el-icon-warning danger-icon"></i>
                  {{ topic }}
                </li>
              </ul>
            </div>
            <div class="normal-column">
              <h3 class="column-title">正常邮件主题特征</h3>
              <ul class="feature-list">
                <li><i class="el-icon-success safe-icon"></i>主题简洁明确</li>
                <li><i class="el-icon-success safe-icon"></i>无情绪诱导词汇</li>
                <li><i class="el-icon-success safe-icon"></i>准确反映内容</li>
              </ul>
            </div>
          </div>
        </el-text>
      </section>

      <!-- 3. 注意邮件内容与语言风格 -->
      <section class="section">
        <h2 class="section-title">注意邮件内容与语言风格</h2>
        <div class="section-divider"></div>
        <el-text class="content-text">
          <div class="case-comparison">
            <div class="case-box official-case">
              <h3>正规邮件示例</h3>
              <p class="case-content">"尊敬的客户：您的账户近期有登录操作，如非本人操作请及时联系客服..."</p>
            </div>
            <div class="case-box phishing-case">
              <h3>钓鱼邮件示例</h3>
              <p class="case-content">"亲！你的账户有异常啦，<span class="danger-text">立即点击处理</span>，否则将被冻结！"</p>
            </div>
          </div>
        </el-text>
      </section>

      <!-- 4. 慎点邮件中链接与附件 -->
      <section class="section">
        <h2 class="section-title">慎点邮件中链接与附件</h2>
        <div class="section-divider"></div>
        <el-text class="content-text">
          <div class="warning-box">
            <h3 class="warning-title"><i class="el-icon-warning"></i> 风险提示</h3>
            <p class="paragraph">如果邮件中附带有链接与附件时，要注意提防！</p>
            <div class="step-guide">
              <div class="step">
                <h4>链接验证步骤：</h4>
                <ol>
                  <li>悬停查看真实URL</li>
                  <li>对比官方域名</li>
                  <li>检查SSL证书（https://）</li>
                </ol>
              </div>
              <div class="step">
                <h4>附件处理原则：</h4>
                <ol>
                  <li>不打开未知来源附件</li>
                  <li>扫描后再打开</li>
                  <li>警惕双重扩展名（如.pdf.exe）</li>
                </ol>
              </div>
            </div>
          </div>
        </el-text>
      </section>

      <!-- 5. 隐私信息要隐私 -->
      <section class="section">
        <h2 class="section-title">隐私信息要隐私</h2>
        <div class="section-divider"></div>
        <el-text class="content-text">
          <div class="sensitive-info">
            <el-alert
                title="敏感信息类型"
                type="error"
                :closable="false"
                class="alert-box"
            >
              <ul class="info-list">
                <li v-for="(info, index) in sensitiveList" :key="index">
                  {{ info }}
                </li>
              </ul>
            </el-alert>
            <p class="paragraph">官方处理方式：线下验证、安全通道传输、加密存储</p>
          </div>
        </el-text>
      </section>

      <!-- 6. 核实涉及金钱交易邮件内容 -->
      <section class="section">
        <h2 class="section-title">核实涉及金钱交易邮件内容</h2>
        <div class="section-divider"></div>
        <el-text class="content-text">
          <div class="verification-flow">
            <div class="flow-step">
              <div class="step-icon">1</div>
              <p>登录官方网站/APP核验订单状态</p>
            </div>
            <el-divider direction="vertical" class="flow-divider"></el-divider>
            <div class="flow-step">
              <div class="step-icon">2</div>
              <p>拨打官方客服电话确认</p>
            </div>
            <el-divider direction="vertical" class="flow-divider"></el-divider>
            <div class="flow-step">
              <div class="step-icon">3</div>
              <p>前往线下实体店核实</p>
            </div>
          </div>
        </el-text>
      </section>
    </el-main>
  </el-container>
</template>

<script>
export default {
  name: "DuJuHuiYan",
  data() {
    return {
      phishingTopics: [
        "您的账户已被冻结，请立即处理！",
        "您有一笔巨额奖金待领取！",
        "紧急通知：您的订单出现异常！"
      ],
      sensitiveList: [
        "银行账号及密码",
        "身份证号码",
        "信用卡安全码",
        "手机验证码",
        "生物特征信息"
      ]
    }
  },
  methods: {
    goBack() {
      this.$router.push('/');
    }
  }
}
</script>

<style scoped>
/* 基础布局 */
.container {
  min-height: 100vh;
  background: #f8f9fa;
}

.header {
  font-size: 70px;
  padding-top: 15px;
  padding-left: 5px;
  background: #fff;
  box-shadow: 0 2px 8px rgba(0,0,0,0.08);
}

.page-header {
  font-size: 24px;
  line-height: 80px;
  padding-left: 40px;
  color: #2c3e50;
}

.main {
  max-width: 1200px;
  margin: 0 auto;
  padding: 40px 20px;
}

/* 内容区块通用样式 */
.section {
  background: #fff;
  border-radius: 12px;
  padding: 32px 40px;
  margin-bottom: 40px;
  box-shadow: 0 4px 16px rgba(0,0,0,0.06);
}

.section-title {
  font-size: 26px;
  color: #1a1a1a;
  font-weight: 600;
  margin: 0 0 24px;
}

.section-divider {
  height: 2px;
  background: linear-gradient(90deg, #409EFF 0%, #67C23A 100%);
  margin: 24px 0;
  border: none;
}

/* 文字排版 */
.content-text {
  font-size: 16px;
  line-height: 1.8;
  color: #4a4a4a;
}

.paragraph {
  margin: 20px 0;
  text-align: justify;
}

.highlight {
  color: #409EFF;
  font-weight: 500;
  padding: 2px 4px;
  background: #f0f7ff;
  border-radius: 4px;
}

/* 示例区块 */
.example-box {
  padding: 20px;
  border-radius: 8px;
  margin: 24px 0;

  &.warning {
    background: #fef6f5;
    border-left: 4px solid #f56c6c;
  }
}

.example-title {
  font-size: 18px;
  color: #f56c6c;
  margin-bottom: 16px;
}

.example-list {
  padding-left: 30px;
}

.example-list li {
  margin: 12px 0;
  position: relative;
  padding-left: 28px;

  &::before {
    content: "•";
    color: #f56c6c;
    font-weight: bold;
    position: absolute;
    left: 0;
  }
}

/* 对比布局 */
.comparison-grid {
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  gap: 30px;
  margin-top: 24px;
}

.column-title {
  font-size: 18px;
  margin-bottom: 16px;
  padding-bottom: 8px;
  border-bottom: 2px solid #eee;
}

.phishing-column .column-title {
  color: #f56c6c;
}

.normal-column .column-title {
  color: #67c23a;
}

.feature-list li {
  padding: 12px 0;
  display: flex;
  align-items: center;
}

.danger-icon {
  color: #f56c6c;
  margin-right: 10px;
}

.safe-icon {
  color: #67c23a;
  margin-right: 10px;
}

/* 案例对比 */
.case-comparison {
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  gap: 30px;
  margin-top: 24px;
}

.case-box {
  padding: 20px;
  border-radius: 8px;

  &.official-case {
    background: #f0f9eb;
    border: 1px solid #e1f3d8;
  }

  &.phishing-case {
    background: #fef0f0;
    border: 1px solid #fde2e2;
  }
}

.case-content {
  margin: 16px 0;
}

/* 风险提示 */
.warning-box {
  background: #fff6ec;
  border-radius: 8px;
  padding: 20px;
}

.warning-title {
  color: #e6a23c;
  margin-bottom: 16px;
  display: flex;
  align-items: center;

  i {
    margin-right: 8px;
  }
}

.step-guide {
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  gap: 30px;
  margin-top: 20px;
}

.step {
  padding: 20px;
  background: #fff;
  border-radius: 8px;
  box-shadow: 0 2px 8px rgba(0,0,0,0.05);
}

/* 敏感信息 */
.alert-box {
  margin: 20px 0;
}

.info-list {
  padding-left: 25px;

  li {
    margin: 10px 0;
  }
}

/* 验证流程 */
.verification-flow {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin: 30px 0;
}

.flow-step {
  text-align: center;
  flex: 1;
}

.step-icon {
  width: 40px;
  height: 40px;
  background: #409EFF;
  color: white;
  border-radius: 50%;
  line-height: 40px;
  margin: 0 auto 10px;
  font-weight: bold;
}

.flow-divider {
  height: 60px;
}

/* 响应式设计 */
@media (max-width: 768px) {
  .main {
    padding: 20px 15px;
  }

  .section {
    padding: 24px;
    margin-bottom: 30px;
  }

  .comparison-grid,
  .case-comparison,
  .step-guide {
    grid-template-columns: 1fr;
  }

  .verification-flow {
    flex-direction: column;

    .flow-divider {
      display: none;
    }

    .flow-step {
      margin: 20px 0;
    }
  }

  .section-title {
    font-size: 22px;
  }
}
</style>
