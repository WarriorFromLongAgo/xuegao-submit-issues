import {readonly} from "vue";
import {createState} from "@/store/DemoBO";
import {createAction} from "@/store/DemoAction";

const state = createState();
const action = createAction(state);

export const useDemoStore = () => {
  return {
    state: readonly(state),
    action: readonly(action),
  };
};
