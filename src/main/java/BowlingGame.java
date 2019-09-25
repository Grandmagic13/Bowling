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
        final String round = "([\\d, -]{2}|\\d/|X)\\|";
        final String bonusScores = "\\|(\\d|X)?X?";

        List<String> patternList = new ArrayList<>(Collections.nCopies(10, round));
        patternList.add(bonusScores);
        return String.join("", patternList);
    }

    public int result(){
        int sum = 0;
        String[] scores = stripScores();
        for(int index = 0; index < scores.length - numberOfBonusRolls(); ++index){
            String actScore = scores[index];
            sum += scoreToValue(scores, index);
            if(actScore.equals("X")) {
                sum += scoreToValue(scores, index + 1);
                sum += scoreToValue(scores, index + 2);
            }
            if(actScore.equals("/")){
                sum += scoreToValue(scores, index + 1);
            }
        }
        return sum;
    }

    private int numberOfBonusRolls(){
        String[] roundsBonusesSplit = this.rounds.split("\\|\\|");
        return roundsBonusesSplit.length < 2 ? 0 : roundsBonusesSplit[1].length();
    }

    private String[] stripScores() {
        return Arrays.stream(this.rounds.split(""))
                .filter(stringValue -> !stringValue.equals("|"))
                .toArray(String[]::new);
    }

    private int scoreToValue(String[] scores, int index){
        switch(scores[index]){
            case "X":
                return 10;
            case "-":
                return 0;
            case "/":
                return 10 - scoreToValue(scores, index - 1);
            default:
                return Integer.parseInt(scores[index]);
        }
    }

}
