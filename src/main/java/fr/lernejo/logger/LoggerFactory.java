package fr.lernejo.logger;

public class LoggerFactory{

    public static Logger getLogger(String Name) {
        Logger name = new ConsoleLogger();
        return name;
    }
}
