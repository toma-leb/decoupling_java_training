package fr.lernejo.guessgame;

import java.io.ObjectInputFilter;
import java.security.SecureRandom;

public class Launcher {
    public static void main(String[] args) {
        Configuration configuration = Configuration.parseArgs(args);
        Simulation currentSimulation = new Simulation(configuration.player, configuration.numberToGuess);
        currentSimulation.loopUntilPlayerSucceed();
    }
}
