package UserServiceTest;

import com.example.coursedatabase.app.Service.UserService;
import com.example.coursedatabase.domain.model.Time;
import com.example.coursedatabase.domain.model.User;
import com.example.coursedatabase.infra.Repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void createUser_ReturnsUser() {

        User user = new User(
                1L,
                "Matheus",
                "email",
                "12345",
                "12345",
                    new Time(
                        1L,
                        "santos",
                        "time"));

        when(userRepository.save(any())).thenReturn(user);
        User users = userService.create(user);
        assertEquals("create success",  user, users);
    }

    @Test
    public void createUser_ThrowsException() {

        User user = new User(
                1L,
                "Matheus",
                "email",
                "12345",
                "12345",
                new Time(
                        1L,
                        "santos",
                        "time"));

        when(userRepository.save(any())).thenReturn(user);
        User users = userService.create(user);
        assertThrows(Exception.class, () -> userService.create(user));
    }
}
