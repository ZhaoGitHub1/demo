import com.yizhu.DemoEventApplication;
import com.yizhu.dto.UserDTO;
import com.yizhu.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoEventApplication.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void createUser(){
        UserDTO user = userService.createUser();
        Assert.assertNotNull(user);
    }
}
