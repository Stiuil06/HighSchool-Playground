package com.praca.zespolowa.controller;

import com.praca.zespolowa.repository.CoffeeStatisticRepository;
import com.praca.zespolowa.view.View;

import java.sql.SQLException;

public class GetCountOfAllCoffees implements Command {

    private final View view;
    private final CoffeeStatisticRepository coffeeStatisticRepository;

    public GetCountOfAllCoffees(View view, CoffeeStatisticRepository coffeeStatisticRepository) {
        this.view = view;
        this.coffeeStatisticRepository = coffeeStatisticRepository;
    }

    @Override
    public void execute() throws SQLException {
        view.info(coffeeStatisticRepository.getCountOfAllCoffees().toString());
    }

    @Override
    public String getLabel() {
        return "Get Count Of All Coffees";
    }
}
