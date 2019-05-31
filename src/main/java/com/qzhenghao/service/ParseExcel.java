package com.qzhenghao.service;

import com.qzhenghao.entity.GoodDetails;

import java.io.File;
import java.util.List;

/**
 * Created by asus on 2017/5/27.
 */
public interface ParseExcel {
    List<GoodDetails> parseExcel(File xlsFile, String filename);
}
