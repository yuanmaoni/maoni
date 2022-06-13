import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex); // vuexをvue全体で使用する宣言

export default new Vuex.Store({ // main.jsで読み込めるようにする
// 以下で定義したものはどのコンポーネントでも使用出来る
state: { // 状態を全体で使用出来るようにする
    number:null
  },
  mutations: {
    multiply(state, str) { // 第一引数にstateをとり、実際の変更を記述する
      state.number = str.tanka * str.num;
      console.log(state.number )
    }
  },
  getters: {
    counter: state => state.number, 
  }
})