import { ref } from "vue";

// 用户账号数据类型定义
interface Buyer {
    BuyerName: string;
    BuyerPhone: string;
  }
  
  //类型匹配与输出
  export const BuyerInfo = ref<Buyer>({
    BuyerName: "",
    BuyerPhone: "",
  });

  interface BuyerInfoRules{
    BuyerName: {
      type: string;
      message: string;
      required: boolean;
      trigger: string;
    }[];
    BuyerPhone: ({
      required: boolean;
      message: string;
      trigger: string;
      min?: undefined;
      max?: undefined;
    } | {
      min: number;
      max: number;
      message: string;
      trigger: string;
      required?: undefined;
    })[];
  }

  export const BuyerInfoRules = ref<BuyerInfoRules>({
    BuyerName: [
      {
        type: "BuyerName",
        message: "联系人姓名不能为空",
        required: true,
        trigger: "blur",
      },
    ],
    BuyerPhone: [
      //电话存在规则
      {
        required: true,
        message: "电话号码不能空",
        trigger: "blur",
      },
      //电话长度规则
      {
        min: 6,
        max: 15,
        message: "电话号码长度不正确",
        trigger: "blur",
      },
    ],
  });