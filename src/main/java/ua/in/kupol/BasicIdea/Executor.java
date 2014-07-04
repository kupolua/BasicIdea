package ua.in.kupol.BasicIdea;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by kpl on 03.07.2014.
 */
public class Executor {
    static Logger logger = Logger.getLogger(PropertiesReader.class);

    public ArrayList<String> sourceReader(String sources) {
        PropertiesReader propertiesReader = new PropertiesReader();
        ConvertFactory convertFactory = new ConvertFactory();
        WordsCounter wordsCounter = new WordsCounter();
        ArrayList<String> listSourcesLinks = new ArrayList<String>();

        Scanner cannerSourcesLinks = null;
        try {
            cannerSourcesLinks = new Scanner(new File(propertiesReader.pathToFile() + sources));
            String src = new String();
            while (cannerSourcesLinks.hasNext()) {
                src = cannerSourcesLinks.next();
                listSourcesLinks.add(wordsCounter.wordsCounter(convertFactory.getConverter(src)) + "\n");
            }
            return listSourcesLinks;
        } catch (IOException e) {
            logger.error("No sources file found " + sources, e);
        } finally {
            if (cannerSourcesLinks != null) {
                cannerSourcesLinks.close();
            }
        }

        return listSourcesLinks;
    }
}