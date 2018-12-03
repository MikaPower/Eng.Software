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
public class Degree extends BaseModel{

    private String name;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,mappedBy = "degree")
    private Set<Course> courses=new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,mappedBy = "degree")
    private Set<Student> students=new HashSet<>();

    public Degree(String name) {
        this.name = name;
    }

    public void addCourse(Course course){
        courses.add(course);
        course.setDegree(this);
    }
}
