package com.card.game.persistence.repository;

import com.card.game.model.Card;

import java.util.List;

public interface CardRepository {

    void save(Card card);

    void saveAll(List<Card> cards);

    List<Card> list();
}
