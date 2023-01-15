<template>
  <div class="about">
    <h1>This is an about page</h1>
    <div>{{ demoStore.action.getDemo().count }}</div>
    <input type="button" @click="incrCount" value="+1">
  </div>
</template>

<script lang="ts" setup>
import {useDemoStore} from "@/store/DemoStore";

let demoStore = useDemoStore();

function incrCount() {
  demoStore.action.incrementCount();
}

</script>
