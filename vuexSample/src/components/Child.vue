<template>
  <div class="content">
    <p>単価: {{ mulData.tanka }}円</p>
    <p>数量:<input type="text" class="input" v-model="mulData.num" /> 個</p>
    <button class="btn" @click="mul">計算</button>
  </div>
</template>

<script>
export default {
  data () {
    return {
      mulData:{tanka: 100,
      num: ""}

    };
  },
  methods: {
    mul() {
      this.$store.commit("multiply", this.mulData);
    },
  },
//  methods: {
//       // mapGettersと同じようにスプレット演算子で書ける
//       ...mapMutations(["mul","this.mulData"]),
//     },

};
</script>

<style scoped>
.content {
  margin: 20px;
  background-color: gainsboro;
  padding: 10px;
}
.input {
  margin-left: 10px;
  height: 38px;
  width: 100px;
  font-size: 30px;
}
.btn {
  height: 40px;
  width: 100px;
  font-size: 20px;
  background-color: rgba(255, 217, 113, 0.76);
  border: 2px solid #ccc;
}
p {
  font-size: 30px;
}
</style>