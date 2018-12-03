package projecto.engsoftware.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import projecto.engsoftware.models.Course;
import projecto.engsoftware.models.Degree;
import projecto.engsoftware.repository.DegreeRepoI;
import projecto.engsoftware.repository.CourseRepo;

@Controller
@RequestMapping("/course")
public class CourseController {

    private CourseRepo courseRepo;

    private DegreeRepoI degreeRepoI;

    @Autowired
    public CourseController(CourseRepo courseRepository, DegreeRepoI degreeRepoI){

        this.courseRepo=courseRepository;
        this.degreeRepoI=degreeRepoI;
    }
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.GET)
    public @ResponseBody Iterable<Course> getAllCourses(){
        return courseRepo.findAll();
    }


    @RequestMapping(value="/{nameDegree}",method=RequestMethod.POST,produces= MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Course createCourse(@RequestBody Course course, @PathVariable("nameDegree") String nameDegree){
        Degree degree= degreeRepoI.findByName(nameDegree);

        //verificar que o degree nao é null, caso o utilizador de dados errados
        degree.addCourse(course);
        degreeRepoI.save(degree);

        return course;
}




}
