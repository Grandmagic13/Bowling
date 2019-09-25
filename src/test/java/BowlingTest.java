import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

public class BowlingTest {

    // input validation tests

    @Test(expected = IllegalArgumentException.class)
    public void inuputThrowsWhenHasNoSeparators() {
        new BowlingGame("12121212121212121212");
    }

    @Test(expected = IllegalArgumentException.class)
    public void inuputThrowsWhenHasNotEnoughSeparators() {
        new BowlingGame("12|12|1212121212121212");
    }

    @Test(expected = IllegalArgumentException.class)
    public void inuputThrowsWhenHasTooManySeparators() {
        new BowlingGame("12|12|12|12|12|12|12|12|12|12|12||");
    }

    @Test(expected = IllegalArgumentException.class)
    public void inuputThrowsWhenValuesAreCharacters() {
        new BowlingGame("s|s|s|s|s|s|s|s|s|s||");
    }

    @Test(expected = IllegalArgumentException.class)
    public void inuputThrowsWhenValuesAreCharacters2() {
        new BowlingGame("*|*|*|*|*|*|*|*|*|*||");
    }

    // Game mechanics tests

    @Test
    public void gutterGame() {
        BowlingGame game = new BowlingGame("--|--|--|--|--|--|--|--|--|--||");
        assertThat(game.result(), is(0));
    }

    @Test
    public void perfectGame() {
        BowlingGame game = new BowlingGame("X|X|X|X|X|X|X|X|X|X||XX");
        assertThat(game.result(), is(300));
    }

}