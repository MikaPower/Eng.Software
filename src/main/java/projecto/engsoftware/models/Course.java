package projecto.engsoftware.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Course extends BaseModel{

    private String name;

    @EqualsAndHashCode.Exclude
    @JsonIgnore
    @ManyToOne
    @ToString.Exclude
    private Degree degree;

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Student> students=new HashSet<>();

    private int ects;
    private int semester;
    private int year;

    public Course(String name) {
        this.name = name;
    }

    public Course(String name, int ects) {
        this(name);
        this.ects = ects;
    }

    public Course(String name, int ects, int year) {
        this(name,ects);
        this.year= year;
    }

    public Course(String name, int ects, int year,int semester) {
        this(name,ects,year);
        this.semester = semester;
    }

    @JsonInclude
    public String getDegreeName(){
        return degree!=null?degree.getName():"";
    }

    public void addStudent(Student student){
        this.students.add(student);
        student.addCourse(this);
    }
}

