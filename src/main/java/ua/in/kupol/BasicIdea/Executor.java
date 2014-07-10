package ua.in.kupol.BasicIdea;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Future;

/**
 * Created by kpl on 03.07.2014.
 */
public class Executor {
    static Logger logger = Logger.getLogger(PropertiesReader.class);

    public ArrayList<String> sourceReader(String sources) throws InterruptedException, FileNotFoundException {
        PropertiesReader propertiesReader = new PropertiesReader();
        ArrayList<String> listSourcesLinks = new ArrayList<String>();
        ThreadPool threadPool = new ThreadPool(2, 2);
        List<Future<String>> list = new ArrayList<Future<String>>();

        Scanner cannerSourcesLinks = null;
        cannerSourcesLinks = new Scanner(new File(propertiesReader.pathToFile() + sources));
        ConvertFactory convertFactory = new ConvertFactory(new String());
        threadPool.execute(convertFactory);
        try {
            String src = new String();
            while (cannerSourcesLinks.hasNext()) {
                src = cannerSourcesLinks.next();
                System.out.println(convertFactory.getConverter(src));
//                System.out.println(src);
//                threadPool.execute(new WordsCounter(sourceGetText));
//                listSourcesLinks.add(wordsCounter.wordsCounter(convertFactory.getConverter(src)) + "\n");
            }
            threadPool.stop();
            return listSourcesLinks;
//        } catch (IOException e) {
//        } catch (InterruptedException e) {
//            e.printStackTrace();
        } finally {
            if (cannerSourcesLinks != null) {
                cannerSourcesLinks.close();
            }
        }

//        return listSourcesLinks;
    }

}