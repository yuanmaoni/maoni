<template>
  <div>
    <ul>
      <li v-for="(item, index) in name" v-bind:key="index">
        <input type="radio" v-model="namae" :value="item" />{{ item }}
      </li>
      <button class="btn" @click="send">選択</button>
    </ul>
  </div>
</template>

<script>
export default {
  name: "HelloWorld",
  props: {
    name: [],
  },
  data: function () {
    return {
      namae: "",
    };
  },
  methods: {
    send() {
      this.$emit("my-click", this.namae);
    },
  },
};
</script>

<style>
ul {
  list-style: none;
}
</style>