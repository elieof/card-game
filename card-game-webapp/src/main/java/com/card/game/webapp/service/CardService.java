package com.card.game.webapp.service;


import com.card.game.webapp.api.Card;

import java.util.List;

public interface CardService {

    void saveAll(List<Card> cards);

    List<Card> getAll();
}
