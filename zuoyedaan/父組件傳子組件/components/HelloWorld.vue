<template>
  <div class="hello">
    <ul>
      <li v-for="(name,index) in names" :key="index">{{name}}</li>
    </ul>
  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  props: {
    names:[]
  }
}
</script>

<style scoped>
ul {
  list-style-type: none;
}
</style>
