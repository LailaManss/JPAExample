package hello.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name="Client")
@Table(name="client")
public class Client {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long Id;
    private String firstName;
    private String lastName;

    @ManyToMany(cascade = {
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH,
            CascadeType.DETACH,
    }

            ,mappedBy = "clients")
    Set<Trip> trips = new HashSet<>();

    public Client() {
    }

    public Client(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Trip> getTrip() {
        return trips;
    }

    public void addTrip(Trip trip) {
        this.trips.add(trip);
    }



    @Override
    public String toString() {
        return String.format(
                "Customer[Id=%d, firstName='%s', lastName='%s']",
                Id, firstName, lastName);
    }

}