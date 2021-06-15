

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


// Inverse End
// Inverse End does not care about the relationship...

@Entity
public class Guide {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="staff_id", nullable = false)
    private String staffId;
    private String name;
    private Integer salary;

    // if a Guide is updated the Student will not be updated because Guide is not
    // the owner of the relationship.
    // guide represents the guide field in the Student class (private Guide guide)..
    // That guide field is mapped to the foreign key field in Student.
    @OneToMany(mappedBy = "guide", cascade = {CascadeType.PERSIST}, orphanRemoval = true)
    private Set<Student> students =new HashSet<>();



    public Guide() {}



    public Guide(String staffId, String name, Integer salary) {
        this.staffId = staffId;
        this.name = name;
        this.salary = salary;
    }

    public Set<Student> getStudents() { return students; }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    // When we add a new student the Guide will be associated w/ the Student.
    public void addStudent(Student student) {
        students.add(student);
        student.setGuide(this);
    }
}
