package ma.fstt.crudlsi.persistence;

import java.util.List;

public interface ProduitDao {


    public void save(Produit produit);
    public void update(Produit produit);
    public void delete(Produit produit);
    public Produit getOne(Long id);
    public List<Produit> getAll();
}
