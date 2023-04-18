package co.tenisu.atelierrestapp.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import co.tenisu.atelierrestapp.dto.StatisticResponseDto;
import co.tenisu.atelierrestapp.repository.PlayerRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.data.Percentage.withPercentage;
import static org.springframework.test.annotation.DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD;

@ActiveProfiles("test")
@TestPropertySource(properties = "spring.jpa.hibernate.ddl-auto=none")
@DirtiesContext(classMode = AFTER_EACH_TEST_METHOD)
@ExtendWith(SpringExtension.class)
@DataJpaTest
public class PlayerServiceImplTest {

    @Autowired
    PlayerRepository playerRepository;

    private PlayerServiceImpl playerService;

    @BeforeEach
    public void setup() {
        playerService = new PlayerServiceImpl(playerRepository);
    }

    @Test
    @Sql("classpath:data/sql/players.sql")
    void getStatisticsWithNoPlayers() {
        StatisticResponseDto statistics = playerService.getStatistics();
        assertThat(statistics.getAverageIMC()).isCloseTo(26.29, withPercentage(10.0));

    }
}