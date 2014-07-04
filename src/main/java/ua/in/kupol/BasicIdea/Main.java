package ua.in.kupol.BasicIdea;

import org.apache.log4j.Logger;

import java.io.IOException;

/**
 * Created by kpl on 03.07.2014.
 */
public class Main {
    static Logger logger = Logger.getRootLogger();
    public static final String PROPERTIES_FILE  = "config.properties";
    public static void main(String[] args) throws IOException {
        logger.info("Run programm BasicIdea");

        Executor executor = new Executor();
        logger.info("Result read source : " + executor.sourceReader("/Users/pavelkulakovsky/DevTeam/BasicIdea/src/main/resources/metro.txt").toString() + " : ");
    }
}