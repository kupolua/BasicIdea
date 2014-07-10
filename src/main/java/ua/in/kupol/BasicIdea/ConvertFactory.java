package ua.in.kupol.BasicIdea;

import java.util.concurrent.Callable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by pavelkulakovsky on 04.07.14.
 */
public class ConvertFactory implements Callable{
    public String sourceAdress = new String();
    public ConvertFactory(String src) {
        sourceAdress = src;
    }
    @Override
    public Object call() throws Exception {
//        System.out.println(Thread.currentThread().getName());
        System.out.println(getConverter(sourceAdress));
        return "";
//        return getConverter(sourceAdress);
    }
    public String getConverter(String source){
        String noClassPresent = "No Class Present";

        Pattern HTMLPattern = Pattern.compile("http");
        Matcher HTMLMatcher = HTMLPattern.matcher(source);

        Pattern FILEPattern = Pattern.compile("txt");
        Matcher FILEMatcher = FILEPattern.matcher(source);

        if (HTMLMatcher.find()){
            HTMLToWordsStringConverter htmlToWordsStringConverter =  new HTMLToWordsStringConverter();

            return htmlToWordsStringConverter.sourceConverter(source);
        } else if (FILEMatcher.find()){
            TextFileToWordsStringConverter textFileToWordsStringConverter = new TextFileToWordsStringConverter();
            return textFileToWordsStringConverter.sourceConverter(source);
        }
        return noClassPresent;
    }

}
