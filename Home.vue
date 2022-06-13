<template>
  <div class="modal-content">
    <div>
      <div>
        <!--MS通し番号-->
        <b-form-group class="col-8" label="MS通し番号">
          <span class="content">MS 4</span>
        </b-form-group>

        <!--NAPT用グローバルIP-->
        <b-form-group class="col-8" label="NAPT用グローバルIP">
          <span class="content">現在 1個/ 上限 12個</span><br />
          <span class="content">グローバルIP数</span><br />
          <b-form-input class="content" v-model="ipCountNapt" />
          <span class="content">払出済グローバルIP</span><br />
          <span class="content pl-3">グローバルIP</span><br />
          <div v-for="item in form.Napt" :key="item">
            <span class="content pl-3"
              >{{ item }}
              <span v-if="form.Napt.length > 1" class="ml-3">
                <b-icon-dash-square
                  class="remoteIcon"
                  @click="removeNapt(item)"
                />
              </span>
              <span v-else /> </span
            ><br />
          </div>
        </b-form-group>
        <br />
        <br />
        <!--NAT用グローバルIP-->
        <b-form-group class="col-8" label="NAT用グローバルIP">
          <span class="content">現在 1個/ 上限 12個</span><br />
          <span class="content">グローバルIP数</span><br />
          <b-form-input class="content" v-model="ipCountNat" />
          <span class="content">払出済グローバルIP</span><br />
          <span class="content pl-3">グローバルIP</span><br />
          <div v-for="item in form.Nat" :key="item">
            <span class="content pl-3"
              >{{ item }}
              <span v-if="form.Nat.length > 1" class="ml-3">
                <b-icon-dash-square
                  class="remoteIcon"
                  @click="removeNat(item)"
                />
              </span>
              <span v-else /> </span
            ><br />
          </div>
        </b-form-group>
      </div>
    </div>
    <footer class="modal-footer justify-content-end btn-container">
      <b-button variant="primary" @click="update">変更</b-button>
      <b-button variant="outline-primary" @click="cancel">キャンセル</b-button>
    </footer>
  </div>
</template>

<script lang="ts">
import { Component, Vue } from "vue-property-decorator"
// import Vue from "vue";
// import Component from "vue-class-component";

const GlobalIpNaptNat = {
  NAPT: ["44.124.186.05/32", "44.124.186.06/32", "246.124.186.05/32"],
  NAT: ["44.124.186.05/32", "44.124.186.06/32", "246.124.186.05/32"],
};

interface objIP {
  Napt: string[];
  Nat: string[];
}
interface objConfirm {
  addNapt: string;
  napt: string[];
  addNat: string;
  nat: string[];
}

@Component
export default class Home extends Vue {
  // ==========data============ //
  name: string = "MSGlobalIpModify";
  form: objIP = { Napt: [""], Nat: [""] };
  // 変更前のグローバルIP
  ipNaptBefore: string[] = [];
  ipNatBefore: string[] = [];
  // 変更前のグローバルIP数
  ipCountNaptBefore: number = 0;
  ipCountNatBefore: number = 0;
  // 変更後のグローバルIP数
  ipCountNapt: number = 0;
  ipCountNat: number = 0;
  // 削除されたIP（Napt）
  delNapt: string[] = [];
  // 削除されたIP（Nat）
  delNat: string[] = [];
  // 確認画面への転送データ
  confirmdata: objConfirm = {
    addNapt: "",
    napt: [],
    addNat: "",
    nat: [],
  };

  // ==========methods============ //
  removeNapt(target: string) {
    this.form.Napt = this.form.Napt.filter((item) => item !== target);
    this.delNapt.push(target);
  }

  removeNat(target: string) {
    this.form.Nat = this.form.Nat.filter((item) => item !== target);
    this.delNat.push(target);
  }

  cancel() {}

  update() {
    // 確認画面への転送データ
    // NaptIP追加個数
    this.confirmdata.addNapt =
      "追加" + (this.ipCountNapt - this.ipCountNaptBefore) + "個";
    // NaptIP
    this.ipNaptBefore.forEach((item) => {
      if (this.delNapt.indexOf(item) != -1) {
        this.confirmdata.napt.push(item + "[削除]");
      } else {
        this.confirmdata.napt.push(item);
      }
    });
    // NatIP追加個数
    this.confirmdata.addNat =
      "追加" + (this.ipCountNat - this.ipCountNatBefore) + "個";
    // NatIP
    this.ipNatBefore.forEach((item) => {
      if (this.delNat.indexOf(item) != -1) {
        this.confirmdata.nat.push(item + "[削除]");
      } else {
        this.confirmdata.nat.push(item);
      }
    });
    // 確認画面へ遷移
    this.$router.push({
      name: "Confirm",
      params: { data:JSON.stringify(this.confirmdata) },
    });
  }

  async mounted() {
    // グローバルIP
    this.ipNaptBefore = GlobalIpNaptNat.NAPT;
    this.ipNatBefore = GlobalIpNaptNat.NAT;
    this.form.Napt = GlobalIpNaptNat.NAPT;
    this.form.Nat = GlobalIpNaptNat.NAT;
    // グローバルIP数
    this.ipCountNaptBefore = GlobalIpNaptNat.NAPT.length;
    this.ipCountNatBefore = GlobalIpNaptNat.NAT.length;
    this.ipCountNapt = GlobalIpNaptNat.NAPT.length;
    this.ipCountNat = GlobalIpNaptNat.NAT.length;
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
</style>
