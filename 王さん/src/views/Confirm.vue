<template>
  <div class="confirm">
    <div>
      <div>
        <!--MS通し番号-->
        <b-form-group class="col-8" label="MS通し番号">
          <span class="content">MS 4</span>
        </b-form-group>

        <b-form-group class="col-8" label="NAPT用グローバルIP">
          <span class="content">現在 1個/ 上限 12個</span><br />
          <span class="content">グローバルIP数</span>
          <p>追加{{tData.addNapt}}個</p>
          <span class="content">払出済グローバルIP</span><br />
          <span class="content pl-3">グローバルIP</span><br />
            <div  v-for="item in del" :key="item">
            <span class="content pl-3"
              style="color:red">{{ item }}[削除]
            </span>
            </div>
        </b-form-group>

      </div>
    </div>
    <footer class="modal-footer justify-content-end btn-container">
      <b-button variant="primary" @click="getDate">登録</b-button>
      <b-button variant="outline-primary" @click="cancel">戻る</b-button>
    </footer>
  </div>
</template>

<script>
export default {
  props:{ tData:{},
          del:{} },
  data() {
    return {
      form: {
        Napt: [],
        Nat: [],
      },
  }
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
p{
color:red; 
}

.inpt{
color:red;
}
</style>