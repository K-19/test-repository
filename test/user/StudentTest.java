package user;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class StudentTest {
    private Student stud1;
    private Student stud2;
    private Student stud3;
    private Student stud4;
    private Student stud5;
    private Student stud6;
    private Student stud7;

    @Before
    public void setup() {
        stud1 = new Student("Сергей", 872303);
        stud2 = new Student("Вадим", 872303);
        stud3 = new Student("Дмитрий", 872302);
        stud4 = new Student("", -1);
        stud5 = new Student(null, 12345);
        stud6 = new Student(null, 123454);
        stud7 = new Student(null, 87230043);
    }

    @After
    public void end() {
        Student.clearList();
    }

    @Test
    public void getAllStudents() {
        List<Student> expected = Student.getAllStudents();
        List<Student> actual = List.of(stud1, stud2, stud3);
        Assert.assertEquals(expected.size(), 3);
        Assert.assertTrue(expected.contains(actual.get(0)));
        Assert.assertTrue(expected.contains(actual.get(1)));
        Assert.assertTrue(expected.contains(actual.get(2)));
    }

    @Test
    public void newStudentEmptyName() {
        for (Student student : Student.getAllStudents()) {
            if (student.getName().isEmpty())
                Assert.fail("Попытка добавить студента с пустым именем");
        }
    }

    @Test
    public void newStudentNullName() {
        for (Student student : Student.getAllStudents()) {
            if (student.getName() == null)
                Assert.fail("Попытка добавить студента с null именем");
        }
    }

    @Test
    public void newStudentWrongGroupNumber() {
        for (Student student : Student.getAllStudents()) {
            if (student.getNumberGroup() < 100000)
                Assert.fail("Попытка ввода номера группы меньше 100000");
            if (student.getNumberGroup() > 1000000)
                Assert.fail("Попытка ввода номера группы больше 999999");
        }
    }

    @Test
    public void getNumberOfSpeciality() {
        int expected = stud1.getNumberOfSpeciality();
        int actual = 23;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getCodeOfFaculty() {
        int expected = stud1.getCodeOfFaculty();
        int actual = 7;
        Assert.assertEquals(expected, actual);
    }
}