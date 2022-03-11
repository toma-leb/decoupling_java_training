package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;
    private long numberToGuess;

    public Simulation(Player player, long numberToGuess) {
        this.player = player;
        this.numberToGuess = numberToGuess;
    }

    public void initialize(long numberToGuess) {
        this.numberToGuess =numberToGuess;
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

        initialize(numberToGuess);

        boolean status = false;
        int round = 1;

        long timeBegin = System.currentTimeMillis();

        while (!status) {
            status = this.nextRound();
            round += 1;
        }
        long timeEnd = System.currentTimeMillis();
        long time = timeEnd - timeBegin;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss.SSS");
        Date date = new Date(time);
        String timeStr = simpleDateFormat.format(date);

        this.logger.log("Time: "+ timeStr);
        this.logger.log("Round: " + round);
    }
}
