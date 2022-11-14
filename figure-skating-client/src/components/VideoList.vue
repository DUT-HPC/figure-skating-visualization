<template>
  <div class="content">
    <el-table highlight-current-row :data="dataList" @row-click="handleClick">
      <el-table-column prop="name" label="视频" />
      <el-table-column prop="player" label="选手" />
      <el-table-column prop="introduction" label="介绍" />
      <el-table-column prop="music" label="选曲" />
      <el-table-column label="编辑" width="80" align="center">
        <template #default="scope">
          <el-dropdown>
            <el-icon><VideoPlay /></el-icon>
            <template #dropdown>
              <el-dropdown-menu>
                <el-dropdown-item @click="get_video_report(scope.row)">原始视频<VideoPlay /></el-dropdown-item>
                <el-dropdown-item @click="get_openpoes_report(scope.row)">骨骼点视频<VideoPlay /></el-dropdown-item>
                <el-dropdown-item @click="get_segment_report(scope.row)">分割视频<VideoPlay /></el-dropdown-item>
              </el-dropdown-menu>
            </template>
          </el-dropdown>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script lang="ts">
import { defineComponent, getCurrentInstance, toRefs, computed, reactive } from "vue";
import { useStore } from "vuex";
import mixin from "@/mixins/mixin";
import { MoreFilled, Delete, Download, VideoPlay } from "@element-plus/icons-vue";
import { HttpManager } from "@/api";
import { Icon } from "@/enums";


export default defineComponent({
  components: {
    VideoPlay,
  },
  props: {
    songList: Array,
    show: {
      default: false
    }
  },
  emits: ["changeData"],
  setup(props) {
    const { getSongTitle, getSingerName, playMusic, checkStatus, downloadMusic } = mixin();
    const { proxy } = getCurrentInstance();
    const store = useStore();

    const { songList } = toRefs(props);

    const iconList = reactive({
      dislike: Icon.Dislike,
      like: Icon.Like,
    });
    let videoState = false;
    const songUrl = computed(() => store.getters.songUrl);
    const singerName = computed(() => store.getters.singerName);
    const songTitle = computed(() => store.getters.songTitle);
    const dataList = computed(() => {
      const list = [];
      songList.value.forEach((item: any, index) => {
        item["songName"] = getSongTitle(item.name);
        item["singerName"] = getSingerName(item.name);
        item["index"] = index;
        list.push(item);
      });
      return list;
    });

    function handleClick(row) {
      playMusic({
        id: row.id,
        url: row.url,
        pic: row.pic,
        index: row.index,
        name: row.name,
        lyric: row.lyric,
        currentSongList: songList.value,
      });
    }

    function handleEdit(row) {
      console.log("row", row);
    }

    const userId = computed(() => store.getters.userId);

    async function deleteCollection({ id }) {
      if (!checkStatus()) return;

      const result = (await HttpManager.deleteCollection(userId.value, id)) as ResponseBody;
      (proxy as any).$message({
        message: result.message,
        type: result.type,
      });

      if (result.data === false) proxy.$emit("changeData", result.data);
    }

    function get_video_report(row) {
      const video_url = HttpManager.VideoPath(row.videoPath);
      console.log("video_url", video_url);
      window.open(video_url);
    }

    function get_openpoes_report(row) {
      const video_url = HttpManager.VideoPath(row.openposeVideoPath);
      console.log("video_url", video_url);
      window.open(video_url);
    }

    function get_segment_report(row) {
      const video_url = HttpManager.VideoPath(row.segmentVideoPath);
      console.log("video_url", video_url);
      window.open(video_url);
    }



    return {
      dataList,
      iconList,
      Delete,
      Download,
      songUrl,
      singerName,
      songTitle,
      handleClick,
      handleEdit,
      downloadMusic,
      deleteCollection,
      get_video_report,
      get_openpoes_report,
      get_segment_report,
    };

  },
});


</script>



<style lang="scss" scoped>
@import "@/assets/css/var.scss";
@import "@/assets/css/global.scss";

.content {
  background-color: $color-white;
  border-radius: $border-radius-songlist;
  padding: 10px;
}

.content:deep(.el-table__row.current-row) {
  color: $color-black;
  font-weight: bold;
}

.content:deep(.el-table__row) {
  cursor: pointer;
}

.icon {
  @include icon(1.2em, $color-black);
}

 .mask {
   position: fixed;
   top: 0;
   left: 0;
   bottom: 0;
   right: 0;
   z-index: 10;
   background-color: #000000;
   opacity: 0.6;
 }
/* 内容层 z-index要比遮罩大，否则会被遮盖 */
.video-masks {
  max-width: 1200px;
  position: fixed;
  left: 0;
  top: 50%;
  margin-top: -30%;
  z-index: 20;
  /* transform: translate(-50%, -50%); */
}
</style>
