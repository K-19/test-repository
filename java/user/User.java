package user;

import java.util.*;

public class User {
    private int id;
    private String name;
    private int age;
    private Sex sex;

    private static int countId = 0;
    private static Map<Integer, User> allUsers = new HashMap<>();

    public User(String name, int age, Sex sex) {
        if (name != null && !name.isEmpty() && age > 0 && sex != null) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            if (!hasUser()) {
                this.id = ++countId;
                allUsers.put(this.id, this);
            }
        }
    }

    private boolean hasUser() {
        for (User user : allUsers.values()) {
            if (user.equals(this) && user.hashCode() == this.hashCode())
                return true;
        }
        return false;
    }

    public static List<User> getAllUsers() {
        return new ArrayList<>(allUsers.values());
    }

    public static List<User> getUsersBySex(Sex sex) {
        List<User> result = new ArrayList<>();
        for (User user : allUsers.values()) {
            if (user.sex == sex)
                result.add(user);
        }
        return result;
    }

    public static int getHowManyUsers() {
        return getAllUsers().size();
    }

    public static int getHowManyUsersBySex(Sex sex) {
        return getUsersBySex(sex).size();
    }

    public static long getAllAgeUsers() {
        long countAge = 0;
        for (User user : allUsers.values())
            countAge += user.age;
        return countAge;
    }

    public static long getAgeUsersBySex(Sex sex) {
        int countAge = 0;
        for (User user : getUsersBySex(sex))
            countAge += user.age;
        return countAge;
    }

    public static long getAverageAgeOfAllUsers() {
        return getAllAgeUsers() / getHowManyUsers();
    }

    public static long getAverageAgeUsersBySex(Sex sex) {
        return getAgeUsersBySex(sex) / getHowManyUsersBySex(sex);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return age == user.age && name.equals(user.name) && sex == user.sex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, sex);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
