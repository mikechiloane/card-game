package com.apiuse;

import com.apiuse.game.CardGame;
import com.apiuse.game.fiveCardDraw.FiveCardDraw;


public class Main {

    public static void main(String[] args) {
        CardGame game = new FiveCardDraw();
        game.run();
    }

}
