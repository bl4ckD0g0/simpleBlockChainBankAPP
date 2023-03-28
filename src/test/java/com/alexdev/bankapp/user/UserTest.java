package com.alexdev.bankapp.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.alexdev.bankapp.user.application.UserController;
import com.alexdev.bankapp.user.domain.User;
import com.alexdev.bankapp.user.domain.UserService;
import com.alexdev.bankapp.user.domain.UserServiceImpl.UserNotFoundException;

@SpringBootTest
public class UserTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Test
    public void testGetAllUsers() {
        User user1 = new User();
        user1.setFullName("John Doe");
        User user2 = new User();
        user2.setFullName("Jane Doe");
        List<User> userList = Arrays.asList(user1, user2);

        when(userService.getUsers()).thenReturn(userList);

        List<User> result = userController.getAllUsers();

        verify(userService, times(1)).getUsers();
        assertThat(result).isEqualTo(userList);
    }

    @Test
    public void testGetUser() throws UserNotFoundException {
        User user = new User();
        user.setId(1L);
        user.setFullName("John Doe");

        when(userService.getUser(1L)).thenReturn(user);
        
        User result = userController.getUser(1L);

        verify(userService, times(1)).getUser(1L);
        assertThat(result).isEqualTo(user);
    }

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setFullName("John Doe");

        userController.createUser(user);

        verify(userService, times(1)).createUser(user);
    }
}