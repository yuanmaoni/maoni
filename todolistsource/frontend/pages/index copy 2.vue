<template>
  <div>
    <div class="container">
      <h1 class="title">Todo List</h1>
      <div class="input-group mb-3">
        <input
          type="text"
          class="form-control"
          placeholder="名前を入力してください"
          aria-label="名前を入力してください"
          aria-describedby="button-addon2"
          v-model="inputtext"
        />
        <button
          class="btn btn-outline-secondary"
          type="button"
          id="button-addon2"
          @click="add"
        ><b-icon icon="plus"></b-icon>
          追加
        </button>
      </div>
      <!-- カレンダー追加 -->
  <template>
  <b-row>
    <b-col cols="12" class="mb-3">
      <label for="example-locales"></label>
      <b-form-select id="example-locales" v-model="locale" :options="locales"></b-form-select>
      <!-- <label for="example-weekdays" class="mt-2">Start weekday:</label>
      <b-form-select id="example-weekdays" v-model="weekday" :options="weekdays"></b-form-select>
      <b-form-checkbox v-model="showDecadeNav" switch inline class="my-2">
        Show decade navigation buttons
      </b-form-checkbox>
      <b-form-checkbox v-model="hideHeader" switch inline class="my-2">
        Hide the date header
      </b-form-checkbox> -->
    </b-col>
    <b-col md="auto">
      <b-calendar
        v-model="value"
        v-on:click="locale"
        v-bind="labels[locale] || {}"
        :locale="locale"
        :start-weekday="weekday"
        :hide-header="hideHeader"
        :show-decade-nav="showDecadeNav"
        @context="onContext"
      ></b-calendar>
    </b-col>
    <b-col>
      <p>Value: <b>'{{ value }}'</b></p>
      <p class="mb-0">Context:</p>
      <pre class="small">{{ context }}</pre>
   </b-col>
  </b-row>
</template>
      <!-- 検索入力テキストの追加 -->
      <div class="input-group mb-3">
        <span style=" font-size:32px">未完成todo検索:</span><input
          type="text"
          class="form-control"
          placeholder="未完成todo名前のキーワードを入力してください"
          aria-label="未完成todo名前のキーワードを入力してください"
          aria-describedby="button-addon2"
          v-model="inputtextsearch"
        />
        <button
          class="btn btn-outline-secondary"
          type="button"
          id="button-addon2"
          @click="search"
        ><b-icon icon="search"></b-icon>
          検索
        </button>
      </div>

      <div>
        <h4>全{{ total }}件中、{{ finish }}件完成した</h4>
      </div>
      <table class="table">
        <thead>
          <tr>
            <th scope="col">ID</th>
            <th scope="col">Name</th>
            <th scope="col">Status</th>
            <th scope="col">Delete</th>
            <th scope="col">calendar</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="item in items" :key="item.id">
            <th scope="row">{{ item.id }}</th>
            <td>{{ item.name }}</td>
            <td>
              <button
                type="button"
                class="btn btn-primary"
                @click="$store.dispatch('changeState', { item: item })"
              >
                <span v-if="item.status == 0"> todo </span>
                <span v-else class="done"> done </span>
              </button>
            </td>
            <td>
              <button
                type="button"
                class="btn btn-danger"
                @click="$store.dispatch('remove', { item: item })"
              >
                削除
              </button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
/* eslint-disable */
import { mapState } from "vuex";

