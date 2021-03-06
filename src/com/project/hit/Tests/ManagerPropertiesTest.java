package com.project.hit.Tests;

import com.project.hit.fileManager.EnumNameNotFoundException;
import com.project.hit.model.managerSystem.ManagerProperties;
import com.project.hit.model.managerSystem.NoUserExistsException;
import com.project.hit.model.managerSystem.UserExistException;
import com.project.hit.model.managerSystem.details.User;
import org.junit.jupiter.api.*;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Manager Properties Test class")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ManagerPropertiesTest {

    private ManagerProperties managerProperties;
    private User user;


    @BeforeEach
    void setUp() {
        user = new User("1","1","1","1","1");
        managerProperties = assertDoesNotThrow(ManagerProperties::getManagerProperties);
        ManagerProperties managerProperties1 = null;
        try {
            managerProperties1 = ManagerProperties.getManagerProperties();
        } catch (EnumNameNotFoundException | IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Order(1)
    @DisplayName("create New User")
    void createNewUse() {
        assertDoesNotThrow(() -> managerProperties.createNewUse(user));
        assertThrows(UserExistException.class,() -> managerProperties.createNewUse(user));

    }

    @Test
    @Order(2)
    @DisplayName("find user")
    void findUser() {
            assertSame(user.getClass(),assertDoesNotThrow(() ->managerProperties.findUser("1")).getClass());
            assertThrows(NoUserExistsException.class,() -> managerProperties.findUser("2"));
    }

    @Test
    @Order(3)
    @DisplayName("updater")
    void updater() {
            assertSame(user.getClass(),assertDoesNotThrow(() ->managerProperties.updater("1").editUserName("2").update()).getClass());
            assertThrows(NoUserExistsException.class,() -> managerProperties.updater("2").editUserName("3").update());
    }

    @Test
    @Order(4)
    @DisplayName("delete user")
    void deleteUser() {
        assertDoesNotThrow(() -> managerProperties.deleteUser(managerProperties.findUser("1")));
        assertThrows(NoUserExistsException.class,() -> managerProperties.deleteUser(managerProperties.findUser("1")));
    }

}