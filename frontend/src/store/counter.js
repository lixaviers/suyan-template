import { defineStore } from 'pinia'

export const useCounterStore = defineStore('counter', {
  state: () => ({
    count: 0
  }),
  getters: {
    doubleCount: (state) => state.count * 2
  },
  actions: {
    setCount(value) {
      this.count = value
    },
    increment() {
      this.count++
    },
    decrement() {
      this.count--
    },
    saveToLocal() {
      localStorage.setItem('counter', JSON.stringify(this.count))
    },
    loadFromLocal() {
      const saved = localStorage.getItem('counter')
      if (saved) {
        this.count = JSON.parse(saved)
      }
    }
  }
})