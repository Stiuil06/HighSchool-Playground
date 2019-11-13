package com.praca.zespolowa.repository;

import com.praca.zespolowa.exception.DataCreationException;
import java.util.Map;

public interface CoffeeStatisticRepository {
    boolean increamentCoffe(String coffeName) throws DataCreationException;
    Map<String,Integer> findAll();
    boolean resetAllStatistics();
    boolean resetStatisticFor(String coffeName);
}
