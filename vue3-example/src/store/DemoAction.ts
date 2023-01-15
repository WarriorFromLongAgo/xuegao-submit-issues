import {IDemo} from "@/store/DemoBO";

function incrementCount(state: IDemo) {
  return () => {
    console.log("DemoAction state count state ", JSON.stringify(state));
    console.log("DemoAction state count 1 ", state.count);
    state.count = state.count + 1;
    // state.count += state.count;
    console.log("DemoAction state count 2 ", state.count);
    return state.count
  };
}

function getState(state: IDemo) {
  return () => {
      return state;
  };
}

/**
 * 创建Action
 */
export function createAction(state: IDemo) {
  return {
    incrementCount: incrementCount(state),
    getDemo: getState(state),
  };
}
