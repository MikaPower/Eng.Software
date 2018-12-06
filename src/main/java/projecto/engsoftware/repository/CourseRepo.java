package projecto.engsoftware.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import projecto.engsoftware.models.Course;

import java.util.Optional;

@Repository
public interface CourseRepo extends CrudRepository<Course, Long> {
    Optional<Course> findByName(String name);
}
