package hello.model;

import javax.persistence.*;

@Entity(name="Guide")
@Table(name="guide")
public class Guide {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long Id;
    private String firstName;
    private String lastName;



    public Guide() {
    }

    public Guide(String firstName, String lastName) {
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

    @Override
    public String toString() {
        return String.format(
                "Guide[Id=%d, firstName='%s', lastName='%s']",
                Id, firstName, lastName);
    }

}