<template>
  <v-card>
    <v-card-title>
      <span class="text-h5">お客様情報入力</span>
    </v-card-title>
    <v-card-text>
      <v-container>
        <v-row>
          <v-col cols="12" sm="6" md="4">
            <v-text-field label="姓*" required></v-text-field>
          </v-col>
          <v-col cols="12" sm="6" md="4">
            <v-text-field
              label="名"
              hint="example of helper text only on focus"
            ></v-text-field>
          </v-col>
          <v-col cols="12">
            <v-text-field label="Email*" required></v-text-field>
          </v-col>
          <v-col cols="12">
            <v-text-field
              label="Password*"
              type="password"
              required
            ></v-text-field>
          </v-col>
          <v-col cols="12" sm="6" md="12">
            <v-select
              :items="['0-17', '18-29', '30-54', '54+']"
              label="Age*"
              required
            ></v-select>
          </v-col>

          <v-col cols="12" sm="6" md="12">
            <PostalSearch />
          </v-col>
        </v-row>
      </v-container>
      <small>*indicates required field</small>
    </v-card-text>
  </v-card>
  <!-- <v-container>
  </v-container> -->
</template>

<script lang='ts'>
import { defineComponent } from "vue";
import PostalSearch from "./postalSearch/PostalSearch.vue";

// Logo
import logo from "../assets/logo.svg";

export default defineComponent({
  name: "HelloWorld",
  components: {
    PostalSearch,
  },
  data() {
    return {};
  },
});
</script>
