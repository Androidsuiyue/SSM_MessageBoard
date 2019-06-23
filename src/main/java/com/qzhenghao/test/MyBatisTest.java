package com.qzhenghao.test;

import com.qzhenghao.dao.UserDao;
import com.qzhenghao.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;


/**
 * Created by ${符柱成} on 2017/3/31.
 */
@RunWith(SpringJUnit4ClassRunner.class) // 使用Springtest测试框架
@ContextConfiguration("/spring/spring-*.xml") // 加载配置
public class MyBatisTest {
    private ShardedJedisPool shardedJedisPool;
    private ShardedJedis jedis;


    @Autowired
    private UserDao userDao;
    @Test
    public void testRedisData() {

        User insertSuccess = userDao.queryByUsernumber("18401210137");
        System.out.print("insert :" + insertSuccess);
    }

//    @Test
//    public void testUser() {
//        User user = new User();
//        Gag gag = new Gag();
//        gag.setGagTime(new Date());
//        gag.setUser(user);
//        int insertSuccess = gagDao.insertGag(gag);
//        System.out.print("insert :" + insertSuccess);
//    }


    @Test
    public void testRedisRank(){
    }
}
