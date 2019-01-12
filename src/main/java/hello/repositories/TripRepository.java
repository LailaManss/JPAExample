package hello.repositories;

import hello.model.Guide;
import hello.model.Trip;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TripRepository extends CrudRepository<Trip, Long> {

    List<Trip> findByDestination(String destination);
}
