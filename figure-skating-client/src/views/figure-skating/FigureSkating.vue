<template>
  <!--轮播图-->
  <el-carousel v-if="swiperList.length" class="swiper-container" type="card" height="20vw" :interval="4000">
    <el-carousel-item v-for="(item, index) in swiperList" :key="index">
      <img :src="HttpManager.attachImageUrl(item.pic)" />
    </el-carousel-item>
  </el-carousel>
<!--  &lt;!&ndash;热门歌单&ndash;&gt;-->
<!--  <play-list class="play-list-container" title="歌单" path="song-sheet-detail" :playList="songList"></play-list>-->
<!--  &lt;!&ndash;热门歌手&ndash;&gt;-->
<!--  <play-list class="play-list-container" title="歌手" path="singer-detail" :playList="singerList"></play-list>-->
  <!--花样滑冰视频-->
  <play-list :playList="data"  title="单人滑" path="singer-detail"></play-list>
  <el-pagination
      class="pagination"
      background
      layout="total, prev, pager, next"
      :current-page="currentPage"
      :page-size="pageSize"
      :total="allPlayList.length"
      @current-change="handleCurrentChange"
  >
  </el-pagination>


</template>

<script lang="ts" setup>
import {ref, onMounted, computed} from "vue";
import PlayList from "@/components/PlayList.vue";
import {  NavName } from "@/enums";
import { HttpManager } from "@/api";
import mixin from "@/mixins/mixin";

import YinNav from "@/components/layouts/YinNav.vue";
import { singerStyle } from "@/enums";


const songList = ref([]); // 歌单列表
const singerList = ref([]); // 歌手列表
const swiperList = ref([]);// 轮播图 每次都在进行查询
const { changeIndex } = mixin();

const activeName = ref("全部歌手");
const pageSize = ref(15); // 页数
const currentPage = ref(1); // 当前页
const allPlayList = ref([]);

// computed
const data = computed(() => {
  return allPlayList.value.slice((currentPage.value - 1) * pageSize.value, currentPage.value * pageSize.value);
});

// 获取所有歌手
async function getAllSinger() {
  const result = (await HttpManager.getAllSinger()) as ResponseBody;
  currentPage.value = 1;
  allPlayList.value = result.data;
}

getAllSinger();

// 获取当前页
function handleCurrentChange(val) {
  currentPage.value = val;
}

function handleChangeView(item) {
  activeName.value = item.name;
  allPlayList.value = [];
  if (item.name === "全部歌手") {
    getAllSinger();
  } else {
    getSingerSex(item.type);
  }
}

// 通过性别对歌手分类
async function getSingerSex(sex) {
  const result = (await HttpManager.getSingerOfSex(sex)) as ResponseBody;
  currentPage.value = 1;
  allPlayList.value = result.data;
}

try {

  HttpManager.getFigureSkatingBannerList().then((res) => {
    swiperList.value = (res as ResponseBody).data.sort();
  });

  HttpManager.getSongList().then((res) => {
    songList.value = (res as ResponseBody).data.sort().slice(0, 10);
  });

  HttpManager.getAllSinger().then((res) => {
    singerList.value = (res as ResponseBody).data.sort().slice(0, 10);
  });

  onMounted(() => {
    changeIndex(NavName.Home);
  });
} catch (error) {
  console.error(error);
}
</script>

<style lang="scss" scoped>
@import "@/assets/css/var.scss";

/*轮播图*/
.swiper-container {
  width: 90%;
  margin: auto;
  padding-top: 20px;
  img {
    width: 100%;
  }
}

.swiper-container:deep(.el-carousel__indicators.el-carousel__indicators--outside) {
  display: inline-block;
  transform: translateX(30vw);
}

.el-slider__runway {
  background-color: $color-blue;
}
</style>
