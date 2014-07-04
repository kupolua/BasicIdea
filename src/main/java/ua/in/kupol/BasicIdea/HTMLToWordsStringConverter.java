package ua.in.kupol.BasicIdea;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.examples.HtmlToPlainText;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Created by kpl on 04.07.2014.
 */
public class HTMLToWordsStringConverter implements Converter{
    static Logger logger = Logger.getLogger(HTMLToWordsStringConverter.class);
    static PropertiesReader propertiesReader = new PropertiesReader();

    @Override
    public String sourceConverter(String source) {
        String plainText = new String();
        try {
            Document HTMLDoc = Jsoup.connect(source).get();
            plainText = new HtmlToPlainText().getPlainText(Jsoup.parse(String.valueOf(HTMLDoc)));
        } catch (IOException urlReadError) {
            logger.error("Can't read url:" + source, urlReadError);
        }
        return plainText.replaceAll(propertiesReader.getReGex(), "");
    }
}