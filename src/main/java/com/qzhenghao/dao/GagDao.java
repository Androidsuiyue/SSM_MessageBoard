package com.qzhenghao.dao;

import com.qzhenghao.entity.Gag;

import java.util.List;

/**
 * Created by ${符柱成} on 2017/3/31.
 */
public interface GagDao {
    public int insertGag(Gag gag);
    List<Gag> findByUserId(Long id);
}
