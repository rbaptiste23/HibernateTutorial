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
            et.begin();


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

