package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.util.Scanner;

public class HumanPlayer implements Player {

    Scanner scanner = new Scanner(System.in);
    Logger logger = LoggerFactory.getLogger("HumanPlayer");

    @Override
    public long askNextGuess() {
        logger.log("You guess: ");
        do {
            try {
                String inputStr = scanner.nextLine();
                return Long.parseLong(inputStr);
            } catch (NumberFormatException e){
                logger.log("Not a number, try again");
            }
        } while(true);
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        String hint;

        if (!lowerOrGreater) {
            hint = "lower";
        } else {
            hint = "greater";
        }
        logger.log("Hint: "+hint);
    }

}
