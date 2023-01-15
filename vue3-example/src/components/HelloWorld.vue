<template>
  <div class="hello">
    <!--    <h1>{{ msg }}</h1>-->
    <!--    <p>-->
    <!--      For a guide and recipes on how to configure / customize this project,<br>-->
    <!--      check out the-->
    <!--      <a href="https://cli.vuejs.org" target="_blank" rel="noopener">vue-cli documentation</a>.-->
    <!--    </p>-->
    <!--    <h3>Installed CLI Plugins</h3>-->
    <!--    <ul>-->
    <!--      <li><a href="https://github.com/vuejs/vue-cli/tree/dev/packages/%40vue/cli-plugin-babel" target="_blank"-->
    <!--             rel="noopener">babel</a></li>-->
    <!--      <li><a href="https://github.com/vuejs/vue-cli/tree/dev/packages/%40vue/cli-plugin-router" target="_blank"-->
    <!--             rel="noopener">router</a></li>-->
    <!--      <li><a href="https://github.com/vuejs/vue-cli/tree/dev/packages/%40vue/cli-plugin-eslint" target="_blank"-->
    <!--             rel="noopener">eslint</a></li>-->
    <!--      <li><a href="https://github.com/vuejs/vue-cli/tree/dev/packages/%40vue/cli-plugin-typescript" target="_blank"-->
    <!--             rel="noopener">typescript</a></li>-->
    <!--    </ul>-->
    <!--    <h3>Essential Links</h3>-->
    <!--    <ul>-->
    <!--      <li><a href="https://vuejs.org" target="_blank" rel="noopener">Core Docs</a></li>-->
    <!--      <li><a href="https://forum.vuejs.org" target="_blank" rel="noopener">Forum</a></li>-->
    <!--      <li><a href="https://chat.vuejs.org" target="_blank" rel="noopener">Community Chat</a></li>-->
    <!--      <li><a href="https://twitter.com/vuejs" target="_blank" rel="noopener">Twitter</a></li>-->
    <!--      <li><a href="https://news.vuejs.org" target="_blank" rel="noopener">News</a></li>-->
    <!--    </ul>-->
    <!--    <h3>Ecosystem</h3>-->
    <!--    <ul>-->
    <!--      <li><a href="https://router.vuejs.org" target="_blank" rel="noopener">vue-router</a></li>-->
    <!--      <li><a href="https://vuex.vuejs.org" target="_blank" rel="noopener">vuex</a></li>-->
    <!--      <li><a href="https://github.com/vuejs/vue-devtools#vue-devtools" target="_blank" rel="noopener">vue-devtools</a>-->
    <!--      </li>-->
    <!--      <li><a href="https://vue-loader.vuejs.org" target="_blank" rel="noopener">vue-loader</a></li>-->
    <!--      <li><a href="https://github.com/vuejs/awesome-vue" target="_blank" rel="noopener">awesome-vue</a></li>-->
    <!--    </ul>-->
    <input type="button" @click="incrCount" value="+1">
    <div>
      <input v-model="updateCount">
      <input type="button" @click="updateCountMethod" value="updateCount">
    </div>
    <div>
      <ul>
        <li
            v-for="(item, index) in showTempNameList"
            class="message-item"
            :key="index"
        >
          <div>{{ item }}</div>
        </li>
      </ul>
    </div>
    <div>
      <input v-model="tempName">
      <input type="button" @click="pushTempName" value="pushTempName">
    </div>
  </div>
</template>

<script lang="ts">
import {defineComponent} from "vue";
import {useDemoStore} from "@/store/DemoStore";

let demoStore = useDemoStore();

export default defineComponent({
  name: "HelloWorld",
  props: {
    msg: String,
  },
  data() {
    return {
      updateCount: 0,
      tempName: "10",
    };
  },
  methods: {
    incrCount: function () {
      demoStore.action.incrementCount();
    },
    updateCountMethod: function () {
      demoStore.action.updateCount(this.updateCount);
    },
    pushTempName: function () {
      let tempNameInt = Number(this.tempName);
      tempNameInt++;
      this.tempName = tempNameInt.toString();
      demoStore.action.pushTempNameList(tempNameInt.toString());
    },
  },
  computed: {
    showTempNameList: function () {
      return demoStore.action.getDemo().tempNameList;
    },
  },
})
;


</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  display: inline-block;
  margin: 0 10px;
}

a {
  color: #42b983;
}
</style>
