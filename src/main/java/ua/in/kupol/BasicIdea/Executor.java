package ua.in.kupol.BasicIdea;

import java.io.IOException;

/**
 * Created by kpl on 03.07.2014.
 */
public class Executor {

    public String sourceReader(String source) throws IOException {


        HTMLToWordsStringConverter htmlToWordsStringConverter = new HTMLToWordsStringConverter();

        return htmlToWordsStringConverter.sourceConverter(source);
    }
}