package com.card.game.webapp.service;

import com.card.game.persistence.repository.CardRepository;
import com.card.game.webapp.api.Card;
import com.card.game.webapp.mapper.CardMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;

    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    @Transactional
    public void saveAll(List<Card> cards) {
        cardRepository.saveAll(CardMapper.mapToModel(cards));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Card> getAll() {
        return CardMapper.mapFromModel(cardRepository.list());
    }
}
