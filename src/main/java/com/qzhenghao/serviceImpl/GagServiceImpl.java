package com.qzhenghao.serviceImpl;

import com.qzhenghao.dao.GagDao;
import com.qzhenghao.entity.Gag;
import com.qzhenghao.service.GagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ${符柱成} on 2017/4/1.
 */
@Service
public class GagServiceImpl implements GagService {
    @Autowired
    private GagDao gagDao;
    @Override
    public int insertGag(Gag gag) {
        int t = gagDao.insertGag(gag);
        return t;
    }

    @Override
    public List<Gag> findByUserId(Long id) {
        List<Gag> gagList=gagDao.findByUserId(id);
        return gagList;
    }
}
