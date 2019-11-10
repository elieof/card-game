package com.card.game.persistence.repository;

import com.card.game.model.Card;
import com.card.game.model.Rank;
import com.card.game.model.Suit;
import com.card.game.persistence.configuration.PersistenceConfig;
import org.hibernate.NonUniqueObjectException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {PersistenceConfig.class},
        loader = AnnotationConfigContextLoader.class)
@Transactional
public class CardRepositoryTest {

    @Resource
    private CardRepository cardRepository;

    @Test
    public void givenCardWhenSaveThenOK() {
        //given a card
        Card card = new Card(Rank.ACE, Suit.CLUBS);

        // when it is save
        cardRepository.save(card);

        // the card is available in the database
        assertThat(cardRepository.list().size()).isEqualTo(1);
    }

    @Test
    public void givenSameCardWhenSaveThenKO() {
        // given two similar cards
        Card card1 = new Card(Rank.ACE, Suit.CLUBS);
        Card card2 = new Card(Rank.ACE, Suit.CLUBS);

        // when saving both of them
        cardRepository.save(card1);

        // an exception is thrown because a card is unique in the database
        assertThatThrownBy(() -> cardRepository.save(card2))
                .isExactlyInstanceOf(NonUniqueObjectException.class);

    }

    @Test
    public void givenDeckWhenSaveThenOK() {
        // initialize deck of card
        List<Card> deck = Card.initializeDeck();

        // when saving all card to database
        cardRepository.saveAll(deck);

        // then all card are in the database
        List<Card> result = cardRepository.list();
        assertThat(result.size()).isEqualTo(deck.size());
        assertThat(result).containsAll(deck);
    }
}
