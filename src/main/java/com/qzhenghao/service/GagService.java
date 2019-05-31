package com.qzhenghao.service;

import com.qzhenghao.entity.Gag;

import java.util.List;

/**
 * Created by ${符柱成} on 2017/4/1.
 */
public interface GagService {
    public int insertGag(Gag gag);
    List<Gag> findByUserId(Long id);
}
