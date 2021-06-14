import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Client {

    public static void main(String[] args) {

        EntityManagerFactory emf =  Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        EntityManager em =  emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        try {
//            Guide guide = new Guide("staff5555","Debra Marlow", 1048);
//            Student student1 = new Student("en777","Tommy John", guide);
//            Student student2 = new Student("en888","Rasheda Jenkins", guide);

//            et.begin();
//            //em.persist(guide);
//            em.persist(student1);
//            em.persist(student2);
//            et.commit();

            et.begin();
            Student student = (Student) em.getReference(Student.class,21l);
            //How to get around the foreign key constraint issue. Set the foreign key value to null prior to deleting the record.
            student.setGuide(null);
            em.remove(student);
            et.commit();

        } catch (Exception e) {
            et.rollback();
            System.out.println(e);

        } finally {
            em.close();
            emf.close();
        }

    }
}
