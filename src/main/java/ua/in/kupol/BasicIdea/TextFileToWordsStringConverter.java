package ua.in.kupol.BasicIdea;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by kpl on 04.07.2014.
 */
public class TextFileToWordsStringConverter implements Converter{
    static Logger logger = Logger.getLogger(TextFileToWordsStringConverter.class);

    @Override
    public String sourceConverter(String source) {
        InputStream input = null;
        String noTextSourceFile = "No Source File";

        try {
            byte[] textSources = Files.readAllBytes(Paths.get(source));
            return new String(textSources);
        } catch (IOException ex) {
            logger.error("Sorry, unable to find " + source, ex);
        } finally{
            if(input!=null){
                try {
                    input.close();
                } catch (IOException e) {
                    logger.error("Sorry, can't close file" + source, e);
                }
            }
        }
        return noTextSourceFile;
    }
}