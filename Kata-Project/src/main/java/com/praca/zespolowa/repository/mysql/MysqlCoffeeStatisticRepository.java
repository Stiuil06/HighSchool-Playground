package com.praca.zespolowa.repository.mysql;

import com.praca.zespolowa.config.AppConfig;
import com.praca.zespolowa.config.DBConfig;
import com.praca.zespolowa.exception.CoffeeQueryException;
import com.praca.zespolowa.repository.CoffeeStatisticRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class MysqlCoffeeStatisticRepository implements CoffeeStatisticRepository, AutoCloseable {

    private Connection connection;

    public MysqlCoffeeStatisticRepository() {
        try {
            connection = DBConfig.getConnection();
            Statement statement = connection.createStatement();
            for (AppConfig.COFFEE value : AppConfig.COFFEE.values()) {
                String select = "SELECT * FROM `coffee_statistic` WHERE `coffee_name` = '" + value.toString() + "'";
                ResultSet resultSet = statement.executeQuery(select);
                if (!resultSet.next()) {
                    String insert = "INSERT INTO `coffee_statistic`(`coffee_name`, `amount`) VALUES ('" + value.toString() + "',0)";
                    statement.executeUpdate(insert);
                }//3====D cj
            }
        } catch (SQLException e) {
            throw new CoffeeQueryException(e);
        }
    }

    @Override
    public boolean incrementCoffe(String coffeeName) {

        try (Connection connection = DBConfig.getConnection()) {

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT amount FROM coffee_statistic WHERE coffee_name = '" + coffeeName + "'");
            if (resultSet.next()) {
                int amount = resultSet.getInt("amount");
                amount++;
                statement.executeUpdate("UPDATE coffee_statistic SET amount = " + amount + " WHERE coffee_name = '" + coffeeName + "'");
                return true;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return false;
    }

    @Override
    public Map<String, Integer> findAll() {
        try (Connection connection = DBConfig.getConnection()) {
            Statement statement = connection.createStatement();
            Map<String, Integer> map = new HashMap<>();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM coffee_statistic");
            while (resultSet.next()) {
                String coffee_name = resultSet.getString("coffee_name");
                int amount = resultSet.getInt("amount");
                map.put(coffee_name, amount);
            }
            return map;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Integer getCountOfAllCoffees() {
        int amount = 0;

        try (Connection connection = DBConfig.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT SUM(amount) FROM coffee_statistic;");
            while (resultSet.next()) {
                String coffee_name = resultSet.getString("coffee_name");
                amount = resultSet.getInt("amount");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return amount;
    }

    @Override
    public boolean resetAllStatistics() {
        try (Connection connection = DBConfig.getConnection()) {

            Statement statement = connection.createStatement();

            statement.executeUpdate("UPDATE coffee_statistic SET amount = " + 0);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean resetStatisticFor(String coffeeName) {
        Statement statement = getStatement();
        executeUpdate(statement, "UPDATE coffee_statistic SET amount = 0 WHERE coffee_name = '" + coffeeName + "'");
        return true;
    }

    private void executeUpdate(Statement statement, String command) {
        try {
            statement.executeUpdate(command);
        } catch (SQLException e) {
            throw new CoffeeQueryException(command, e);
        }
    }

    private Statement getStatement() {
        try {
            return connection.createStatement();
        } catch (SQLException e) {
            throw new CoffeeQueryException("Error when creating statement", e);
        }
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new CoffeeQueryException(e);
        }
    }
}