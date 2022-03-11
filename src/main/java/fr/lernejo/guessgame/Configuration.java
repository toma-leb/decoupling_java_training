package fr.lernejo.guessgame;

import java.util.Random;

public class Configuration {

    final Player player;
    final long numberToGuess;

    private Configuration(Player player, long numberToGuess) {
        this.player = player;
        this.numberToGuess = numberToGuess;
    }

    static Configuration parseArgs(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Missing mode parameter");
        }
        String mode = args[0];
        return switch (mode) {
            case "-interactive" -> new Configuration(new HumanPlayer(), new Random().nextInt(101));
            case "-auto" -> {
                if (args.length < 2) {
                    throw new IllegalArgumentException("Missing numberToGuess for auto mode");
                }
                yield new Configuration(new ComputerPlayer(), Long.parseLong(args[1]));
            }
            default -> throw new IllegalArgumentException("Unknown mode:" + mode);
        };
    }
}
