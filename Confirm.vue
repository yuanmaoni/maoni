<template>
  <div class="modal-content">
    <div>
      <div>
        <!--MS通し番号-->
        <b-form-group class="col-12" label="MS通し番号">
          <span class="content">MS 4</span>
        </b-form-group>

        <!--NAPT用グローバルIP-->
        <b-form-group class="col-12" label="NAPT用グローバルIP">
          <span class="content">現在 1個/ 上限 12個</span><br />
          <span class="content">グローバルIP数</span><br />
          <span :class="{ red: !(JSON.parse(this.$route.params.data).addNapt==='追加0個')}">{{ JSON.parse(this.$route.params.data).addNapt}}</span><br />
          <span class="content">払出済グローバルIP</span><br />
          <span class="content pl-3">グローバルIP</span><br />
          <div v-for="item in  JSON.parse(this.$route.params.data).napt" :key="item">
            <span :class="{ red: (item.indexOf('削除') != -1)} " class="content pl-3">
              {{ item }}
            </span>
            <br />
          </div>
        </b-form-group>
        <br />
        

        <!--NAT用グローバルIP-->
        <b-form-group class="col-12" label="NAT用グローバルIP">
          <span class="content">現在 1個/ 上限 12個</span><br />
          <span class="content">グローバルIP数</span><br />
          <span :class="{ red: !(JSON.parse(this.$route.params.data).addNat==='追加0個')}">{{ JSON.parse(this.$route.params.data).addNat}}</span><br />
          <span class="content">払出済グローバルIP</span><br />
          <span class="content pl-3">グローバルIP</span><br />
          <div v-for="item in JSON.parse(this.$route.params.data).nat" :key="item">
            <span :class="{ red: (item.indexOf('削除') != -1)} " class="content pl-3">
              {{ item }}
            </span>
            <br />
          </div>
        </b-form-group>
      </div>
    </div>
    <footer class="modal-footer justify-content-end btn-container">
      <b-button variant="primary" @click="update">登録</b-button>
      <b-button variant="outline-primary" @click="back">戻る</b-button>
    </footer>
  </div>
</template>

<script>
export default {
  name: "Confirm",

  data() {
    return {
    };
  },
  props: {
  },
  methods: {
    back(){
      this.$router.go(-1)
    },
    update(){}
  }
}
</script>

<style lang="scss" scoped>
::v-deep {
  .multicloud-modal {
    .vfm__content {
      width: 900px;
    }
  }

  .pagination {
    padding-right: 1em;
  }

  //項目欄固定なし
  .b-table-sticky-header > .table.b-table > thead > tr > th {
    position: static;
  }
}
.content {
  margin-left: 1em;
}
.red{
  color: red;
}
</style>
