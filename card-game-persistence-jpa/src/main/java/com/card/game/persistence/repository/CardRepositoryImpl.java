package com.card.game.persistence.repository;

import com.card.game.model.Card;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CardRepositoryImpl implements CardRepository {

    private final SessionFactory sessionFactory;

    public CardRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Card card) {
        sessionFactory.getCurrentSession().save(card);
    }

    @Override
    public void saveAll(List<Card> cards) {
        for (Card card : cards) {
            save(card);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Card> list() {
        String queryString = "from Card as card order by card.suit, card.rank asc";
//        String queryString = "from Card";
        TypedQuery<Card> query = sessionFactory.getCurrentSession().createQuery(queryString);
        return query.getResultList();
    }
}
