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
        initRepository();
    }

    @Override
    public boolean incrementCoffe(String coffeeName) throws DataCreationException {
        int x = coffees.get(coffeeName);
        coffees.replace(coffeeName, x+1);
        return true;
    }

    @Override
    public Map<String,Integer> findAll() {
        return coffees;
    }

    @Override
    public boolean resetAllStatistics() {
        initRepository();
        return true;
    }

    @Override
    public boolean resetStatisticFor(String coffeeName) {
        coffees.replace(coffeeName, 0);
        return true;
    }

    private void initRepository() {
        coffees = new HashMap<>();
        for (Config.COFFE value : Config.COFFE.values()) {
            coffees.put(value.toString(), 0);
        }
    }
}
