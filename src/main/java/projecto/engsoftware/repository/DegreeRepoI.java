package projecto.engsoftware.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import projecto.engsoftware.models.Degree;

@Repository
public interface DegreeRepoI extends CrudRepository<Degree,Long> {
    Degree findByName(String name);
}
