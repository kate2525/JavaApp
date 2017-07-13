package data;


import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Root;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ParseSAX extends DefaultHandler implements Parser {

    public Root parse() {
        ParseSAX handler = null;
        try {
            //Create a "parser factory" for creating SAX parsers
            SAXParserFactory spfac = SAXParserFactory.newInstance();

            //Now use the parser factory to create a SAXParser object
            SAXParser sp = spfac.newSAXParser();

            //Create an instance of this class; it defines all the handler methods
            handler = new ParseSAX();

            //Finally, tell the parser to parse the input and notify the handler
            sp.parse("student.xml", handler);

            handler.getResult();

        } catch (Exception ex) {
        }
        return handler.root;
    }

    
    
     ArrayList<Students> list = new ArrayList<>();
     Root root = new Root();
    String thisElement = "";

    public void getResult() {
        System.out.println(list.toString());
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start parse XML...");
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        thisElement = qName;
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        thisElement = "";
    }

    int count = 0;
    Students students = null;
    ArrayList<Integer> ratingList = null;
   
    boolean isRootName = false;

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

        if(isRootName == false) {
            if (thisElement.equals("name")) {
                root.setName((new String(ch, start, length)));
                System.out.println("name" +root);
            } else if (thisElement.equals("location")) {
                root.setLocation((new String(ch, start, length)));
                isRootName = true;
                System.out.println("name" +root);
            }
        }

        if (count == 0) {
            students = new Students();
            ratingList = new ArrayList<>();
        }
        if(thisElement.equals("id")) {
            students.setId((Integer.valueOf(new String(ch, start, length))));
            count++;
        }
        else if(thisElement.equals("name")) {
            students.setName((new String(ch, start, length)));
            count++;
        }
         else if (thisElement.equals("degree")) {
            students.setDegree((new String(ch, start, length)));
            count++;
        } 
        else if (thisElement.equals("dateOfBirth")) {
            SimpleDateFormat s = new SimpleDateFormat();
            s.applyPattern("yyyy-MM-dd");
            
            Date date = null;
            try {
                date = s.parse(new String(ch, start, length));
            } catch (ParseException ex) {
                Logger.getLogger(ParseSAX.class.getName()).log(Level.SEVERE, null, ex);
            }
              students.setDateOfBirth(date);
            count++;
        }
     
        else if (thisElement.equals("rating")) {
        ratingList.add((Integer.valueOf(new String(ch, start, length))));
       
        }
        else if (thisElement.equals("visible")) {
            students.setVisible(Boolean.valueOf(new String(ch, start, length)));
            count++;
        }

        if (count == 6) {
            students.setRatingList(ratingList);
            list.add(students);
            count = 0;
        }
    }

    @Override
    public void endDocument() {
        System.out.println("Stop parse XML...");
        root.setStudList(list);
    }

    public ArrayList<Students> getList() {
        return list;
    }
    
    
}
