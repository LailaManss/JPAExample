package hello.repositories;

import java.util.List;

import hello.model.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long> {

    List<Client> findByLastName(String lastName);
}