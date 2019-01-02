package pub.liyf.bean;

import java.io.Serializable;
import java.util.Objects;

public class Student extends Person implements Serializable {


    private static final long serialVersionUID = -3242114294614394598L;
    private Double score;

    public Student() {

    }

    public Student(String id, String name, Integer age, Double score) {
        super(id, name, age);
        this.score = score;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", score=" + getScore() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Objects.equals(student.getId(), this.getId());
    }

}
