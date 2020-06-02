import Foods;
import FoodService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet("/update")
public class Servlet extends HttpServlet {

    FoodService foodService = new FoodService();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String method = request.getParameter("method");

        int id = Integer.parseInt(request.getParameter("id"));

        if (method.equals("delete")) {
            foodService.dele(id);
        }
        if (method.equals("get")) {
            foodService.getAll();
        }
        if (method.equals("update")){
            Foods foods = new Foods();
            foods.setId(1);
            foods.setCategory("Korm");
            foods.setPrice("500");
            foods.setPrice("250");
            foodService.update(foods);
        }
    }

        @Override
        protected void doGet (HttpServletRequest request, HttpServletResponse response) throws
        SecurityException, IOException {
            try {
                processRequest(request, response);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        @Override
        protected void doPost (HttpServletRequest request, HttpServletResponse response) throws
        SecurityException, IOException {
            try {
                processRequest(request, response);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }