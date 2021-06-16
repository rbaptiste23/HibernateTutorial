import javax.persistence.*;


// Owner

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToOne(cascade = {CascadeType.PERSIST})
    // Unique = true (ensures the one-to-one relationship has unique values)
    @JoinColumn(name="passport_id", unique = true)
    @MapsId
    Passport passport;

    // This annotation allows you to use the id of the Passport class as
    // the foreign key id of the Customer class.. We cannot use auto key generation for the
    //  customer class


    public Customer() {}


    public Customer(String name, Passport passport) {
        this.name = name;
        this.passport = passport;
    }
}
