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
        ArrayList<String> list = new ArrayList<String>();

        Scanner s = null;
        try {
            s = new Scanner(new File(propertiesReader.pathToFile() + sources));
            String src = new String();
            while (s.hasNext()) {
                src = s.next();
                list.add(wordsCounter.wordsCounter(convertFactory.getConverter(src)).toString() + "\n");
            }
            return list;
        } catch (IOException e) {
            logger.error("No sources file found " + sources, e);
        } finally {
            if (s != null) {
                s.close();
            }
        }

        return list;
    }
}