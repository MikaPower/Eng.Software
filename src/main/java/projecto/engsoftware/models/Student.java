package projecto.engsoftware.models;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Student extends BaseModel {

    private String studentNumber;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToMany(mappedBy = "students")
    private Set<Course> courses =new HashSet<>();

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne
    private Degree degree;

    public Student(String studentNumber,Degree degree) {
        this.studentNumber = studentNumber;
        this.degree=degree;
    }

    public void addCourse(Course course){
        this.courses.add(course);
    }

}
