package Zadaniyezach;

import Foods;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class FoodService {
    static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:8080/ZadaniyeZach", "alex", "123123");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Foods foods) throws SQLException {
        int id = foods.getId();
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE foods SET values(?,?,?,?) where id =?");
        preparedStatement.setString(1, String.valueOf(foods.getId()));
        preparedStatement.setString(2, String.valueOf(foods.getCategory()));
        preparedStatement.setString(3, String.valueOf(foods.getTitle()));
        preparedStatement.setString(4, String.valueOf(foods.getPrice()));
        preparedStatement.setString(5, String.valueOf(id));
        preparedStatement.executeUpdate();
    }

    public String getAll() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("select * from foods");
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<Foods> foods = new ArrayList<>();
        while (resultSet.next()) {
            Foods food = new Foods();
            food.setId(resultSet.getInt(1));
            food.setPrice(resultSet.getString(2));
            food.setTitle(resultSet.getString(3));
            food.setCategory(resultSet.getString(4));
            foods.add(food);
        }
        return (Arrays.toString(foods.toArray()));
    }


    public void dele(int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("delete from foods where id =?");
        preparedStatement.setString(1, String.valueOf(id));
        preparedStatement.executeUpdate();
    }
}



