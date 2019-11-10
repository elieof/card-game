package com.card.game.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "CARD")
@IdClass(Card.class)
public class Card implements Serializable {
    public static final int DECK_SIZE_52 = 52;

//    @Id
//    @Column(name="CARD_ID")
//    @GeneratedValue(strategy=GenerationType.IDENTITY)
//    private int id;

    @Id
    @Enumerated(EnumType.STRING)
    @Column(name = "CARD_RANK", nullable = false)
    private Rank rank;

    @Id
    @Enumerated(EnumType.STRING)
    @Column(name = "CARD_SUIT", nullable = false)
    private Suit suit;

    public Card() {
    }

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    // compare card using only rand and suit
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return rank == card.rank &&
                suit == card.suit;
    }

    @Override
    public int hashCode() {
            return Objects.hash(rank, suit);
    }

    @Override
    public String toString() {
       return rank + " de " + suit;
    }

    public static List<Card> initializeDeck(){
        List<Card> deck = new ArrayList<>(DECK_SIZE_52);
        int index = 0;

        for (Suit s: Suit.values())
        {
            for(Rank r: Rank.values())
            {
                if (index > 51){
                    throw new IllegalArgumentException("Too many numbers of cards");
                }
                else {
                    deck.add(index, new Card(r, s));
                }
                // increment index
                index++;
            }
        }

        return deck;
    }
}
