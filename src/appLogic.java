// backend : handle computer choice & result

import java.util.Random;

public class appLogic {

    public static final String[] compChoices = {"Rock", "Paper", "Scissor"};

    private String compChoice;
    private int compScore , playerScore;

    public String getCompChoice() {
        return compChoice;
    }

    public int getCompScore() {
        return compScore;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    private Random random;

    public appLogic() {
        random = new Random();
    }

    // after players selects choice then this will determine the result
    public String play(String playerChoice) {

        compChoice = compChoices[random.nextInt(compChoices.length)];

        String result;

        if (compChoice.equals("Rock")) {
            if (playerChoice.equals("Paper")) {
                result = "You Win !!";
            } else if (playerChoice.equals("Scissor")) {
                result = "You Lose !!";
            } else {
                result = "Draw !!";
            }
        }else if (compChoice.equals("Paper")) {
            if (playerChoice.equals("Scissor")) {
                result = "You Win !!";
            } else if (playerChoice.equals("Rock")) {
                result = "You Lose !!";
            } else {
                result = "Draw !!";
            }
        }else {
            if (playerChoice.equals("Rock")) {
                result = "You Win !!";
            } else if (playerChoice.equals("Paper")) {
                result = "You Lose !!";
            } else {
                result = "Draw !!";
            }
        }

        return result;
    }
}