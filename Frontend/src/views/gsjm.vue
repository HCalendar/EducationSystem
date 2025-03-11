<template>
  <el-container class="container">
    <el-header class="header">
      <el-page-header
          @back="goBack"
          content="故事解码（案例分析）"
          class="page-header"
      ></el-page-header>
    </el-header>

    <el-main class="main">
      <!-- 案例一 -->
      <section class="case-section">
        <h2 class="case-title">案例一：“钓”走科研机密的“鱼饵” </h2>
        <el-text class="text-content">
          <p>2023年，某科研集团的邮箱系统里突然多了一封来自管理员的邮件，收件人是全体员工，内容是“集团系统要进行集中升级”，而后，集团组织架构，以及包含集团领导在内的近200名员工信息全部遭到泄露。这究竟是怎么一回事呢？</p>
        </el-text>
        <div class="timeline">
          <div v-for="(step, index) in case1Steps" :key="index" class="timeline-item">
            <div class="step-marker">{{ index + 1 }}</div>
            <div class="step-content">
              <h3 class="step-title">{{ step.title }}</h3>
              <p class="step-text">{{ step.content }}</p>
            </div>
          </div>
        </div>
        <div class="warning-card">
          <img src="@/assets/star.png" class="warning-icon">
          <div class="warning-content">
            <h3>安全启示</h3>
            <ul class="warning-list">
              <li><span class="highlight">强化密码管理：</span>账户应使用强密码，并定期更换。同时，应当限制密码尝试次数，比如五次输入错误后，账户封禁十分钟，来防止爆破</li>
              <li><span class="highlight">安全意识培训：</span>定期对员工进行网络安全意识培训，提高员工对钓鱼邮件的识别能力</li>
              <li><span class="highlight">数据备份：</span>重要数据要有随时备份地好习惯，确保在数据被窃取时能够快速恢复</li>
            </ul>
          </div>
        </div>
      </section>

      <!-- 案例二 -->
      <section class="case-section">
        <h2 class="case-title">案例二：是假期，还是“假”期</h2>
        <el-text class="text-content">
          <p>2023年，一封来自学校教务处的电子邮件发送到了每个学生的邮箱中，邮件的主题是五一放假通知。这封如假包换的电子邮件，不仅发件人的邮箱后缀是该校域名，而且通知的格式也与学校通知一模一样。学生们出于对学校的信任，魏家何时便点击了邮箱中的链接，最终导致账户被窃取</p>
        </el-text>
        <div class="attack-flow">
          <div
              v-for="(step, index) in case2Steps"
              :key="index"
              class="flow-step"
              :class="{ 'critical-step': step.critical }"
          >
            <div class="step-number">步骤{{ index + 1 }}</div>
            <div class="flow-content">
              <h4>{{ step.title }}</h4>
              <p>{{ step.detail }}</p>
              <div v-if="step.note" class="technical-note">
                <i class="el-icon-info"></i>
                {{ step.note }}
              </div>
            </div>
          </div>
        </div>
        <div class="warning-card">
          <img src="@/assets/star.png" class="warning-icon">
          <div class="warning-content">
            <h3>防护建议</h3>
            <ul class="warning-list">
              <li><span class="highlight">网络访问：</span>在无法确定对方身份情况下，尽量避免用公共网络登录邮箱、校园内部网站等，这也是为什么许多学校内部网站只能通过校园网进入</li>
              <li><span class="highlight">双因子认证：</span>在防范技巧里我们已经介绍过双因子认证，这样即使攻击者获取了账号密码，也无法登录邮箱</li>
              <li><span class="highlight">异常识别：</span>警惕非常规操作流程</li>
            </ul>
          </div>
        </div>
      </section>
    </el-main>
  </el-container>
</template>

