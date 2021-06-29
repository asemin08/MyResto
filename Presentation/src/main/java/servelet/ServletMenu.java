package servelet;

import eu.ensup.myresto.CategoryService;
import eu.ensup.myresto.ProductDto;
import eu.ensup.myresto.ProductService;
import eu.ensup.myresto.exceptions.ServiceException;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

@WebServlet(name = "ServletMenu", value = "/menu")
public class ServletMenu extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ProductService productService = new ProductService();
        HttpSession userSession = request.getSession();
        try {
            Set<ProductDto> listBoisson = new HashSet<>();
            Set<ProductDto> listEntree = new HashSet<>();
            Set<ProductDto> listPlat = new HashSet<>();
            Set<ProductDto> listDessert = new HashSet<>();
            for (var produc:productService.getAllProducts()) {
                switch (new CategoryService().get(produc.getIdCategory()).getName()){
                    case("boisson"):
                        listBoisson.add(produc);
                        break;
                    case("entree"):
                        listEntree.add(produc);
                        break;
                    case("plat"):
                        listPlat.add(produc);
                        break;
                    case("dessert"):
                        listDessert.add(produc);
                        break;
                }
            }
            userSession.setAttribute("listBoisson",listBoisson);
            userSession.setAttribute("listEntree",listEntree);
            userSession.setAttribute("listDessert",listDessert);
            userSession.setAttribute("listPlat",listPlat);
            userSession.setAttribute("listProducts",productService.getAllProducts());

            this.getServletContext().getRequestDispatcher("/menu.jsp").forward(request,response);
        } catch (ServiceException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

