<template>
  <div >
      <ul>
    <li v-for="(name,index) in nameLists"  v-bind:key="index">
    {{ name }}
    </li>
  </ul>
</div>
</template>

<script>
export default {
  name: 'nameL',
  props: {
    nameLists: []
  },
  
}
</script>
<style scoped>
li{
list-style-type:none;
text-align: center;
}

</style >
