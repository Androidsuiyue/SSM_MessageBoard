package com.qzhenghao.service;

import com.qzhenghao.entity.Message;
import com.qzhenghao.entity.Page;
import com.qzhenghao.entity.Pageable;

/**
 * @author suiyue
 * @description TODO
 * @date 2019/5/31 15:55
 */
public interface MessageService {

    /**
     * 查询所有留言排序
     */
    Page<Message> messageAllPage(Pageable pageable);
}
