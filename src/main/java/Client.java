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

            Movie movie1 = new Movie("Amercian Hustle");
            Movie movie2 = new Movie("The Prestige");

            Actor actor1 = new Actor("Christan Bale");
            Actor actor2 = new Actor("Hugh Jackman");

            movie1.getActors().add(actor1);

            movie2.getActors().add(actor1);
            movie2.getActors().add(actor2);

            em.persist(movie1);
            em.persist(movie2);


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