export default {
  data() {
    return {

        value: '',
        context: null,
        showDecadeNav: false,
        hideHeader: false,
        locale: 'ja',
        locales: [
          { value: 'ja', text: '日付を選択' },
        //   { value: 'de', text: 'German (de)' },
        //   { value: 'ar-EG', text: 'Arabic Egyptian (ar-EG)' },
        //   { value: 'zh', text: 'Chinese (zh)' }
        ],
        weekday: 0,
        weekdays: [
          { value: 0, text: 'Sunday' },
          { value: 1, text: 'Monday' },
          { value: 6, text: 'Saturday' }
        ],
        labels: {
          de: {
            labelPrevDecade: 'Vorheriges Jahrzehnt',
            labelPrevYear: 'Vorheriges Jahr',
            labelPrevMonth: 'Vorheriger Monat',
            labelCurrentMonth: 'Aktueller Monat',
            labelNextMonth: 'Nächster Monat',
            labelNextYear: 'Nächstes Jahr',
            labelNextDecade: 'Nächstes Jahrzehnt',
            labelToday: 'Heute',
            labelSelected: 'Ausgewähltes Datum',
            labelNoDateSelected: 'Kein Datum gewählt',
            labelCalendar: 'Kalender',
            labelNav: 'Kalendernavigation',
            labelHelp: 'Mit den Pfeiltasten durch den Kalender navigieren'
          },
          'ar-EG': {
            weekdayHeaderFormat: 'narrow',
            labelPrevDecade: 'العقد السابق',
            labelPrevYear: 'العام السابق',
            labelPrevMonth: 'الشهر السابق',
            labelCurrentMonth: 'الشهر الحالي',
            labelNextMonth: 'الشهر المقبل',
            labelNextYear: 'العام المقبل',
            labelNextDecade: 'العقد القادم',
            labelToday: 'اليوم',
            labelSelected: 'التاريخ المحدد',
            labelNoDateSelected: 'لم يتم اختيار تاريخ',
            labelCalendar: 'التقويم',
            labelNav: 'الملاحة التقويم',
            labelHelp: 'استخدم مفاتيح المؤشر للتنقل في التواريخ'
          },
          zh: {
            weekdayHeaderFormat: 'narrow',
            labelPrevDecade: '过去十年',
            labelPrevYear: '上一年',
            labelPrevMonth: '上个月',
            labelCurrentMonth: '当前月份',
            labelNextMonth: '下个月',
            labelNextYear: '明年',
            labelNextDecade: '下一个十年',
            labelToday: '今天',
            labelSelected: '选定日期',
            labelNoDateSelected: '未选择日期',
            labelCalendar: '日历',
            labelNav: '日历导航',
            labelHelp: '使用光标键浏览日期'
          }
        
    },
      inputtext: "",
      inputtextsearch: "",
    };
  },

  computed: {
    ...mapState(["items"]),
    finish() {
      let sum = 0;
      for (const item of this.items) {
        sum += Number(item.status);
      }
      return sum;
    },
    total() {
      // return this.$store.state.items.length;
      return this.items.length;
    },
 
  

    
  },

  created() {
    this.$store.dispatch("getItems");
  },

  methods: {
    add() {
      if (this.inputtext !== "" && this.inputtext.length <= 64) {
        this.$store.dispatch("add", { name: this.inputtext, status: 0 });
        this.inputtext = "";
      } else {
        alert("入力した文字の長さが正しくない！");
        this.inputtext = "";
      }
      
    },
    // 
    setToday() {
        const now = new Date()
        this.value = new Date(now.getFullYear(), now.getMonth(), now.getDate())
      },
      clearDate() {
        this.value = ''
      },
  search() {
      if (this.inputtextsearch !== "" && this.inputtextsearch.length <= 64) {
        this.$store.dispatch("search", { name: this.inputtextsearch });
        this.inputtextsearch = "";
      } else {
        alert("入力した文字の長さが正しくない！");
        this.inputtextsearch = "";
      }
    },
     //搜索数据





    // search() {
    //   let search = this.items.toLowerCase();
    //   // let search = this.xmgcqkJsonsData.toLowerCase();
    //   let newListData = [];
    //   if (search) {
    //     this.xmgcqkJsonsData.filter((item) => {
    //       if (item.name.toLowerCase().indexOf(search) !== -1) {
    //         newListData.push(item);
    //       }
    //     });
    //   }
    //   this.xmgcqkJsonsData = newListData;
    //   // console.log(‘新数组',newListData)
    // },
  },
};
</script>

<style scoped>
div {
  background: rgb(250, 234, 236);
}
.container {
  margin: 0 auto;
  min-height: 100vh;
  justify-content: center;
  align-items: center;
  text-align: center;
}
.title {
  font-family: "Raleway", sans-serif;
  font-size: 80px;
  color: rgb(190, 10, 115);
}

.done {
  color: rgb(26, 6, 73);
}
</style>
/* eslint-enable */
