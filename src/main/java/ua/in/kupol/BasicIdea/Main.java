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
        PropertiesReader propertiesReader = new PropertiesReader();
        logger.info(propertiesReader.getReGex());

        Executor executor = new Executor();
        executor.sourceReader("http://en.wikipedia.org/wiki/Scott_Joplin");
        executor.sourceReader("http://en.wikipedia.org/wiki/Scott_Joplin");
    }
}