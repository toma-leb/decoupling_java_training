package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.util.Scanner;


public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;
    private long numberToGuess;

    public Simulation(Player player) {
        this.player = player;
    }

    public void initialize(long numberToGuess) {
        this.numberToGuess = numberToGuess;
        this.loopUntilPlayerSucceed();
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {

        long guess = this.player.askNextGuess();

        if (guess == this.numberToGuess) {
            this.logger.log("SUCCESS !");
            return true;
        } else if (guess < this.numberToGuess) {
            this.player.respond(true);
        } else {
            this.player.respond(false);
        }
        return false;
    }

    public void loopUntilPlayerSucceed() {

        boolean status = false;

        while (!status) {
            status = this.nextRound();
        }
    }
}
