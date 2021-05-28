package user;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UserTest {
    private User user1;
    private User user2;
    private User user3;
    private User notAdded1;
    private User notAdded2;

    @Before
    public void setup() {
        user1 = new User("Сергей",  19, Sex.MALE);
        user2 = new User("Анжелика",  17, Sex.FEMALE);
        user3 = new User("Коля",  17, Sex.MALE);
        notAdded1 = new User(null, 0, null);
        notAdded2 = new User("", 0, null);
    }

    @Test
    public void getAllUsers() {
        List<User> expected = User.getAllUsers();
        List<User> actual = List.of(user1, user2, user3);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAllUsers_NO_NULL() {
        List<User> expected = User.getAllUsers();
        Assert.assertNotNull(expected);
    }

    @Test
    public void getUsersBySex_MALE() {
        List<User> expected = User.getUsersBySex(Sex.MALE);
        List<User> actual = List.of(user1, user3);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getUsersBySex_FEMALE() {
        List<User> expected = User.getUsersBySex(Sex.FEMALE);
        List<User> actual = List.of(user2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getHowManyUsers() {
        int expected = User.getHowManyUsers();
        int actual = 3;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getHowManyUsersBySex_MALE() {
        int expected = User.getHowManyUsersBySex(Sex.MALE);
        int actual = 2;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getHowManyUsersBySex_FEMALE() {
        int expected = User.getHowManyUsersBySex(Sex.FEMALE);
        int actual = 1;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAllAgeUsers() {
        long expected = User.getAllAgeUsers();
        long actual = 19 + 17 + 17;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAgeUsersBySex_MALE() {
        long expected = User.getAgeUsersBySex(Sex.MALE);
        long actual = 19 + 17;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAgeUsersBySex_FEMALE() {
        long expected = User.getAgeUsersBySex(Sex.FEMALE);
        long actual = 17;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAverageAgeOfAllUsers() {
        long expected = User.getAverageAgeOfAllUsers();
        long actual = (19 + 17 + 17) / 3;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAverageAgeUsersBySex_MALE() {
        long expected = User.getAverageAgeUsersBySex(Sex.MALE);
        long actual = (19 + 17) / 2;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAverageAgeUsersBySex_FEMALE() {
        long expected = User.getAverageAgeUsersBySex(Sex.FEMALE);
        long actual = 17;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void newUser_EMPTY_NAME() {
        for (User user : User.getAllUsers())
            if (user.getName() != null && user.getName().isEmpty())
                Assert.fail("Попытка создания пользователя с пустым именем");
    }

    @Test
    public void newUser_NULL_NAME() {
        for (User user : User.getAllUsers())
            if (user.getName() == null)
                Assert.fail("Попытка создания пользователя с нулевым именем");
    }

    @Test
    public void newUser_AGE_ZERO() {
        for (User user : User.getAllUsers())
            if (user.getAge() <= 0)
                Assert.fail("Попытка создания пользователя с отрицательным возрастом");
    }

    @Test
    public void newUser_NULL_SEX() {
        for (User user : User.getAllUsers())
            if (user.getSex() == null)
                Assert.fail("Попытка создания пользователя с нулевым полом");
    }
}