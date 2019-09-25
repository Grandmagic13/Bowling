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
    public void inuputThrowsWhenOnlyOneValueInRound() {
        new BowlingGame("1|1|1|1|1|1|1|1|1|1||");
    }

    @Test(expected = IllegalArgumentException.class)
    public void inuputThrowsWhenThreeValuesInRound() {
        new BowlingGame("111|111|111|111|111|111|111|111|111|111||");
    }

    @Test(expected = IllegalArgumentException.class)
    public void inuputThrowsWhenOnlyOneMissInRound() {
        new BowlingGame("-|-|-|-|-|-|-|-|-|-||");
    }

    @Test(expected = IllegalArgumentException.class)
    public void inuputThrowsWhenRoundStartsWithSpare() {
        new BowlingGame("12|/2|12|12|12|12|12|12|12|12||");
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


    @Test(expected = IllegalArgumentException.class)
    public void inuputThrowsWhenTwoStrikesInARound() {
        new BowlingGame("X|X|X|XX|X|X|X|X|X|X||XX");
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

    @Test
    public void allNinesAndMisses() {
        BowlingGame game = new BowlingGame("9-|9-|9-|9-|9-|9-|9-|9-|9-|9-||");
        assertThat(game.result(), is(90));
    }

    @Test
    public void allSpares() {
        BowlingGame game = new BowlingGame("5/|5/|5/|5/|5/|5/|5/|5/|5/|5/||5");
        assertThat(game.result(), is(150));
    }

}