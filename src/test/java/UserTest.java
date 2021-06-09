import com.example.TomcatExample.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    public void authTest(){
        User user = new User("user", "123");
        Assertions.assertTrue(user.isAuthenticated());
    }
}
