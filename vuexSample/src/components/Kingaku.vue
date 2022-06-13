<template>
  <div>
    <h1>This is a emit sample</h1>

    <!-- # パターン1:受け取った値をそのまま使う場合は$eventで受け取る
         # パターン2:受け取った値をメソッドの引数で受け取る -->
    <!-- <Child @my-click="sum_kingaku = $event" /> -->
    <!-- <Child @my-click="fun_kingaku" /> -->
    <hr />
    <child >
    </child>
    <p>合計金額: {{ count }} 円</p>
  </div>
</template>


<script>
import Child from "./Child.vue";
export default {
  components: {
    Child,
  },
  computed: {
    count() {
      return this.$store.getters.counter; // $store.gettersで呼ぶ
    },
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
