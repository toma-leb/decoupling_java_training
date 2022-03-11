package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class Launcher {
    public static void main(String[] args) {
        HumanPlayer currentPlayer = new HumanPlayer();
        Simulation currentSimulation = new Simulation(currentPlayer);

        SecureRandom random = new SecureRandom();
        long randomNumber = random.nextInt(100);

        currentSimulation.initialize(randomNumber);
    }
}
