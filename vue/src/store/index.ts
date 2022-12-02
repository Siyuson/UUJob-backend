import { createStore } from 'vuex'

export default createStore({
  state: {
    userId: "17b102d5-13cc-4b58-8665-30fad179dbc2",
    orderStore: [],
    flightStore: [],
    pass:0,
  },
  getters: {
  },
  mutations: {
    set(state, value) {
      state.userId = value;
    },
    setOrder(state, value) {
      state.orderStore = value;
    },
    setFlight(state, value) {
      state.flightStore = value;
    },
    setPass(state, value) {
      state.pass = value;
    }
  },
  actions: {
  },
  modules: {
  }
})
