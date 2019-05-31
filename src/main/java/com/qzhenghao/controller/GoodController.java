//package com.qzhenghao.controller;
//
//import com.alibaba.fastjson.JSON;
//import com.qzhenghao.entity.GoodDetails;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.servlet.http.HttpServletResponse;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
///**
// * Created by ${符柱成} on 2017/4/6.
// */
//@RestController
//@RequestMapping("/good")
//public class GoodController {
//    @Autowired
//    private GoodService goodService;
//
//
//    // 文字检索
//    @RequestMapping(value = "/findGoodByName",produces="text/html;charset=UTF-8", method = {RequestMethod.GET,RequestMethod.GET})
//    public Object findGoodByName(String goodName, HttpServletResponse response)
//            throws Exception {
//        response.setHeader("Access-Control-Allow-Origin", "*");
//         List<GoodDetails> goodList = null;
//        System.out.println("查找商品名参数：" + goodName);
//        System.out.println("-------------------------------");
//
//        List<GoodDetails> goodDetailsList = goodService.findIndex(goodName, 0,
//                2);// 100
//        System.out.println("goodDetailsList=" + goodDetailsList.size());
//
//        String realGoodid = null;
//        GoodDetails goodAllDetails = new GoodDetails();
//        goodList = new ArrayList<GoodDetails>();
//
//        if (goodDetailsList != null && goodDetailsList.size() > 0) {
//            long start = System.nanoTime();
//            for (int index = 0; index < goodDetailsList.size(); index++) {
//                realGoodid = goodDetailsList.get(index).getGoodId();
//                goodAllDetails = goodService.findGoodAllDetailsById(realGoodid);
//                if (goodAllDetails == null) {
//                    System.out.println("realGoodid=" + realGoodid);
//                }
//                if (goodAllDetails != null) {
//                    goodAllDetails.setGoodName(goodDetailsList.get(index)
//                            .getGoodName() + realGoodid);
//                    goodList.add(goodAllDetails);
//                }
//            }
//            long time = System.nanoTime() - start;
//            System.out.println("测试耗时！！！！"+time);
//        }
//        System.out.println("现在北京时间是：" + new Date());
//        if (goodList != null) {
//            System.out.println("根据商品名找到的商品数目" + goodList.size());
//        }
//        return JSON.toJSONString(goodList);
//
//    }
//
//}
