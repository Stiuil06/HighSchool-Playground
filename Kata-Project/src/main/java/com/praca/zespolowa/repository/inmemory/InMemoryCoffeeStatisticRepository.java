package com.praca.zespolowa.repository.inmemory;


import com.praca.zespolowa.config.AppConfig;
import com.praca.zespolowa.repository.CoffeeStatisticRepository;

import java.util.HashMap;
import java.util.Map;

public class InMemoryCoffeeStatisticRepository implements CoffeeStatisticRepository {

    private Map<String, Integer> coffees;

    public InMemoryCoffeeStatisticRepository() {
        initRepository();
    }

    @Override
    public boolean incrementCoffe(String coffeeName) {
        int x = coffees.get(coffeeName);
        coffees.replace(coffeeName, x + 1);
        return true;
    }

    @Override
    public Map<String, Integer> findAll() {
        return coffees;
    }

    @Override
    public Integer getCountOfAllCoffees() {
        // TODO Zadanie 6 Należy pobrać (zsumować) wszystkie statystyki żeby dowiedzieć się ile nasz ekspres zrobił kaw
        return coffees.values().stream().mapToInt(Integer::intValue).sum();
//    throw new MethodNotImplementedException();
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
        for (AppConfig.COFFE value : AppConfig.COFFE.values()) {
            coffees.put(value.toString(), 0);
        }
    }
}
