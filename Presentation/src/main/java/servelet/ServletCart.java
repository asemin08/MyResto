package servelet;

import eu.ensup.myresto.ProductDto;
import eu.ensup.myresto.ProductService;
import eu.ensup.myresto.UserService;
import eu.ensup.myresto.exceptions.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;


@WebServlet(name = "ServletPanier", value = "/panier")
public class ServletCart extends HttpServlet {

    private static final Logger log = LogManager.getLogger(UserService.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  {
        HttpSession userSession = request.getSession();
        try {
            operations(request, response,userSession);
        } catch (ServletException | IOException e) {
            userSession.setAttribute("error", e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  {
        HttpSession userSession = request.getSession();
        try {
            operations(request, response,userSession);
        } catch (ServletException | IOException e) {
            userSession.setAttribute("error", e.getMessage());
        }
    }

    protected void operations(HttpServletRequest request, HttpServletResponse response,HttpSession userSession) throws ServletException, IOException {
        ProductService productService = new ProductService();
        Map<Integer, Integer> productsIds = (Map<Integer, Integer>) userSession.getAttribute("order");
        float total = 0.0f;
        Set<ProductDto> productDtos = new HashSet<>();
        for(Map.Entry<Integer,Integer> entry : productsIds.entrySet()){
            try {
                ProductDto productDto = productService.getOneProduct(entry.getKey());
                total += productDto.getPrice() * entry.getValue();
                productDtos.add(productDto);
            } catch (ServiceException e) {
                log.error(e.getMessage());
            }
        }
        request.setAttribute("totalPrice",total);
        userSession.setAttribute("productSet",productDtos);
        request.getRequestDispatcher("panier.jsp").forward(request, response);

    }

}
