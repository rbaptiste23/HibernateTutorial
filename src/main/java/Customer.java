

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


// Inverse End
// Inverse End does not care about the relationship...

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;




    private String name;

    @OneToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name="passport_id", unique = true)
    Passport passport;

    public Customer() {}


    public Customer(String name, Passport passport) {
        this.name = name;
        this.passport = passport;
    }
}
