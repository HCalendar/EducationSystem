<template>
  <div>
    <h1>Dashboard</h1>
    <router-link to="/manage/showData">Show Data</router-link> |
    <router-link to="/manage/showComment">Show Comment</router-link>
    <div>
      <router-view></router-view> <!-- 子路由的出口 -->
    </div>
  </div>
</template>

<script>
export default {
  name: 'managePage',
};
</script>
