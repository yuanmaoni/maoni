<template>
  <v-card>
    <v-card-title>
      <span class="text-h5">住所検索</span>
    </v-card-title>
    <v-card-text>
      <v-container>
        <v-row>
          <v-col cols="12" sm="6" md="6">
            <v-text-field
              label="郵便番号*"
              required
              placeholder="9872146"
              v-model="postalCode"
            ></v-text-field>
          </v-col>
          <v-col cols="12" sm="6" md="4">
            <v-btn
              color="primary"
              dark
              v-bind="attrs"
              @click.stop="dialog = true"
            >
              住所検索
            </v-btn>
          </v-col>
          <v-col cols="12" sm="6" md="12">
            <v-text-field
              label="住所*"
              required
              v-model="selectedAddress"
            ></v-text-field>
          </v-col>
        </v-row>
      </v-container>
    </v-card-text>
  </v-card>

  <!-- 住所ポップアップpopup画面 -->
  <v-dialog v-model="dialog" persistent>
    <v-card>
      <v-card-title>
        <span class="text-h5">郵便番号からの住所検索</span>
      </v-card-title>
      <v-card-text>
        <v-container>
          <v-row>
            <v-col cols="12" sm="6" md="12">
              郵便番号:
              <v-chip class="ma-2" label> {{ postalCode }} </v-chip>
            </v-col>
            <v-radio-group v-model="addressGroup" column>
              <v-radio
                v-for="address in addresses"
                :key="address"
                v-bind:label="`${address}`"
                v-bind:value="address"
                @change="addressChange(address)"
                v-model="selectedAddress"
              ></v-radio>
            </v-radio-group>
          </v-row>
        </v-container>
      </v-card-text>
      <v-card-actions>
        <v-spacer></v-spacer>
        <v-btn color="blue darken-1" text @click="dialog = false">
          キャンセル
        </v-btn>
        <v-btn color="blue darken-1" text @click="select"> 選択 </v-btn>
      </v-card-actions>
    </v-card>
  </v-dialog>
</template>

<script lang="ts">
import { computed, defineComponent } from "vue";
import { usePostalSearch } from "./usePostalSearch";
export default defineComponent({
  data: () => ({
    addressGroup: "",
    dialog: false,
    selectedAddress: "",
  }),
  methods: {
    select: function (val: string) {
      this.dialog = false;
    },
    addressChange: function (val: string) {
      this.selectedAddress = val;
    },
  },
  setup() {
    // 🌟 「郵便番号→住所の検索」コンポジション関数を使う
    const { postalCode, addresses, isWaiting } = usePostalSearch();

    // 状態を元にメッセージを生成
    const resultMessage = computed(() => {
      const resultCount = addresses.value.length;
      if (isWaiting.value) return "...取得中";
      if (!postalCode.value) return "郵便番号（7桁）を入力してください";
      if (!resultCount) return "見つかりませんでした";
      return resultCount + "件見つかりました";
    });
    return {
      postalCode, // 郵便番号入力欄にv-modelでバインドする
      addresses,
      isWaiting,
      resultMessage,
    };
  },
});
</script>

<style lang="scss" scoped>
.PostalSearch {
  .msg {
    font-size: 12px;
    color: gray;
    text-align: left;
  }
}
</style>
