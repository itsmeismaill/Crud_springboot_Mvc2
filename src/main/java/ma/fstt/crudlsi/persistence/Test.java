package ma.fstt.crudlsi.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Test {



    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Produit p = em.merge(new Produit(0l,"test" , 1.5, null));
        em.getTransaction().commit();


        em.getTransaction().begin();

        em.merge(new Book(0l,"book" ,  null));
        em.getTransaction().commit();

    }
}
