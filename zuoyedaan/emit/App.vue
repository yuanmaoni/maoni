<template>
  <div id="app">
    <nav>
      <router-link to="/">Home</router-link> |
      <router-link to="/about">About</router-link> |
      <router-link to="/demo1">Demo1</router-link>
      <HelloWorld v-bind:name="nameList" @my-click="fun_sentaku"></HelloWorld>
      <p>選択された人：{{ namae }}</p>
    </nav>
    <router-view />
  </div>
</template>

<script>
import HelloWorld from "./components/HelloWorld";

export default {
  name: "app",
  data() {
    return {
      nameList: ["田中", "黒田", "西村"],
      namae: "",
    };
  },
  components: {
    HelloWorld,
  },

  methods: {
    fun_sentaku(value) {
      this.namae = value;
    },
  },
};
</script>

<style lang="scss">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;

  a {
    font-weight: bold;
    color: #2c3e50;

    &.router-link-exact-active {
      color: #42b983;
    }
  }
}
</style>
