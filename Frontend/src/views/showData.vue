<template>
  <div>
    <el-table :data="tableData" style="width: 100%" border>
      <el-table-column prop="personalInfo.userId" label="用户ID" width="80"></el-table-column>
      <el-table-column label="职业" width="120">
        <template #default="scope">
          {{ scope.row.personalInfo.profession === '其他' ? scope.row.personalInfo.profession+'('+scope.row.personalInfo.otherProfession+')' : scope.row.personalInfo.profession }}
        </template>
      </el-table-column>
      <el-table-column prop="personalInfo.knowledgeLevel" label="知识水平" width="120"></el-table-column>
      <el-table-column prop="personalInfo.createdTime" label="创建时间" width="180"></el-table-column>

      <!-- 动态生成问题列 -->
      <el-table-column
          v-for="questionId in questionIds"
          :key="questionId"
          :prop="`answers.${questionId}`"
          :label="`问题${questionId}`"
          width="80"
      ></el-table-column>
    </el-table>
  </div>
</template>

<script>
import { ref, onMounted } from "vue";
import axios from "axios";

export default {
  setup() {
    const tableData = ref([]);
    const questionIds = ref([]);

    // 从后端获取数据
    const fetchData = async () => {
      try {
        const response = await axios.get("http://localhost:8181/surveyResponse/getAll");
        const rawData = response.data;

        // 处理数据：将 surveyResponses 转换为对象格式
        const processedData = rawData.map((item) => {
          const answers = item.surveyResponses.reduce((acc, response) => {
            acc[response.questionId] = response.answer;
            return acc;
          }, {});

          return {
            personalInfo: item.personalInfo,
            answers: answers,
          };
        });

        // 获取所有问题ID
        questionIds.value = Array.from(
            new Set(rawData.flatMap((item) => item.surveyResponses.map((r) => r.questionId)))
        ).sort((a, b) => a - b); // 按升序排序

        tableData.value = processedData;
      } catch (error) {
        console.error("Error fetching data:", error);
      }
    };

    // 在组件挂载时调用 fetchData
    onMounted(fetchData);

    return {
      tableData,
      questionIds,
    };
  },
};
</script>
