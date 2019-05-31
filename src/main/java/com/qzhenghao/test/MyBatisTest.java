package com.qzhenghao.test;

import com.qzhenghao.dao.GagDao;
import com.qzhenghao.dao.ScoreDao;
import com.qzhenghao.dao.UserDao;
import com.qzhenghao.entity.Gag;
import com.qzhenghao.entity.Score;
import com.qzhenghao.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import java.util.Date;


/**
 * Created by ${符柱成} on 2017/3/31.
 */
@RunWith(SpringJUnit4ClassRunner.class) // 使用Springtest测试框架
@ContextConfiguration("/spring/spring-*.xml") // 加载配置
public class MyBatisTest {
    @Autowired
    private ScoreDao scoreDao;
    @Autowired
    private GagDao gagDao;
    private ShardedJedisPool shardedJedisPool;
    private ShardedJedis jedis;

    @Test
    public void testAddScore() {
        User user = new User();

        Score score = new Score();
        score.setChangeType("充钱钱");
        score.setScore(10);
        score.setUser(user);
        int insert = scoreDao.insertScore(score);
        System.out.print("insert :" + insert);
    }

    @Autowired
    private UserDao userDao;
    @Test
    public void testRedisData() {

        User insertSuccess = userDao.queryByUsernumber("18401210137");
        System.out.print("insert :" + insertSuccess);
    }

    @Test
    public void testUser() {
        User user = new User();
        Gag gag = new Gag();
        gag.setGagTime(new Date());
        gag.setUser(user);
        int insertSuccess = gagDao.insertGag(gag);
        System.out.print("insert :" + insertSuccess);
    }


    @Test
    public void testRedisRank(){
    }
}
