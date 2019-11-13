package com.praca.zespolowa.controller;

import com.praca.zespolowa.config.Config;
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
    private Config config;
    private Command command;

    @Given("^clean statistic repository$")
    public void clean_statistic_repository() {
        view = new TestView();
        coffeeStatisticRepository = new InMemoryCoffeeStatisticRepository();
        config = new Config(view, coffeeStatisticRepository);
    }

    @When("create {word} espresso {int} times")
    public void execute_CreateExpresso_command_times_and_select_single_espressoo(String size, Integer times) {
        view.setReadString(size);

        command = getCommand(config, CreateExpresso.class);
        IntStream.range(0, times).forEach((i) -> command.execute());
    }

    @Then("{int} espresso in statistics")
    public void espresso_in_statistics(Integer amount) {
        Integer madeEspresso = coffeeStatisticRepository.findAll().get(Config.COFFE.EGZPREZZO.toString());
        Assert.assertEquals(amount, madeEspresso);
    }

    private Command getCommand(Config config, Class<? extends Command> clazz) {
        return config.initializeCommands().stream().filter(c -> clazz.isInstance(c)).findFirst().get();
    }
}