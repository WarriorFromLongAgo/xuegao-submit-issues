import {IDemo} from "@/store/DemoBO";

function incrementCount(state: IDemo) {
  return () => {
    console.log("DemoAction state count state ", JSON.stringify(state));
    console.log("DemoAction state count 1 ", state.count);
    let count = state.count;
    state.count = ++count;
    // state.count += state.count;
    console.log("DemoAction state count 2 ", state.count);
  };
}

function getState(state: IDemo) {
  return () => {
    return state;
  };
}

function updateCount(state: IDemo) {
  return (count: number) => {
    state.count = count;
  };
}

function pushTempNameList(state: IDemo) {
  return (inputName: string) => {
    state.tempNameList.push(inputName);
  };
}

/**
 * 创建Action
 */
export function createAction(state: IDemo) {
  return {
    incrementCount: incrementCount(state),
    getDemo: getState(state),

    updateCount: updateCount(state),

    pushTempNameList: pushTempNameList(state),
  };
}
