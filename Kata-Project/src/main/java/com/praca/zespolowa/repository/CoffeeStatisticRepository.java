package com.praca.zespolowa.repository;

import com.praca.zespolowa.exception.DataCreationException;

import java.sql.SQLException;
import java.util.Map;

public interface CoffeeStatisticRepository {
    boolean incrementCoffe(String coffeeName) throws DataCreationException;

    Map<String, Integer> findAll();

    Integer getCountOfAllCoffees();

    boolean resetAllStatistics() throws SQLException;

    boolean resetStatisticFor(String coffeeName);
}
