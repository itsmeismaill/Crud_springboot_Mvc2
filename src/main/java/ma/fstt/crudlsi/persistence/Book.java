package ma.fstt.crudlsi.persistence;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "book")

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Book {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_book;

    private String nom ;

    @ManyToOne
    @JoinColumn (name="id_produit")
    private Produit produit ;

}
