package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestGame {
    Game game = new Game();
    Player player1 = new Player(1, "Bot", 50);
    Player player2 = new Player(2, "Noob", 150);
    Player player3 = new Player(3, "Noob2", 150);
    Player player4 = new Player(4, "Normal", 250);
    Player player5 = new Player(5, "Pro", 350);

    @BeforeEach
    public void reg() {

        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
    }

    @Test
    public void testVirtoryFirst() {
        int expected = 1;
        int actual = game.round("Pro", "Normal");
        Assertions.assertEquals(expected, actual);

    }
    @Test
    public void testDraw() {
        int expected = 0;
        int actual = game.round("Noob", "Noob2");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testVirtoryLast() {
        int expected = 2;
        int actual = game.round("Noob", "Normal");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testNotRegisteredSecond() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            game.round("Pro", "Bot");
        });
    }

    @Test
    public void testNotRegisteredFirst() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            game.round("Bot", "Noob2");
        });
    }
}
