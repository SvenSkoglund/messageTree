<template>
  <div id="app">
   <MessageTree v-bind:messages="messages"/>
  </div>
</template>

<script>
import MessageTree from './components/MessageTree.vue'

export default {
  name: 'app',
  components: {
    MessageTree
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
