package com.praca.zespolowa.repository;

import com.praca.zespolowa.exception.DataCreationException;
import java.util.Map;

public interface CoffeeStatisticRepository {
    boolean incrementCoffe(String coffeeName) throws DataCreationException;
    Map<String,Integer> findAll();
    boolean resetAllStatistics();
    boolean resetStatisticFor(String coffeeName);
}
