<template>
  <div>
    <h2>评论列表</h2>
    <div v-for="(comment, index) in comments" :key="index" class="comment-block">
      <p><strong>用户ID：</strong>{{ comment.commentId }}</p>
      <p><strong>评论内容：</strong>{{ comment.commentText }}</p>
      <p><strong>评论时间：</strong>{{ comment.commentTime }}</p>
    </div>
  </div>
</template>

<script>
import { ref, onMounted } from "vue";
import axios from "axios";

export default {
  setup() {
    const comments = ref([]);

    // 从后端获取评论数据
    const fetchComments = async () => {
      try {
        const response = await axios.get("http://localhost:8181/comment/getAll");
        comments.value = response.data;
      } catch (error) {
        console.error("Error fetching comments:", error);
      }
    };

    // 在组件挂载时调用 fetchComments
    onMounted(fetchComments);

    return {
      comments,
    };
  },
};
</script>

<style scoped>
.comment-block {
  margin-bottom: 20px;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
}

.comment-block p {
  margin: 5px 0;
}
</style>
