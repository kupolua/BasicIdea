package ua.in.kupol.BasicIdea;

import java.io.IOException;
import java.util.Map;

/**
 * Created by kpl on 03.07.2014.
 */
public class Executor {

    public Map sourceReader(String source) throws IOException { //todo: remake throws => try catch

        ConvertFactory convertFactory = new ConvertFactory();
        WordsCounter wordsCounter = new WordsCounter();

        return wordsCounter.wordsCounter(convertFactory.getConverter(source));
//        return convertFactory.getConverter(source);
    }
}