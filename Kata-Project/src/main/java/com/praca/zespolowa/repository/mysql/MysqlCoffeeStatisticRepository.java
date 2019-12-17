package com.praca.zespolowa.repository.mysql;

import com.praca.zespolowa.config.Config;
import com.praca.zespolowa.config.DBManager;
import com.praca.zespolowa.exception.MethodNotImplementedException;
import com.praca.zespolowa.exception.ResetAllStatisticsException;
import com.praca.zespolowa.repository.CoffeeStatisticRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class MysqlCoffeeStatisticRepository implements CoffeeStatisticRepository {
    public MysqlCoffeeStatisticRepository() {
        try (Connection connection = DBManager.getConnection()) {
            Statement statement = connection.createStatement();
            for (Config.COFFE value : Config.COFFE.values()) {
                String select = "SELECT * FROM `coffee_statistic` WHERE `coffee_name` = '" + value.toString() + "'";
                ResultSet resultSet = statement.executeQuery(select);
                if (!resultSet.next()) {
                    String insert = "INSERT INTO `coffee_statistic`(`coffee_name`, `amount`) VALUES ('" + value.toString() + "',0)";
                    statement.executeUpdate(insert);
                }//3====D cj
            }
        } catch (SQLException e) {
        }
    }

    @Override
    public boolean incrementCoffe(String coffeeName) {

        try (Connection connection = DBManager.getConnection()) {

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
        try (Connection connection = DBManager.getConnection()) {
            Statement statement = connection.createStatement();
            Map<String, Integer> map = new HashMap<>();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM coffee_statistic");
            while(resultSet.next()){
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
        //TODO ZADANIE 6 Należy pobrać (zsumować) wszystkie statystyki żeby dowiedzieć się ile nasz ekspres zrobił kaw
        throw new MethodNotImplementedException();
    }

    @Override
    public boolean resetAllStatistics() {
        try (Connection connection = DBManager.getConnection()) {

            Statement statement = connection.createStatement();

            statement.executeUpdate("UPDATE coffee_statistic SET amount = " + 0);
            return true;
        } catch (SQLException e) {
            throw new ResetAllStatisticsException(e);
        }
    }

    @Override
    public boolean resetStatisticFor(String coffeeName) {
        throw new MethodNotImplementedException();
        //TODO ZADANIE 5 Wyzeruj pole amount dla wybranego rodzaju kawy w tabeli coffe_statistic
    }
}
