# パターン1:受け取った値をそのまま使う場合は$eventで受け取る
# パターン2:受け取った値をメソッドの引数で受け取る
<template>
  <div>
    <h1>This is a emit sample</h1>
    <Child @my-click="sum_kingaku = $event" />
    <!-- <Child @my-click="fun_kingaku" /> -->
    <hr />
    <p>合計金額: {{ sum_kingaku }} 円</p>
  </div>
</template>

<script>
import Child from "./components/Child.vue";
export default {
  data: function () {
    return {
      sum_kingaku: 0,
    };
  },

  components: {
    Child,
  },

  methods: {
    fun_kingaku(value) {
      this.sum_kingaku = value;
    },
  },
};
</script>
<style>
p {
  font-size: 40px;
}
</style>
