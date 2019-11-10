package com.card.game.webapp.mapper;

import com.card.game.webapp.api.Card;
import com.card.game.webapp.api.Rank;
import com.card.game.webapp.api.Suit;

import java.util.ArrayList;
import java.util.List;

public class CardMapper {

    public static Suit mapFromModel(com.card.game.model.Suit source) {
        if (source == null) {
            return null;
        }
        for (Suit value : Suit.values()) {
            if (source.name().equals(value.name())) {
                return value;
            }
        }
            throw new IllegalArgumentException("Could not find Suit from Enum value [" + source + "]");
    }
    public static com.card.game.model.Suit mapToModel(Suit source) {
        if (source == null) {
            return null;
        }
        for (com.card.game.model.Suit value : com.card.game.model.Suit.values()) {
            if (source.name().equals(value.name())) {
                return value;
            }
        }
        throw new IllegalArgumentException("Could not find Suit from Enum value [" + source + "]");
    }

    public static Rank mapFromModel(com.card.game.model.Rank source) {
        if (source == null) {
            return null;
        }
        for (Rank value : Rank.values()) {
            if (source.name().equals(value.name())) {
                return value;
            }
        }
        throw new IllegalArgumentException("Could not find Rank from Enum value [" + source + "]");
    }
    public static com.card.game.model.Rank mapToModel(Rank source) {
        if (source == null) {
            return null;
        }
        for (com.card.game.model.Rank value : com.card.game.model.Rank.values()) {
            if (source.name().equals(value.name())) {
                return value;
            }
        }
        throw new IllegalArgumentException("Could not find Rank from Enum value [" + source + "]");
    }

    public static Card mapFromModel(com.card.game.model.Card source) {
        if (source == null) {
            return null;
        }
        return new Card(mapFromModel(source.getRank()), mapFromModel(source.getSuit()));
    }

    public static com.card.game.model.Card mapToModel(Card source) {
        if (source == null) {
            return null;
        }
        return new com.card.game.model.Card(mapToModel(source.getRank()), mapToModel(source.getSuit()));
    }

    public static List<Card> mapFromModel(List<com.card.game.model.Card> source) {
        List<Card> cards = new ArrayList<>(source.size());

        for (com.card.game.model.Card card : source) {
            cards.add(mapFromModel(card));
        }
        return cards;
    }
    public static List<com.card.game.model.Card> mapToModel(List<Card> source) {
        List<com.card.game.model.Card> cards = new ArrayList<>(source.size());

        for (Card card : source) {
            cards.add(mapToModel(card));
        }
        return cards;
    }


}
