package projecto.engsoftware.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import projecto.engsoftware.models.Course;

import java.util.spi.LocaleNameProvider;

@Repository
public interface CourseRepo extends CrudRepository<Course, Long> {
    Course findByName(String name);
}
