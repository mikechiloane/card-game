package com.apiuse.domain.hand;

import com.apiuse.domain.card.Rank;

import java.util.List;

public class HandResult {
    private final HandRanking ranking;
    private final List<Rank> highCards;

    public HandResult(HandRanking ranking) {
        this.ranking = ranking;
        this.highCards = null;
    }

    public HandResult(HandRanking ranking, List<Rank> highCards) {
        this.ranking = ranking;
        this.highCards = highCards;
    }

    public HandRanking getRanking() {
        return ranking;
    }


}