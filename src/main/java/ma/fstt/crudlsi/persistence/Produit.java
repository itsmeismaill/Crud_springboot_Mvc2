package ma.fstt.crudlsi.persistence;


import jakarta.persistence.*;
import lombok.*;
import org.eclipse.persistence.jpa.jpql.tools.model.query.LikeExpressionStateObject;

import java.util.List;

@Entity
@Table(name = "produit")

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_produit;

    private String nom ;

    private Double prixU ;

    @OneToMany
    @JoinColumn(name="id_produit")
    private List<Book> listb;




}
