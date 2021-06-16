import javax.persistence.*;


@Entity
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="passport_number")
    private String passportNumber;

    @OneToOne(mappedBy = "passport")
    private Customer customer;

    public Passport(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public Customer getCustomer() {
        return customer;
    }
}
