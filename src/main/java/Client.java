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
            Guide guide1 = new Guide("2000MO10789","Mike Lawson", 1000);
            Guide guide2 = new Guide("2000M10901","Ian Lamb", 2000);


            Student student1 = new Student("2014JT50123","John Smith", guide1);
            Student student2 = new Student("2014AL50456","Amy Gill", guide1);

            et.begin();
            guide1.getStudents().add(student1);
            guide1.getStudents().add(student2);

            em.persist(guide1);
            em.persist(guide2);
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
