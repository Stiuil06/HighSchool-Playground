package com.praca.zespolowa.controller;

import com.praca.zespolowa.config.AppConfig;
import com.praca.zespolowa.repository.CoffeeStatisticRepository;
import com.praca.zespolowa.repository.inmemory.InMemoryCoffeeStatisticRepository;
import com.praca.zespolowa.view.test.TestView;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.stream.IntStream;


/**
 * Created By wegrzyna on 13.11.2019
 */
public class ExpressoTest {

    TestView view;
    private CoffeeStatisticRepository coffeeStatisticRepository;
    private AppConfig appConfig;
    private Command command;

    @Given("^clean statistic repository$")
    public void clean_statistic_repository() {
        view = new TestView();
        coffeeStatisticRepository = new InMemoryCoffeeStatisticRepository();
        appConfig = new AppConfig(view, coffeeStatisticRepository);
    }

    @When("create {word} espresso {int} times")
    public void create_espresso_times(String size, Integer times) {
        view.setReadString(size);

        command = getCommand(appConfig, CreateExpressoCommand.class);
        IntStream.range(0, times).forEach((i) -> command.execute());
    }

    @Then("{int} espresso in statistics")
    public void espresso_in_statistics(Integer amount) {
        Integer madeEspresso = coffeeStatisticRepository.findAll().get(AppConfig.COFFE.EGZPREZZO.toString());
        Assert.assertEquals(amount, madeEspresso);
    }

    private Command getCommand(AppConfig appConfig, Class<? extends Command> clazz) {
        return appConfig.initializeCommands().stream().filter(c -> clazz.isInstance(c)).findFirst().get();
    }
}