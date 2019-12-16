package com.praca.zespolowa.repository;

import com.praca.zespolowa.config.Config;
import com.praca.zespolowa.exception.DataCreationException;
import com.praca.zespolowa.repository.inmemory.InMemoryCoffeeStatisticRepository;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

import static org.junit.Assert.assertEquals;


/**
 * Created By wegrzyna on 13.11.2019
 */
public class CoffeeStatisticRepositoryTest {
    private CoffeeStatisticRepository coffeeStatisticRepository;

    @Given("not empty repository")
    public void not_empty_repository() throws DataCreationException {
        coffeeStatisticRepository = new InMemoryCoffeeStatisticRepository();
        coffeeStatisticRepository.incrementCoffe(Config.COFFE.DUŻA_LATE.toString());
    }

    @When("reset repository")
    public void reset_repository() {
        coffeeStatisticRepository.resetAllStatistics();
    }

    @Then("repository is empty")
    public void repository_is_empty() {
        for (Map.Entry<String, Integer> entry : coffeeStatisticRepository.findAll().entrySet()) {
            assertEquals(Integer.valueOf(0), entry.getValue());
        }
    }
}
