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
    Passport passport;

    public Customer() {}


    public Customer(String name, Passport passport) {
        this.name = name;
        this.passport = passport;
    }
}