<script>
export default {
  name: "GuShiJieMa",
  data() {
    return {
      case1Steps: [
        {
          title: "突破防线",
          content: "攻击者早就盯上了这个集团内部资料，但是作为一家科研公司，如何突破严密的防守呢？攻击者首先采取了网络踩点（可以简单理解为小偷提前去门口踩点），通过邮箱枚举获取电子邮件账户列表，然后通过弱密码检测（在防范技巧里已经讲过），竟然发现，该集团邮箱系统的管理员账户，使用的密码正是弱密码！这可是送上门的馅饼，怎能不用。利用SMTP暴力破解工具（可以理解为，采用穷举法一遍遍尝试，直到试出正确的密码），顺利获取了该名管理人员的邮箱密码。"
        },
        {
          title: "知己知彼",
          content: "攻击者在进行群发邮件之前，首先通过社会工程学进行信息收集，小红书、微博都是很好的工具，一番调查后，攻击者了解到集团员工对当前的邮箱系统很不满意，迫切希望可以增加更多实用的功能。这就为我们的攻击者编辑钓鱼邮件内容提供了很好的方向。"
        },
        {
          title: "收网捕鱼",
          content: "攻击者使用管理员账户，编辑了一条名为“系统升级通知”的邮件，内容为“为方便广大员工日常工作，现对系统进行统一更新升级，请各员工尽快下载，避免延误工作！”文件末附有早就准备好的网址，员工点击链接后，会跳转到攻击者搭建的虚假登录页面，外观与集团官网一致。当员工在该页面输入账号密码时，这些信息会被发送到攻击者的服务器。"
        },
        {
          title: "兵来将挡",
          content: "很快，集团内部就有人发现了事情的不对劲，但是，攻击者也早有防备。通过管理员账户，攻击者轻而易举地删除了最新发布地预警邮件，消除员工警惕心理。就这样该科研集团从组织框架、人员信息到大大小小机要文件都被洗劫一空。"
        }
      ],
      case2Steps: [
        {
          title: "伪造身份",
          detail: "考虑到大学生具有一定的网络安全常识，攻击者首先通过社会工程学，通过社交媒体和学校官网获取了学校教务处的发件人地址，然后他将地址中的字母进行替换，字母o变为0，仿制了一个与教务处相似的发件人。",
          critical: true
        },
        {
          title: "钓鱼",
          detail: "在该封邮件中嵌套了一个恶意链接，但是该链接引导至的网址从外表看，与学校官网没有区别，而且内容为五一放假安排，因为马上临近五一假期，许多同学放下了戒备心。",
          critical: true
        },
        {
          title: "侵入",
          detail: "当学生点击恶意网站时，该网站上的JavaScript代码会被触发，代码会运行一个虚假的验证程序，呈现给学生的，即是登录学校官网，因为许多学校的官网都不具有自动登入功能，所以再次访问时需要重新输入账号，密码是十分常见的，学生并没有将这件事情放在心上。当学生输入完自己的账号密码，点击下一步按钮时，殊不知，这已经触发了页面内置的恶意代码，将一段精心编造的payload（“Payload”指的是攻击者用来执行特定恶意行为的代码或指令，根据代码不同功能也不同）复制到用户的系统剪切板中。这时候，网站发出提醒，提示学生们，该网站卡顿需要关闭网站重新启动。出于对学校官网的信任，学生便跟随网站指示按下了“windows+R”组合键（这在我们的电脑系统中是打开“运行”对话框的快捷键），之后网站会继续提示学生们按下“ctrl+v”组合键（这是将剪切板中内容粘贴到运行对话框中的快捷键），一系列操作之后粘贴到系统剪切板中的payload的程序运行。",
          critical: true
        },
        {
          title: "窃取",
          detail: "执行的payload命令，负责从攻击者提供的远程服务器下载恶意后门程序（后门程序是一种绕过安全性控制而获取对程序或系统访问权的程序。它原本是开发者预留的，用于后期修改程序或系统中存在的问题，但如果被黑客恶意利用，就会成为计算机安全的一大威胁，黑客可借此轻松入侵目标计算机），并在学生的系统中执行。该后门程序会在设备上潜伏，收集设备信息，浏览器历史、cookie、用户凭证等信息，并将这些数据传回到攻击者的服务器中，通过以上方式，攻击者进一步窃取了学生的个人信息。",
          critical: true
        }
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
  background: #f8f9fa;
  min-height: 100vh;
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
  line-height: 60px;
  padding-left: 40px;
}

.main {
  max-width: 1200px;
  margin: 0 auto;
  padding: 40px 20px;
}

/* 案例区块 */
.case-section {
  background: #fff;
  border-radius: 12px;
  padding: 32px;
  margin-bottom: 40px;
  box-shadow: 0 4px 16px rgba(0,0,0,0.06);
}

.case-title {
  font-size: 24px;
  color: #2c3e50;
  margin-bottom: 24px;
  padding-bottom: 12px;
  border-bottom: 2px solid #409EFF;
}

/* 时间线布局 */
.timeline {
  padding-left: 30px;
  margin: 24px 0;
}

.timeline-item {
  display: flex;
  margin-bottom: 32px;
  position: relative;
}

.step-marker {
  width: 28px;
  height: 28px;
  background: #409EFF;
  color: white;
  border-radius: 50%;
  text-align: center;
  line-height: 28px;
  margin-right: 20px;
  flex-shrink: 0;
}

.step-content {
  flex: 1;
  padding-bottom: 20px;
  border-left: 2px solid #ebeef5;
  padding-left: 20px;
}

.step-title {
  color: #1a1a1a;
  margin: 0 0 12px;
}

.step-text {
  color: #606266;
  line-height: 1.8;
  text-align: justify;
}

/* 攻击流程 */
.attack-flow {
  display: grid;
  gap: 20px;
  margin: 24px 0;
}

.flow-step {
  background: #f8f9fa;
  border-radius: 8px;
  padding: 16px;
  border-left: 4px solid #409EFF;
}

.critical-step {
  border-color: #f56c6c;
  background: #fef0f0;
}

.step-number {
  color: #909399;
  font-size: 14px;
  margin-bottom: 8px;
}

.technical-note {
  background: #fff6ec;
  padding: 12px;
  border-radius: 4px;
  margin-top: 12px;
  color: #e6a23c;
}

/* 警示卡片 */
.warning-card {
  background: #f0f7ff;
  border-radius: 8px;
  padding: 24px;
  margin-top: 32px;
  display: flex;
  gap: 20px;
}

.warning-icon {
  flex-shrink: 0;
  height: 40px;
}

.warning-content h3 {
  color: #f56c6c;
  margin: 0 0 16px;
}

.warning-list {
  padding-left: 24px;
}

.warning-list li {
  margin: 12px 0;
  line-height: 1.6;
}

.highlight {
  color: #409EFF;
  font-weight: 500;
}

/* 响应式设计 */
@media (max-width: 768px) {
  .main {
    padding: 20px;
  }

  .case-section {
    padding: 24px;
  }

  .timeline {
    padding-left: 20px;
  }

  .step-marker {
    margin-right: 15px;
  }
}
</style>
