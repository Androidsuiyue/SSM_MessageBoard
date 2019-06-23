package com.qzhenghao.serviceImpl;

import com.alibaba.fastjson.JSONArray;
import com.qzhenghao.dao.MessageDao;
import com.qzhenghao.dao.UserDao;
import com.qzhenghao.entity.Message;
import com.qzhenghao.entity.Page;
import com.qzhenghao.entity.Pageable;
import com.qzhenghao.entity.User;
import com.qzhenghao.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author suiyue
 * @description TODO
 * @date 2019/5/31 15:55
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDao messageDao;
    @Autowired
    private UserDao userDao;
    @Override
    public Page<Message> messageAllPage(Pageable pageable) {
        Page<Message> messagePage = new Page<Message>(pageable.getPageNo());
        messagePage.setTotalItemNumber(messageDao.queryAllCountId());
        pageable.setPageNo(messagePage.getPageNo());
        List<Message> pageList = getPageList(pageable);
        System.out.println(pageList);

        messagePage.setList(pageList);

        return messagePage;
    }

    @Override
    public String messageInfo(int id) {

        Message message = messageDao.queryById(id);
        int userId = message.getUserId();
        User user = userDao.queryById(userId);

        message.setUserName(user.getName());

        String allMes = JSONArray.toJSONString(message);

        return allMes;
    }
    @Override
    public String addMessage(Message message) {
        String result = "fail";

        int i = messageDao.insertMessage(message);
        if (i != 0) {
            result = "success";
        }
        return result;
    }

    @Override
    public String addMessage(int user_id, String topic, String content) {
        String result = "fail";
        Message message = new Message();
        message.setUserId(user_id);
        message.setContent(content);
        message.setState(0);
        message.setTopic(topic);
        int i = messageDao.insertMessage(message);
        if (i != 0) {
            result = "success";
        }
        return result;
    }
    @Override
    public void updateMessage(int message_id, String reply) {
        messageDao.updateMessage(message_id, reply,1);
    }



    public List<Message> getPageList(Pageable cb) {
        return messageDao.queryAllPageOrdeByState(
                (cb.getPageNo() - 1) * cb.getPageSize(), cb.getPageSize());
    }
}
