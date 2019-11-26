import com.hp.xyl.svn.UserApplication;
import com.hp.xyl.svn.config.RedisService;
import com.hp.xyl.svn.model.UserModel;
import com.hp.xyl.svn.service.UserService;
import com.hp.xyl.svn.utils.RedisKeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;


/**
 * Author:xyl
 * Date:2019/2/2 14:54
 * Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {UserApplication.class})// 指定启动类
@Slf4j
public class TestApp {
    @Resource
    private UserService userService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Resource
    private ValueOperations<String, Object> valueOperations;

    @Autowired
    private HashOperations<String, String, Object> hashOperations;

    @Autowired
    private ListOperations<String, Object> listOperations;

    @Autowired
    private SetOperations<String, Object> setOperations;

    @Autowired
    private ZSetOperations<String, Object> zSetOperations;

    @Resource
    private RedisService redisService;

    @Test
    public void testObj() throws Exception {
        UserModel userVo = new UserModel();
        userVo.setAccount("18382244540");
        userVo.setUsername("谢英亮");
        userVo.setSex(1);
        ValueOperations operations = redisTemplate.opsForValue();
        redisService.expireKey("username", 20, TimeUnit.SECONDS);
        String key = RedisKeyUtil.getKey(UserModel.TABLE, "username", userVo.getUsername());
        UserModel vo = (UserModel) operations.get(key);
        System.out.println(vo);
    }
/*
    @Test
    public void testValueOption() throws Exception {
        UserModel userVo = new UserModel();
        userVo.setAddress("上海");
        userVo.setName("jantent");
        userVo.setAge(23);
        valueOperations.set("test", userVo);

        System.out.println(valueOperations.get("test"));
    }

    @Test
    public void testSetOperation() throws Exception {
        UserModel userVo = new UserModel();
        userVo.setAddress("北京");
        userVo.setName("jantent");
        userVo.setAge(23);
        UserModel auserVo = new UserModel();
        auserVo.setAddress("n柜昂周");
        auserVo.setName("antent");
        auserVo.setAge(23);
        setOperations.add("user:test", userVo, auserVo);
        Set<Object> result = setOperations.members("user:test");
        System.out.println(result);
    }

    @Test
    public void HashOperations() throws Exception {
        UserModel userVo = new UserModel();
        userVo.setAddress("北京");
        userVo.setName("jantent");
        userVo.setAge(23);
        hashOperations.put("hash:user", userVo.hashCode() + "", userVo);
        System.out.println(hashOperations.get("hash:user", userVo.hashCode() + ""));
    }

    @Test
    public void ListOperations() throws Exception {
        UserModel userVo = new UserModel();
        userVo.setAddress("北京");
        userVo.setName("jantent");
        userVo.setAge(23);
//        listOperations.leftPush("list:user",userVo);
//        System.out.println(listOperations.leftPop("list:user"));
        // pop之后 值会消失
        System.out.println(listOperations.leftPop("list:user"));
    }*/
}
