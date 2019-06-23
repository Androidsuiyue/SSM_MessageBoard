package com.qzhenghao.controller;

import com.alibaba.fastjson.JSONArray;
import com.qzhenghao.entity.Message;
import com.qzhenghao.entity.Page;
import com.qzhenghao.entity.Pageable;
import com.qzhenghao.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 14437 on 2017/3/1.
 */
@Controller
public class MessageController {
    @Autowired
    private MessageService messageService;

    /**
     * 查看留言接口
     * @param pageNo
     * @return map  存放所有留言
     */
    @RequestMapping(value = "/message/list", method = {RequestMethod.GET})
    @ResponseBody
    public Map<String,Object> getAllProducts( @RequestParam("pageNo") Integer pageNo){
        //分页
        Pageable pageable = new Pageable(pageNo);
        //按页查询出数据库中的留言
        Page<Message> messagePage = messageService.messageAllPage(pageable);
        List<Message> list = messagePage.getList();
        //按json格式存储
        String allMes = JSONArray.toJSONString(list);
        Map<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.put("allProducts",allMes);
        return resultMap;
    }

    @RequestMapping(value = "/getmessage", method = {RequestMethod.GET})
    @ResponseBody
    public Map<String,Object> messageinfo( @RequestParam("id") Integer id){
        String s = messageService.messageInfo(id);
        Map<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.put("result",s);
        return resultMap;
    }


    @RequestMapping(value = "/addmessage", method = RequestMethod.POST)
    public String addmessage(String topic,String content,String user) {
        System.out.println("添加了商品："+user+""+content);
        Message message = new Message();

        message.setTopic(topic);
        message.setContent(content);
        message.setUserId(Integer.parseInt(user));
        message.setState(0);
        String s = messageService.addMessage(message);
        if (s.equals("success")) {
             return "redirect:backend/mian";
        }
        return "404";
    }

    /**
     * 更新留言接口
     * @param inputid 对应的messageid
     * @param reply 对应的内容
     * @return
     */
    @RequestMapping(value = "/updatemessage", method = RequestMethod.POST)
    public String updatemessage(String inputid,String reply) {
        messageService.updateMessage(Integer.parseInt(inputid),reply);
        //跳转主页
        return "redirect:backend/mian";
    }







}
