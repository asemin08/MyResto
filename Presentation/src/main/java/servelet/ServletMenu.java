package servelet;

import eu.ensup.myresto.CategoryService;
import eu.ensup.myresto.ProductDto;
import eu.ensup.myresto.ProductService;
import eu.ensup.myresto.exceptions.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@WebServlet(name = "ServletMenu", value = "/menu")
public class ServletMenu extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        operations(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        operations(request, response);
    }

    protected void operations(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ProductService productService = new ProductService();
        HttpSession userSession = request.getSession();
        try {
            List<ProductDto> listBoisson = new LinkedList<>();
            List<ProductDto> listEntree = new LinkedList<>();
            List<ProductDto> listPlat = new LinkedList<>();
            List<ProductDto> listDessert = new LinkedList<>();
            List<ProductDto> products = productService.getAllProducts().stream().collect(Collectors.toList());
            Collections.sort(products, Comparator.comparing(ProductDto::getName));
            for (var produc : products) {
                switch (new CategoryService().get(produc.getIdCategory()).getName()) {
                    case ("boisson"):
                        listBoisson.add(produc);
                        break;
                    case ("entree"):
                        listEntree.add(produc);
                        break;
                    case ("plat"):
                        listPlat.add(produc);
                        break;
                    case ("dessert"):
                        listDessert.add(produc);
                        break;
                }
            }
            userSession.setAttribute("listBoisson", listBoisson);
            userSession.setAttribute("listEntree", listEntree);
            userSession.setAttribute("listDessert", listDessert);
            userSession.setAttribute("listPlat", listPlat);
            userSession.setAttribute("listProducts", products);
            this.getServletContext().getRequestDispatcher("/menu.jsp").forward(request, response);
        } catch (ServiceException e) {
            userSession.setAttribute("error", e.getMessageViewForUser());
            this.getServletContext().getRequestDispatcher("/500.jsp").forward(request, response);
        }
    }
}

