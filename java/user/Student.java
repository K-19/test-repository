package user;

import java.time.LocalDate;
import java.util.*;

public class Student {
    private long id;
    private String name;
    private int course;
    private int numberGroup;

    private static Map<Long, Student> allStudents = new HashMap<>();

    public Student(String name, int numberGroup) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
            this.numberGroup = numberGroup;
            this.id = (getCodeFacultyAndSpeciality() * 10000L) + numberOfStudentInSpeciality(getNumberOfSpeciality()) + 1;
            int digitOfYearAdmission = numberGroup / 100000;
            int digitOfCurrentYear = LocalDate.now().getYear() % 10;
            if (digitOfCurrentYear < digitOfYearAdmission)
                digitOfCurrentYear += 10;
            this.course = digitOfCurrentYear - digitOfYearAdmission;
            if (!hasStudent())
                allStudents.put(this.id, this);
        }
    }

    public static void clearList() {
        allStudents = new HashMap<>();
    }

    private boolean hasStudent() {
        return allStudents.containsValue(this);
    }

    public static List<Student> getAllStudents() {
        return new ArrayList<>(allStudents.values());
    }

    private int numberOfStudentInSpeciality(int codeSpeciality) {
        int count = 0;
        for (Student student : allStudents.values()) {
            if (student.getNumberOfSpeciality() == codeSpeciality)
                count++;
        }
        return count;
    }

    public int getNumberOfSpeciality() {
        return (numberGroup % 10000) / 100;
    }

    public int getCodeOfFaculty() {
        return (numberGroup % 100000) / 10000;
    }

    private int getCodeFacultyAndSpeciality() {
        return numberGroup / 100;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCourse() {
        return course;
    }

    public int getNumberGroup() {
        return numberGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return id == student.id && course == student.course && numberGroup == student.numberGroup && name.equals(student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, numberGroup);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", course=" + course +
                ", numberGroup=" + numberGroup +
                '}';
    }
}
