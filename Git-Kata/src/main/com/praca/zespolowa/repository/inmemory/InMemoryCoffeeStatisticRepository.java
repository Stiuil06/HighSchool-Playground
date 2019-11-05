package com.praca.zespolowa.repository.inmemory;


import com.praca.zespolowa.config.Config;
import com.praca.zespolowa.exception.DataCreationException;
import com.praca.zespolowa.model.Coffee;
import com.praca.zespolowa.repository.CoffeeStatisticRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryCoffeeStatisticRepository implements CoffeeStatisticRepository {

    private Map<String, Integer> coffees;

    public InMemoryCoffeeStatisticRepository() {
        coffees = new HashMap<>();
        for (Config.COFFE value : Config.COFFE.values()) {
            coffees.put(value.toString(), 0);
        }
    }

    @Override
    public boolean increamentCoffe(String coffeName) throws DataCreationException {
        int x = coffees.get(coffeName);
        coffees.replace(coffeName, x+1);
        return true;
    }

    @Override
    public Map<String,Integer> findAll() {
        return coffees;
    }

    @Override
    public boolean resetAllStatistics() {
        coffees = new HashMap<>();
        return true;
    }

    @Override
    public boolean resetStatisticFor(String coffeName) {
        coffees.replace(coffeName, 0);
        return true;
    }
}
