import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.println("Please enter 'Q' to quit or your bowling scores in the following format:");
        System.out.println("frames are separated by: '|'");
        System.out.println("The game ending frame is represented by: '||'");
        System.out.println("gutter rolls are: '-'");
        System.out.println("strikes are: 'X'");
        System.out.println("spares are: '/'");
        System.out.println("(The rest of the scores can be represented by numbers)");
        System.out.println("An example input would be:");
        System.out.println("X|7/|9-|X|-8|8/|-6|X|X|X||81");
        Scanner scanner = new Scanner(System.in);
        String input;
        while(true){
            input = scanner.nextLine();
            if (input.equals("Q")) {
                break;
            }
            try {
                BowlingGame game = new BowlingGame(input);
                System.out.println("The game result is: " + game.result());
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
            System.out.println("Please enter 'Q' to quit or a new bowling game score to calculate the result!");
        }
    }
}
