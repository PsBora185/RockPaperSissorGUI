// backend : handle computer choice & result

import java.util.Random;

public class appLogic {

    public static final String[] compChoices = {"Rock", "Paper", "Scissor"};

    private String compChoice;
    private int compScore , playerScore;

    public String getCompChoice() {
        return this.compChoice;
    }

    public int getCompScore() {
        return this.compScore;
    }

    public int getPlayerScore() {
        return this.playerScore;
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
                playerScore++;
            } else if (playerChoice.equals("Scissor")) {
                result = "You Lose !!";
                compScore++;
            } else {
                result = "Draw !!";
            }
        }else if (compChoice.equals("Paper")) {
            if (playerChoice.equals("Scissor")) {
                result = "You Win !!";
                playerScore++;
            } else if (playerChoice.equals("Rock")) {
                result = "You Lose !!";
                compScore++;
            } else {
                result = "Draw !!";
            }
        }else {
            if (playerChoice.equals("Rock")) {
                result = "You Win !!";
                playerScore++;
            } else if (playerChoice.equals("Paper")) {
                result = "You Lose !!";
                compScore++;
            } else {
                result = "Draw !!";
            }
        }

        return result;
    }
}