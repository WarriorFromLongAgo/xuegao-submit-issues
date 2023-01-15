import { reactive } from "vue";

interface IDemo {
  count: number;
  tempNameList: Array<string>
}

const demo: IDemo = {
  count: 0,
  tempNameList: ["1", "2", "3"]
};

function createState() {
  return reactive(demo);
}

export { demo, IDemo, createState };
