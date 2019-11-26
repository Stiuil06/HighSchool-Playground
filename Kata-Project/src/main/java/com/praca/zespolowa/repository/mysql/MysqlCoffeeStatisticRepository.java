package com.praca.zespolowa.repository.mysql;

import com.praca.zespolowa.config.Config;
import com.praca.zespolowa.config.DBManager;
import com.praca.zespolowa.exception.DataCreationException;
import com.praca.zespolowa.repository.CoffeeStatisticRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created By wegrzyna on 26.11.2019
 */
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
    public boolean increamentCoffe(String coffeName) throws DataCreationException {
        //TODO ZADANE 2 Zainkrementuj ilosć zrobionych kaw o podanej nazwie o jeden. Możesz pobrać liczbę dodać jeden i zaaktualizować rekord, lub zrobioć update na bazie
        throw new RuntimeException("method not implemented");
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
        //TODO ZADANE 3 Pobierz wszystkie satystyki zrobionych kaw, załaduj do mapy i zwróc
    }

    @Override
    public boolean resetAllStatistics() {
        //TODO ZADANE 4 Wyzeruj pole amount dla wszystkich rekordów w tabeli coffe_statistic
        throw new RuntimeException("method not implemented");
    }

    @Override
    public boolean resetStatisticFor(String coffeName) {
        throw new RuntimeException("method not implemented");
        //TODO ZADANIE 5 Wyzeruj pole amount dla wybranego rodzaju kawy w tabeli coffe_statistic
    }
}
