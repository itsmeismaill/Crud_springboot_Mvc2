package ma.fstt.crudlsi;
import java.io.*;
import java.util.List;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import ma.fstt.crudlsi.persistence.Produit;
import ma.fstt.crudlsi.persistence.ProduitDao;

// MVC 2 controller
@WebServlet(name = "HelloServlet", value = "/actionsServlet")
public class HelloServlet extends HttpServlet {
    private String message;

    @Inject
    private ProduitDao produitDao ;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException , ServletException {


        String action = request.getParameter("action");
// actions
        switch (action){

            case "add" :
                    request.getRequestDispatcher("addProduit.jsp").forward(request , response);
                break ;


            case "save":
                    String nom = request.getParameter("nom");

                    Double pu =  Double.parseDouble(request.getParameter("pu")) ;
                    // ID
                    produitDao.save(new Produit(0l, nom , pu , null));

                request.getRequestDispatcher("actionsServlet?action=list").forward(request , response);
                    break ;

            case "list" :
                List<Produit> mylist =  produitDao.getAll();

                request.setAttribute("mylist" , mylist);

                request.getRequestDispatcher("lisProduit.jsp").forward(request , response);

                break ;

                case "update" :
                    Produit produit = new Produit(Long.parseLong(request.getParameter("id")) , request.getParameter("nom") , Double.parseDouble(request.getParameter("pu")) , null);
                    produitDao.update(produit);
                    request.setAttribute("mylist" , produitDao.getAll());
                    request.getRequestDispatcher("lisProduit.jsp").forward(request , response);
                    break ;

            case "edit":
                // Récupérer l'ID du produit à éditer
                Long editProductId = Long.parseLong(request.getParameter("id"));

                // Récupérer le produit à éditer
                Produit editProduct = produitDao.getOne(editProductId);

                // Mettre le produit dans la requête pour l'affichage dans le formulaire d'édition
                request.setAttribute("produit", editProduct);

                // Rediriger vers la page JSP d'édition
                request.getRequestDispatcher("editProduit.jsp").forward(request, response);
                break;

            case "delete":
                produitDao.delete(produitDao.getOne(Long.parseLong(request.getParameter("id"))));

                request.setAttribute("mylist" , produitDao.getAll());
                request.getRequestDispatcher("lisProduit.jsp").forward(request , response);
                break ;

            default:

        }



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    public void destroy() {
    }
}