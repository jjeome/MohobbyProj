import Vue from "vue";
import App from "./App.vue";
import vuetify from "./plugins/vuetify";
import router from "./router";
import axios from "axios";
import $ from "jquery";
import ImageViewer from "vue2-viewer";
import store from "./store";
import vueMoment from "vue-moment";
import { BootstrapVue, BootstrapVueIcons } from "bootstrap-vue";
import VueSweetalert2 from 'vue-sweetalert2';
import 'sweetalert2/dist/sweetalert2.min.css';

Vue.use(VueSweetalert2);

Vue.use(BootstrapVue);
Vue.use(BootstrapVueIcons);

Vue.use(vueMoment);
Vue.use(ImageViewer);
Vue.config.productionTip = false;

Vue.prototype.axios = axios;
Vue.prototype.$ = $;
axios.defaults.baseURL = "http://localhost:8088/java";
window.Kakao.init("157b38874395f658a48c02cc8473066b"); // 카카오 로그인 앱 키


Vue.filter("toFixed", (val, num) => {
  let result;
  if(val==0 || val==0.0 || val==null || isNaN(val)) {
    return 0;
  } else if (val % 1 == 0) {
    result = val;
  } else if ( val % 1 * 10 % 1 == 0 ) {
    result = val;
  } else {
    result = parseFloat(val), toFixed(num);
  }
  return result;
});
Vue.filter("comma", (val) => {
  return String(Math.round(val)).replace(/\B(?=(\d{3})+(?!\d))/g, ",");
});
Vue.filter("won", (val) => {
  return `${val} 원`;
});
Vue.filter("idx", (val) => {
  if(val < 10) {
    return "0"+val;
  }
  return val;
});
Vue.filter("runtime", (val) => {
  if(val < 10) {
    return "00:0"+val;
  }else if(val <= 60) {
    return "00:"+val;
  }

  let m = (parseInt(val / 60)).toString();
  let s = (val % 60).toString();

  let mm = m;
  let ss = s;
  if(m<10){
    mm = "0"+m;
  }
  if(s<10){
    ss = "0"+s;
  }

  return mm+":"+ss;
});
Vue.filter("starRatio", (val, total) => {
  return (val / total) * 100;
})



new Vue({
  vuetify,
  router,
  store,
  render: (h) => h(App),
}).$mount("#app");
