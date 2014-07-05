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
        ArrayList<String> listSourcesLinks = new ArrayList<String>();
        String sourceGetText = new String();

        ThreadPool threadPool = new ThreadPool(3, 3);

        Scanner cannerSourcesLinks = null;
        try {
            cannerSourcesLinks = new Scanner(new File(propertiesReader.pathToFile() + sources));
            String src = new String();
            while (cannerSourcesLinks.hasNext()) {
                src = cannerSourcesLinks.next();
                sourceGetText = convertFactory.getConverter(src);
                threadPool.execute(new WordsCounter(sourceGetText));
//                listSourcesLinks.add(wordsCounter.wordsCounter(convertFactory.getConverter(src)) + "\n");
            }
            threadPool.stop();
            return listSourcesLinks;
        } catch (IOException e) {
            logger.error("No sources file found " + sources, e);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (cannerSourcesLinks != null) {
                cannerSourcesLinks.close();
            }
        }

        return listSourcesLinks;
    }

}