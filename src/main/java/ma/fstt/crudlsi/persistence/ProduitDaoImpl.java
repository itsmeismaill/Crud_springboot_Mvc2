package ma.fstt.crudlsi.persistence;

import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

@ManagedBean
@RequestScoped
public class ProduitDaoImpl implements  ProduitDao{

    EntityManagerFactory emf ;

    EntityManager em ;

    public ProduitDaoImpl(){

        emf = Persistence.createEntityManagerFactory("default");

        em = emf.createEntityManager();
    }


    @Override
    public void save(Produit produit) {

        em.getTransaction().begin();

        em.merge(produit);
        em.getTransaction().commit();

    }

    @Override
    public void update(Produit produit) {

       save(produit);

    }

    @Override
    public void delete(Produit produit) {
       em.getTransaction().begin();
       em.remove(produit);
       em.getTransaction().commit();

    }

    @Override
    public Produit getOne(Long id) {

        Query query = em.createQuery( "select produit from Produit produit where produit.id_produit =:id");
        query.setParameter("id" , id);
        // exécu
        return (Produit) query.getSingleResult();
    }

    @Override
    public List<Produit> getAll() {

        Query query = em.createQuery( "select produit from Produit produit ");

        // exécution et récupération de la liste résultat

        return query.getResultList() ;
    }
}
