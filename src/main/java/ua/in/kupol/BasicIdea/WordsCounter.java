package ua.in.kupol.BasicIdea;

import org.apache.log4j.Logger;

import java.util.*;
import java.util.concurrent.Callable;

/**
 * Created by pavelkulakovsky on 04.07.14.
 */
public class WordsCounter implements Callable {
    static Logger logger = Logger.getLogger(WordsCounter.class);
    public String getText = new String();
    public WordsCounter(String sourceGetText) {
       getText = sourceGetText;
    }

    @Override
    public Object call() throws Exception {
        return wordsCounter(this.getText);
    }

    public Map wordsCounter(String convertedSource) {

        logger.info("Start WordsCounter programm");

        String textSource = convertedSource.replaceAll("[^aA-zZ ’]", " ");
        logger.info("Text after ReGex " + textSource);

        List<String> wordsList = new ArrayList<String>(Arrays.asList(textSource.split(" ")));
        Map<String, Integer> words = new HashMap<String, Integer>();
        int countWord;
        for(String word : wordsList) {
            if (words.get(word.toLowerCase()) == null) {
                words.put(word.toLowerCase(), 1);
            } else {
                countWord = words.get(word.toLowerCase());
                words.put(word.toLowerCase(), countWord + 1);
            }
        }
        Map<String, Integer> wordsSortByFound = sortByComparator(words);
        return wordsSortByFound;
    }
    private static Map sortByComparator(Map unsortMap) {

        List list = new LinkedList(unsortMap.entrySet());

        Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((Comparable) ((Map.Entry) (o2)).getValue())
                        .compareTo(((Map.Entry) (o1)).getValue());
            }
        });

        Map sortedMap = new LinkedHashMap();
        for (Iterator it = list.iterator(); it.hasNext();) {
            Map.Entry entry = (Map.Entry) it.next();
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }
}
