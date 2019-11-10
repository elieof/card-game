package com.card.game.console;

import com.card.game.model.Card;
import com.card.game.model.Rank;
import com.card.game.model.Suit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class GameConsole {

    private static final Logger LOGGER = LogManager.getLogger(GameConsole.class);


    public static void main(String[] args) {

        // initialize deck of card
        List<Card> deck = Card.initializeDeck();

        // Log deck of cards
        deck.forEach(c -> LOGGER.info(c.toString()));

    }



}
