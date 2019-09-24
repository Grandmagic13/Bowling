import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.*;

public class BowlingGame {

    public BowlingGame(String scores){
        if (!doesScoringPatternMatch(scores)) {
            throw new IllegalArgumentException("Scores doesn't match input pattern!");
        }
    }

    private boolean doesScoringPatternMatch(String scores) {
        Pattern scoringPattern = Pattern.compile(scoringPattern());
        return scoringPattern.matcher(scores).matches();
    }

    private String scoringPattern() {
        final String values = "[\\d, X]";
        final String round = String.format("%s\\|", values);
        final String bonusScores = String.format("\\|%s?X?", values);

        List<String> patternList = new ArrayList<>(Collections.nCopies(10, round));
        patternList.add(bonusScores);
        return String.join("", patternList);
    }

    public int result(){
        return 0;
    }

}
