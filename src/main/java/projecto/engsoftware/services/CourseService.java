package projecto.engsoftware.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import projecto.engsoftware.models.Course;
import projecto.engsoftware.models.Degree;
import projecto.engsoftware.repository.CourseRepo;
import projecto.engsoftware.repository.DegreeRepoI;

import java.util.Optional;

@Service
public class CourseService {

    @Autowired
   private CourseRepo courseRepo;
    @Autowired
    private DegreeRepoI degreeRepoI;

    public Iterable<Course> getAllCourses(){

        return courseRepo.findAll();
    }

    public Course addCourse(Course course,String nameDegree){

        Degree degree= degreeRepoI.findByName(nameDegree);

        //verificar que o degree nao é null, caso o utilizador de dados errados
        degree.addCourse(course);
        degreeRepoI.save(degree);

        return course;

    }

    public Optional<Course> getCourse(Long idCourse){
       return courseRepo.findById(idCourse);
    }




    public Course deleteCourse(Course course, String nameDegree){
        Degree degree= degreeRepoI.findByName(nameDegree);
        //verificar que o degree nao é null, caso o utilizador de dados errados
        courseRepo.delete(course);
        degree.deleteCourse(course);
        return course;
    }



}
