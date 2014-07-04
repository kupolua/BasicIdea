package ua.in.kupol.BasicIdea;

import org.junit.Assert;
import org.junit.Test;

public class HTMLToWordsStringConverterTest {

    @Test
    public void testSourceConverter() throws Exception {
        //given
        String testActual = new String();

        //when
        HTMLToWordsStringConverter htmlToWordsStringConverter = new HTMLToWordsStringConverter();
        Object testExpected = htmlToWordsStringConverter.sourceConverter("http://google.com");

        //then
        Assert.assertEquals(testExpected.getClass().getName(), testActual.getClass().getName());

    }
}