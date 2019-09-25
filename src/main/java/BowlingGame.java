import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.*;

public class BowlingGame {
    
    final private String rounds;

    public BowlingGame(String rounds){
        if (!doesScoringPatternMatch(rounds)) {
            throw new IllegalArgumentException("Scores doesn't match input pattern!");
        }

        this.rounds = rounds;
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
        int sum = 0;
        String[] scores = stripScores();
        for(int index = 0; index < scores.length - 2; ++index){
            String actScore = scores[index];
            sum += scoreToValue(actScore);
            if(actScore.equals("X")) {
                sum += scoreToValue(scores[index + 1]);
                sum += scoreToValue(scores[index + 2]);
            }
        }
        return sum;
    }

    private String[] stripScores() {
        return Arrays.stream(this.rounds.split(""))
                .filter(stringValue -> !stringValue.equals("|"))
                .toArray(String[]::new);
    }

    private int scoreToValue(String score){
        return score.equals("X") ? 10 : Integer.parseInt(score);
    }

}
