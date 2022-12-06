<template>
  <div class="Card TopstoryItem TopstoryItem-isFollow" tabindex="0">
    <div class="AuthorInfo">
      <div class="ContentItem AnswerItem">
        <h2 class="ContentItem-title">
          <div>
            <button
              @click="openpositiondetail()"
              onmouseover="this.style.color='#056de8';"
              onmouseout="this.style.color='#000000';"
            >
              {{ PositionInfo.header }}
            </button>
          </div>
        </h2>
      </div>
        <el-button text @click="dialogVisible = true">
        申请
        </el-button>
    </div>
    <div class="RichContent-inner">
      <div class="css-79elbk">
        <span
          class="RichText ztext CopyrightRichText-richText css-4em6pe"
          options="[object Object]"
          itemprop="text"
          >{{ PositionInfo.content }}
        </span>
      </div>
    </div>
    <p>
      --------------------------------------------------------------------------------------------
    </p>
  </div>
</template>

<script>
export default {
  data() {
    return {
      dialogVisible: false,
    };
  },
  props: ["PositionInfo"],
  mounted() {
  },
  methods: {
  },
};
</script>

<style>
.TopstoryItem-isFollow {
  padding-top: 15px;
}
.TopstoryItem {
  border-radius: 0;
  overflow: visible;
  overflow: initial;
  position: relative;
  padding: 16px 20px;
  outline: none;
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
.css-1gomreu {
  position: relative;
  display: inline-block;
}
.AuthorInfo {
  display: -webkit-box;
  display: -ms-flexbox;
  display: flex;
  -webkit-box-align: center;
  -ms-flex-align: center;
  align-items: center;
  -webkit-box-pack: justify;
  -ms-flex-pack: justify;
  justify-content: space-between;
  max-width: 654px;
  position: relative;
}
.AuthorInfo-head {
  display: -webkit-box;
  display: -ms-flexbox;
  display: flex;
  -webkit-box-align: center;
  -ms-flex-align: center;
  align-items: center;
  font-size: 15px;
  line-height: 1.1;
  -ms-flex-negative: 0;
  flex-shrink: 0;
}
.ztext {
  word-break: break-word;
  line-height: 1.6;
  white-space: nowrap;
}
.AuthorInfo-name {
  color: #444;
}
.AuthorInfo-name {
  font-weight: 600;
  font-synthesis: style;
}
.ContentItem-title {
  margin-top: -4px;
  margin-bottom: -4px;
}
.ContentItem-title {
  line-height: 1.6;
  color: #121212;
}
.ContentItem-title {
  font-size: 18px;
  font-weight: 600;
  font-synthesis: style;
}
h2 {
  margin: 0;
  font: inherit;
}
h2 {
  display: block;
  font-size: 1.5em;
  margin-block-start: 0.83em;
  margin-block-end: 0.83em;
  margin-inline-start: 0px;
  margin-inline-end: 0px;
  font-weight: bold;
}
.ContentItem-title {
  margin-top: -4px;
  margin-bottom: -4px;
}
.ContentItem-title {
  line-height: 1.6;
  color: #121212;
}
.ContentItem-title {
  font-size: 18px;
  font-weight: 600;
  font-synthesis: style;
}
h2 {
  margin: 0;
  font: inherit;
}
h2 {
  display: block;
  font-size: 1.5em;
  margin-block-start: 0.83em;
  margin-block-end: 0.83em;
  margin-inline-start: 0px;
  margin-inline-end: 0px;
  font-weight: bold;
}
.RichContent-inner {
  margin-top: 9px;
  margin-bottom: -4px;
  overflow: hidden;
}
.css-79elbk {
  position: relative;
}
.css-4em6pe {
  word-break: break-word;
  line-height: 1.6;
}
.ztext {
  word-break: break-word;
  line-height: 1.6;
}
body {
  margin: 0;
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
.css-go5ofn-TagsContainer-StyledTags {
  display: flex;
  flex-wrap: wrap;
  padding: 0px;
  margin-top: 4px;
}
.css-pvcibd-TagWrap {
  padding: 0px 8px;
  font-size: 12px;
  height: 24px;
  line-height: 20px;
  font-weight: 400;
  color: rgb(139, 132, 132);
  cursor: pointer;
  display: flex;
  -webkit-box-align: center;
  align-items: center;
  background-color: rgb(222, 223, 226);
  border-radius: 12px;
  margin: 2px 10px 2px 0px;
}
.e27myof1 {
  margin-top: 0px;
  margin-bottom: 0px;
  cursor: default;
}
</style>
