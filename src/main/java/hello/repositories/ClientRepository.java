package hello.repositories;

import java.beans.Transient;
import java.util.List;

import hello.model.Client;
import hello.model.Trip;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ClientRepository extends CrudRepository<Client, Long> {

    List<Client> findAll();


    List<Client> findByLastName(String lastName);



}