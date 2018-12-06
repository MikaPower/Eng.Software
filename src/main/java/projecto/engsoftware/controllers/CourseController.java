package projecto.engsoftware.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import projecto.engsoftware.models.Course;
import projecto.engsoftware.models.Degree;
import projecto.engsoftware.repository.DegreeRepoI;
import projecto.engsoftware.repository.CourseRepo;
import projecto.engsoftware.services.CourseService;

import java.util.Optional;

@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    private CourseRepo courseRepo;

    private DegreeRepoI degreeRepoI;

    @Autowired
    public CourseController(CourseRepo courseRepository, DegreeRepoI degreeRepoI) {

        this.courseRepo = courseRepository;
        this.degreeRepoI = degreeRepoI;
    }

    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public Iterable<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

//adicionar um curso
    @RequestMapping(value = "/{nameDegree}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Course createCourse(@RequestBody Course course, @PathVariable("nameDegree") String nameDegree) {
        return courseService.addCourse(course, nameDegree);

    }

    @RequestMapping(value = "/{idCourse}", method = RequestMethod.GET)
    public ResponseEntity<Course> getCourse(@PathVariable("idCourse") Long idCourse){
        Optional<Course> courseOptional=courseService.getCourse(idCourse);
        if(courseOptional.isPresent()){
            return ResponseEntity.ok(courseOptional.get());
        }
        return ResponseEntity.notFound().build();
    }


    @RequestMapping(value = "/{nameDegree}", method = RequestMethod.DELETE)
    public
    Course deleteCourse(@RequestBody Course course, @PathVariable("nameDegree") String nameDegree){
        return courseService.deleteCourse(course,nameDegree);
    }


}
