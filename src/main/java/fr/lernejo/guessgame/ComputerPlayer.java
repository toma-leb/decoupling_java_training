package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class ComputerPlayer implements Player{

    private long min = Long.MIN_VALUE;
    private long max = Long.MAX_VALUE;
    Logger logger = LoggerFactory.getLogger("toto");

    @Override
    public long askNextGuess() {
        return avg();
    }

    private long avg(){
        return (max + min) /2;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        logger.log(Long.toString(avg()));
        if(lowerOrGreater) {
            max = avg();
        } else {
            min = avg();
        }
    }
}
