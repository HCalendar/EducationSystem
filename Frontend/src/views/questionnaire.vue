<template>
  <el-contianer>
    <el-header class="header">
      <el-page-header
          @back="goBack"
          content="问卷调查"
          class="page-header"
      ></el-page-header>
    </el-header>

    <el-main>
      <el-text class="text">
        您提供的信息将仅用于本学术研究项目（《钓鱼邮件攻击演示与教育系统》），旨在评估用户对钓鱼邮件的识别能力和系统的学习效果。所有数据将匿名化处理，且不会关联到您的个人身份。您有权随时撤回参与。如有疑问，请联系【开发者邮箱：1620679870@qq.com】。
      </el-text>
      <div class="survey-container">
        <!-- 第一部分：个人信息 -->
        <div class="section">
          <h2 class="title">第一部分：个人信息</h2>
          <div class="question">
            <label>1. 您的职业身份是？</label>
            <div>
              <el-radio-group v-model="personalInfo.profession">
                <el-radio value="学生" size="large">学生</el-radio>
                <el-radio value="企业员工" size="large">企业员工</el-radio>
                <el-radio value="公务员" size="large">公务员</el-radio>
                <el-radio value="其他" size="large">
                  其他
                </el-radio>
                <el-input v-if="personalInfo.profession === '其他'" v-model="personalInfo.otherProfession" style="width: 240px" placeholder="请输入您的职业" />
              </el-radio-group>
            </div>
          </div>
          <div class="question">
            <label>2. 您的网络安全专业知识水平如何？</label>
            <div>
              <el-radio-group v-model="personalInfo.knowledgeLevel">
                <el-radio value="非常熟悉" size="large">非常熟悉（如程序员、网络安全从业者）</el-radio>
                <el-radio value="基础熟悉" size="large">基础熟悉（如定期学习反诈技巧等）</el-radio>
                <el-radio value="不熟悉" size="large">不熟悉</el-radio>
              </el-radio-group>
            </div>
          </div>
        </div>

        <!-- 第二部分：钓鱼邮件认知 -->
        <div class="section">
          <h2 class="title">第二部分：钓鱼邮件认知</h2>
          <div v-for="(item, index) in phishingStatements" :key="index" class="question">
            <label>{{ index + 1 }}. {{ item }}</label>
            <div class="rating">
              <el-radio-group v-model="phishingResponses[index]">
                <el-radio v-for="n in 5" :key="n" size="large" :value="n">{{ n }}</el-radio>
              </el-radio-group>
            </div>
          </div>
        </div>

        <!-- 第三部分：系统使用体验 -->
        <div class="section">
          <h2 class="title">第三部分：系统使用体验</h2>
          <div v-for="(item, index) in systemStatements" :key="index" class="question">
            <label>{{ index + 1 }}. {{ item }}</label>
            <div class="rating">
              <el-radio-group v-model="systemResponses[index]">
                <el-radio v-for="n in 5" :key="n" size="large" :value="n">{{ n }}</el-radio>
              </el-radio-group>
            </div>
          </div>
        </div>

        <!-- 第四部分：学习效果评估 -->
        <div class="section">
          <h2 class="title">第四部分：学习效果评估</h2>
          <div v-for="(item, index) in learningStatements" :key="index" class="question">
            <label>{{ index + 1 }}. {{ item }}</label>
            <div class="rating">
              <el-radio-group v-model="learningResponses[index]">
                <el-radio v-for="n in 5" :key="n" size="large" :value="n">{{ n }}</el-radio>
              </el-radio-group>
            </div>
          </div>
        </div>

        <el-button type="primary" @click="submitSurvey" class="submit-button">提交问卷</el-button>
      </div>
    </el-main>
  </el-contianer>
</template>

<script>
import axios from "axios";

export default {
  name: 'questionnairePage',
  data() {
    return {
      personalInfo: {
        profession: null,
        otherProfession: null,
        knowledgeLevel: null
      },
      phishingStatements: [
        "我能快速识别钓鱼邮件的可疑特征（如异常链接、拼写错误）。",
        "我认为钓鱼邮件攻击是当前网络安全的主要威胁之一。",
        "我会在收到可疑邮件时立即删除，而不点击任何链接。",
        "我知道如何举报钓鱼邮件（如使用企业邮箱的“上报垃圾邮件”功能）。",
        "我定期学习网络安全知识以应对新型钓鱼攻击。"
      ],
      phishingResponses: [],

      systemStatements: [
        "钓鱼邮件的识别技巧模块内容清晰，钓鱼邮件特征明显。",
        "防范策略模块呈现方式易于阅读和操作。",
        "案例分析模块帮助我更好地理解攻击链过程。",
        "互动模拟模块（找漏洞）提高了我的实际辨别能力。",
        "我会向他人推荐使用本系统进行网络安全学习。"
      ],
      systemResponses: [],

      learningStatements: [
        "通过本系统的学习，我对钓鱼邮件的危险性有了更清晰的认识。",
        "本系统的内容和案例有助于我在实际工作、生活中识别钓鱼邮件。",
        "本系统的学习内容适合我的知识水平。",
        "我认为本系统的互动模块能有效提升安全意识。",
        "我计划在日常工作中应用本系统教授的防范技巧。"
      ],
      learningResponses: [],
      surveyResponses:[]
    };
  },
  methods: {
    goBack() {
      this.$router.push('/');
    },
    submitSurvey() {
      if(this.personalInfo.knowledgeLevel===null||this.personalInfo.profession===null||this.phishingResponses.length<5||this.systemResponses.length<5||this.phishingResponses.length<5)
        alert("请完成问卷所有问题！")
      else{
        for(let i=0;i<5;i=i+1){
          this.surveyResponses.push({
            section:'phishing',
            answer:this.phishingResponses[i],
            questionId:1+i
          })
          this.surveyResponses.push({
            section:'system',
            answer:this.systemResponses[i],
            questionId:6+i
          })
          this.surveyResponses.push({
            section:'learning',
            answer:this.learningResponses[i],
            questionId:11+i
          })
        }
        console.log(Array.isArray(this.surveyResponses))
        axios.post('http://localhost:8181/surveyResponse/insert',
            {
              surveyResponses: this.surveyResponses,
              personalInfo: this.personalInfo
            })
            .then(res=>{
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
.text {
  font-size: 16px;
  line-height: 1.8;
  color: #606266;
  margin-left: 34px;
  text-align: justify;
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
.survey-container {
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
  font-family: Arial, sans-serif;
}
.section {
  margin-bottom: 20px;
}
.rating {
  display: flex;
  gap: 10px;
}
button {
  display: block;
  margin: 20px auto;
  padding: 10px 20px;
  background-color: #007bff;
  color: white;
  border: none;
  cursor: pointer;
}
button:hover {
  background-color: #0056b3;
}
.title {
  font-size: 30px;
  color: steelblue;
  font-weight: bold;
  padding-left: 10px;
}
.question {
  margin-bottom: 15px;
  font-size: 16px;
  line-height: 1.8;
  color: #606266;
  margin-left: 20px;
  text-align: justify;
}
.submit-button{
  display: flex;
  justify-content: center;
  width: 100px;
  height: 40px;
}
</style>
