package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.UserRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    UserService userService;

    //@BeforeEach
    //@BeforeAll
    //@AfterEach
    //@AfterAll

    @Test
    public void testAdd(){
        assertEquals(4,2+2);
    }

    @Test
    public void testTrue(){
        assertTrue(5>3);
    }

    @ParameterizedTest
//    @ValueSource(strings = {
//            "Eion",
//            "Nitin",
//            "Suresh",
//            "Xaviour"
//    })
    @ArgumentsSource(UserArgumentsProvider.class)
    public void testSaveNewUser(User user){
        //assertNotNull(userRepository.findByUsername(name), "failed for : "+ name);
        assertTrue(userService.saveNewUser(user));
    }

    @Disabled
    @ParameterizedTest
    @CsvSource({
            "1,1,2",
            "2,10,12",
            "2,3,9"
    })
    public void testCSV(int a, int b, int expected){
        assertEquals(expected,a+b);
    }
}
