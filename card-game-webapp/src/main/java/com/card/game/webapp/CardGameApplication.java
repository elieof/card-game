package com.card.game.webapp;

import com.card.game.webapp.api.Card;
import com.card.game.webapp.mapper.CardMapper;
import com.card.game.webapp.service.CardService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication(scanBasePackages = "com.card.game")
@RestController
@RequestMapping(path = "/deck")
@EnableAutoConfiguration(exclude = HibernateJpaAutoConfiguration.class)
public class CardGameApplication {
    private static final Logger LOGGER = LogManager.getLogger(CardGameApplication.class);

    private final CardService cardService;

    public CardGameApplication(CardService cardService) {
        this.cardService = cardService;
    }

    @PostConstruct
    public void initializeDeck(){
        cardService.saveAll(CardMapper.mapFromModel(com.card.game.model.Card.initializeDeck()));
    }

    @GetMapping(path="/", produces = "application/json")
    public List<Card> getDeck() {
        List<Card> result = cardService.getAll();
        LOGGER.info(result);

        return result;
    }

    public static void main(String[] args) {
        SpringApplication.run(CardGameApplication.class, args);
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("DELETE");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
