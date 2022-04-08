import org.testng.TestNG;
import org.testng.xml.SuiteXmlParser;
import org.testng.xml.XmlSuite;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws URISyntaxException, IOException {
        TestNG testng = new TestNG();
        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("testng.xml");
        SuiteXmlParser parser = new SuiteXmlParser();
        XmlSuite suite = parser.parse("testng.xml", inputStream, true);
        System.out.println(suite);
        testng.setXmlSuites(new ArrayList<>(Collections.singleton(suite)));
        testng.run();
    }
}