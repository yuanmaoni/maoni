<template>
  <div id="app">
    <!-- <img alt="Vue logo" src="./assets/logo.png"> -->
    <!-- <HelloWorld nameLists="Welcome to Your Vue.js App"/> -->
    <!-- <UserList />
    <nameList /> -->
    <nameL v-bind:nameLists="nameList" >
    </nameL >
   
  </div>
</template>

<script>
//import HelloWorld from './components/HelloWorld.vue'
// import UserList from './components/UserList.vue'
// import nameList from './components/nameList.vue'

import nameL from './components/nameL.vue'
export default {
  name: 'App',
  components: {
   // HelloWorld
  //  UserList,
  //  nameList
  nameL
  },
   data(){
    return{
      nameList:["田中","黒田","西村"]
    }
  }
}
</script>

<style scoped>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  /* text-align: center; */
  color: #2c3e50;
  margin-top: 60px;
}
</style>
