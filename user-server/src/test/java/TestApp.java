import com.hp.xyl.svn.UserApplication;
import com.hp.xyl.svn.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


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
}
