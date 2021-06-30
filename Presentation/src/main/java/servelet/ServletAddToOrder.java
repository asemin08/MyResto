package servelet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletAddToOrder", value = "/addToOrder")
public class ServletAddToOrder extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        operations(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        operations(request, response);
    }

    protected void operations(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession userSession = request.getSession();
        List<Integer> productList = new ArrayList<>();
        if (userSession.getAttribute("order") == null) {
            productList.add(Integer.parseInt(request.getParameter("productId")));
        } else {
            productList = (List<Integer>) userSession.getAttribute("order");
            productList.add(Integer.parseInt(request.getParameter("productId")));
        }
        userSession.setAttribute("order", productList);
        System.out.println(userSession.getAttribute("order").toString());
        response.sendRedirect(request.getContextPath()+"/menu");
        //this.getServletContext().getRequestDispatcher("/menu.jsp").forward(request, response);

    }


}
