import { reactive } from "vue";

interface IDemo {
  count: number;
}

const demo: IDemo = {
  count: 0,
};

function createState() {
  return reactive(demo);
}

export { demo, IDemo, createState };
