package com.qzhenghao.serviceImpl;

import com.qzhenghao.dao.MessageDao;
import com.qzhenghao.entity.Message;
import com.qzhenghao.entity.Page;
import com.qzhenghao.entity.Pageable;
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
    @Override
    public Page<Message> messageAllPage(Pageable pageable) {
        Page<Message> messagePage = new Page<Message>(pageable.getPageNo());
        messagePage.setTotalItemNumber(messageDao.queryAllCountId());
        pageable.setPageNo(messagePage.getPageNo());
        messagePage.setList(getPageList(pageable));
        return messagePage;
    }


    public List<Message> getPageList(Pageable cb) {
        return messageDao.queryAllPageOrdeByState(
                (cb.getPageNo() - 1) * cb.getPageSize(), cb.getPageSize());
    }
}
