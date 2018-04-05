package kr.personal.cjh.tdd.practice.bowling;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GameTest {

    private Game game;

    @Before
    public void setUp() throws Exception {
        game = new Game();
    }

    private void rollMany(int pins, int frames) {
        for (int i = 0; i < frames; i++) {
            game.roll(pins);
        }
    }

    @Test
    public void canRoll() {
        game.roll(0);
    }
    // Gutter 게임이 젤 쉬움.

    private void rollSpare() {
        game.roll(5);
        game.roll(5);
    }

    private void rollStrike() {
        game.roll(10);
        game.roll(5);
    }

    @Test
    public void gutterGame() {
        rollMany(0, 20);
        assertThat(game.getScore(), is(0));
    }

    // Gutter 게임 이후 그 다음 젤 쉬운거 부터 순서대로

    @Test
    public void allOnes() {
        rollMany(1, 20);
        assertThat(game.getScore(), is(20));
    }

    @Test
    public void oneSpare() {
        rollSpare();
        game.roll(3);
        rollMany(17, 0);
        assertThat(game.getScore(), is(16));
    }

    @Test
    public void oneStrike() {
        rollStrike();
        game.roll(3);
        rollMany(16, 0);
        assertThat(game.getScore(), is(26));
    }

    @Test
    public void perfectStrike() {
        rollMany(10, 10);
        game.roll(10);
        game.roll(10);
        assertThat(game.getScore(), is(300));
    }
}
