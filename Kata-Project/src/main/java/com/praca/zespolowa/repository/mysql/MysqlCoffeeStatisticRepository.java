package com.praca.zespolowa.repository.mysql;

import com.praca.zespolowa.config.Config;
import com.praca.zespolowa.config.DBManager;
import com.praca.zespolowa.exception.DataCreationException;
import com.praca.zespolowa.repository.CoffeeStatisticRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

/**
 * Created By wegrzyna on 26.11.2019
 */
public class MysqlCoffeeStatisticRepository implements CoffeeStatisticRepository {
    public MysqlCoffeeStatisticRepository() {
        try(Connection connection = DBManager.getConnection()){
            Statement statement = connection.createStatement();
            for (Config.COFFE value : Config.COFFE.values()) {
                String select = "SELECT * FROM `coffee_statistic` WHERE `coffee_name` = '"+ value.toString() +"'";
                ResultSet resultSet = statement.executeQuery(select);
                if(!resultSet.next()){
                    String insert = "INSERT INTO `coffee_statistic`(`coffee_name`, `amount`) VALUES ('"+value.toString()+"',0)";
                    statement.executeUpdate(insert);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean increamentCoffe(String coffeName) throws DataCreationException {
        //TODO ZADANE 2 Zainkrementuj ilosć zrobionych kaw o podanej nazwie o jeden. Możesz pobrać liczbę dodać jeden i zaaktualizować rekord, lub zrobioć update na bazie
        throw new RuntimeException("method not implemented");
    }

    @Override
    public Map<String, Integer> findAll() {
        //TODO ZADANE 3 Pobierz wszystkie satystyki zrobionych kaw, załaduj do mapy i zwróc
        throw new RuntimeException("method not implemented");
    }

    @Override
    public boolean resetAllStatistics() {
        try (Connection connection = DBManager.getConnection()) {

            Statement statement = connection.createStatement();

            statement.executeUpdate("UPDATE coffee_statistic SET amount = " + 0);
            return true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean resetStatisticFor(String coffeName) {
        throw new RuntimeException("method not implemented");
        //TODO ZADANIE 5 Wyzeruj pole amount dla wybranego rodzaju kawy w tabeli coffe_statistic
    }
}
