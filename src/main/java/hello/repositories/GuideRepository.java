package hello.repositories;

import hello.model.Guide;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GuideRepository extends CrudRepository<Guide, Long> {

    List<Guide> findByLastName(String lastName);
}
