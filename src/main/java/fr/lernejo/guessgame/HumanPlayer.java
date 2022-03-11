package fr.lernejo.guessgame;



import fr.lernejo.logger.ConsoleLogger;
import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.util.Scanner;

public class HumanPlayer implements Player {

    Scanner scanner = new Scanner(System.in);

    @Override
    public long askNextGuess() {
        long input = scanner.nextLong();
        return input;
    }

    @Override
    public void respond(boolean lowerOrGreater) {

        Logger logger = LoggerFactory.getLogger("respond");

        if (!lowerOrGreater) {
            logger.log("plus petit");
        } else {
            logger.log("plus grand");
        }

    }

}
