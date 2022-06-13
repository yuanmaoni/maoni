<template>
  <v-app>
    <v-main>
      <InputPage/>
    </v-main>
  </v-app>
</template>

<script lang="ts">
import { defineComponent } from 'vue'
import InputPage from './components/InputPage.vue'

export default defineComponent({
  name: 'App',

  components: {
    InputPage,
  },

  data () {
    return {
      //
    }
  },
})
</script>
