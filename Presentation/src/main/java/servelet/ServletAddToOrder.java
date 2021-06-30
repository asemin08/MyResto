package servelet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "ServletAddToOrder", value = "/addToOrder")
public class ServletAddToOrder extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession userSession = request.getSession();
        try {
            operations(request, response,userSession);
        } catch (ServletException | IOException e) {
            userSession.setAttribute("error", e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession userSession = request.getSession();
        try {
            operations(request, response,userSession);
        } catch (ServletException | IOException e) {
            userSession.setAttribute("error", e.getMessage());
        }
    }

    protected void operations(HttpServletRequest request, HttpServletResponse response,HttpSession userSession) throws ServletException, IOException {

        HashMap<Integer,Integer> productMap = new HashMap<>();
        int productId = Integer.parseInt(request.getParameter("productId"));

        if (userSession.getAttribute("order") == null) {
            productMap.put(productId,1);
        } else {
            productMap = (HashMap<Integer, Integer>) userSession.getAttribute("order");
            productMap.merge(productId, 1, Integer::sum);
        }
        userSession.setAttribute("order", productMap);
        System.out.println(userSession.getAttribute("order").toString());
        response.sendRedirect(request.getContextPath()+"/menu");

    }


}
