package app.travel.redisson.payload;


import java.time.OffsetDateTime;
import java.util.List;

public class Student {

    private String name;

    private int age;

    private String location;

    private OffsetDateTime birthDay;

    private List<Integer> marks;

    public Student() {
    }

    public Student(String name, int age, String location, OffsetDateTime birthDay, List<Integer> marks) {
        this.name = name;
        this.age = age;
        this.location = location;
        this.birthDay = birthDay;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public OffsetDateTime getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(OffsetDateTime birthDay) {
        this.birthDay = birthDay;
    }

    public List<Integer> getMarks() {
        return marks;
    }

    public void setMarks(List<Integer> marks) {
        this.marks = marks;
    }
}
