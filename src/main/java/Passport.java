import javax.persistence.*;

// Inverse Side
@Entity
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="passport_number")
    private String passportNumber;

    // mappedBy makes this class the inverse side of a one-to-one relationship.
//    @OneToOne(mappedBy = "passport")
//    private Customer customer;

    public Passport(String passportNumber) {
        this.passportNumber = passportNumber;
    }

//    public Customer getCustomer() {
//        return customer;
//    }
}
