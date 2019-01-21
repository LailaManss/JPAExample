package hello.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name="Trip")
@Table(name="trip")
public class Trip {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Guide guide;



    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "trip_client",
            joinColumns = @JoinColumn(name = "trip_id"),
            inverseJoinColumns = @JoinColumn(name = "client_id")
    )
    private Set<Client> clients = new HashSet<>();


    private String destination;



    public Trip() {
    }


    public Trip(Guide guide, String destination) {
        this.guide = guide;
        this.destination = destination;
    }

    public Guide getGuide() {
        return guide;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public void setGuide(Guide guide) {
        this.guide = guide;
    }



    public Set<Client> getClients() {
        return clients;
    }

    public void addClient(Client client) {

        this.clients.add(client);
        client.addTrip(this);
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
