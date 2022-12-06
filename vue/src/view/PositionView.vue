<template>
  <div class="Topstory">
    <div class="Topstory-container">
      <div class="Topstory-mainColumn">
        <div class="Topstory-mainColumnCard">
          <div class="Card Topstory-noMarginCard Topstory-tabCard">
            <div id="TopstoryContent" class="Topstory-content">
              <div class="ListShortcut">
                <div class="Topstory-follow">
                  <div class="" role="list">
                    <div
                      v-for="(item, index) in PositionInfoLists"
                      :key="index"
                      :PositionInfo="item"
                    >
                      <PositionItem :PositionInfo="item"></PositionItem>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div
        class="css-1qyytj7"
        data-za-detail-view-path-module="RightSideBar"
        data-za-extra-module="{}"
      >
        <a
          aria-label="边栏锚点"
          aria-keyshortcuts="Shift+S"
          class="css-h9cq7d"
        ></a>
        <Navigate></Navigate>
      </div>
    </div>
  </div>
</template>

<script>
import PositionItem from "@/components/viewposition/PositionItem.vue";
import Navigate from "@/components/viewposition/Navigate.vue";
export default {
  name: "PositionView",
  data() {
    return {
        PositionInfoLists: [
            {
            header: "测试",
            content:"111"
        }
      ],
    };
  },
  mounted() {
  },
  methods: {
  },
  components: { PositionItem, Navigate },
};
</script>

<style scoped>
.Topstory-container {
  position: relative;
  display: -webkit-box;
  display: -ms-flexbox;
  display: flex;
  -webkit-box-align: start;
  -ms-flex-align: start;
  align-items: flex-start;
  width: 1000px;
  padding: 0 16px px;
  margin: 10px auto;
}
.Topstory-mainColumn {
  -ms-flex-negative: 0;
  flex-shrink: 0;
  margin-right: 10px;
  margin-bottom: 0;
  width: 694px;
}
.Topstory-tabs {
  border-bottom: 1px solid #f0f2f7;
}
.TopstoryTabs {
  display: flex;
  height: 58px;
}
.TopstoryTabs-link {
  -webkit-box-align: center;
  -ms-flex-align: center;
  align-items: center;
  display: -webkit-box;
  display: -ms-flexbox;
  display: flex;
  font-size: 16px;
  margin: 0 22px;
}
.TopstoryTabs-link.is-active {
  color: #056de8;
}
.TopstoryTabs-link.is-active {
  font-weight: 500;
}
.Topstory-tabCard {
  -webkit-box-shadow: none;
  box-shadow: none;
}
.Topstory-noMarginCard {
  margin-bottom: 0 !important;
}
.Topstory-mainColumnCard {
  -webkit-box-shadow: 0 1px 3px rgb(18 18 18 / 10%);
  box-shadow: 0 1px 3px rgb(18 18 18 / 10%);
}
.Card {
  margin-bottom: 10px;
  background: #fff;
  overflow: hidden;
  border-radius: 2px;
  -webkit-box-shadow: 0 1px 3px rgb(18 18 18 / 10%);
  box-shadow: 0 1px 3px rgb(18 18 18 / 10%);
  -webkit-box-sizing: border-box;
  box-sizing: border-box;
}
a {
  color: #000000;
  text-decoration: none;
}
a:-webkit-any-link {
  color: #000000;
  cursor: pointer;
  text-decoration: underline;
}
body {
  margin: 0;
}
.css-1qyytj7 {
  max-width: 296px;
  -webkit-align-self: normal;
  -ms-flex-item-align: normal;
  align-self: normal;
}
.css-h9cq7d {
  display: block;
  position: relative;
  top: -102px;
  width: 0px;
  height: 0px;
}
.Card:last-child {
  margin-bottom: 0;
}
.Card {
  background: #fff;
  border-radius: 2px;
  -webkit-box-shadow: 0 1px 3px hsl(0deg 0% 7% / 10%);
  box-shadow: 0 1px 3px hsl(0deg 0% 7% / 10%);
  -webkit-box-sizing: border-box;
  box-sizing: border-box;
  margin-bottom: 10px;
  overflow: hidden;
}
.Card {
  background: #fff;
  border-radius: 2px;
  -webkit-box-shadow: 0 1px 3px hsl(0deg 0% 7% / 10%);
  box-shadow: 0 1px 3px hsl(0deg 0% 7% / 10%);
  -webkit-box-sizing: border-box;
  box-sizing: border-box;
  margin-bottom: 10px;
  overflow: hidden;
}
</style>
