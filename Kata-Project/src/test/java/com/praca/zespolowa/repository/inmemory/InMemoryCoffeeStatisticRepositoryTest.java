package com.praca.zespolowa.repository.inmemory;

import com.praca.zespolowa.config.AppConfig;
import com.praca.zespolowa.exception.DataCreationException;
import com.praca.zespolowa.repository.CoffeeStatisticRepository;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InMemoryCoffeeStatisticRepositoryTest {

    private static final String ESPRESSO = AppConfig.COFFEE.ESPRESSO.toString();
    private static final String MEDUIM_LATE = AppConfig.COFFEE.MEDIUM_LATE.toString();

    @Test
    void shouldReturnThreeWhenAddThreeCoffees() throws DataCreationException {
        // given
        CoffeeStatisticRepository repo = new InMemoryCoffeeStatisticRepository();
        repo.incrementCoffe(ESPRESSO);
        repo.incrementCoffe(MEDUIM_LATE);
        repo.incrementCoffe(ESPRESSO);
        // when
        Integer result = repo.getCountOfAllCoffees();
        // then
        assertThat(result).isEqualTo(3);
    }
}
