package domain;


import data.Root;
import data.Students;
import data.Parser;
import data.ParseSAX;
import data.ParseGSON;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class Controller {

    private ArrayList<Students> list = new ArrayList<>();
    private static Controller instance = new Controller();

    public static Controller getInstance() {
        return instance;
    }

    private Controller() {
    }

  

    public ArrayList<Students> getSortedbyName() {
        Collections.sort(list, new Comparator<Students>() {
            @Override
            public int compare(Students t, Students t1) {
                return t.getName().compareTo(t1.getName());
            }
        });

        System.out.println("list name " + list.toString());
        return list;
    }

    public ArrayList<Students> getSortedbyAge() {
        Collections.sort(list, new Comparator<Students>() {
            @Override
            public int compare(Students t, Students t1) {
                return t.getDateOfBirth().compareTo(t1.getDateOfBirth());
            }
        });
        System.out.println("list age " + list.toString());
        return list;
    }

    public ArrayList<Students> getFindbyName(String tekst) {

        ArrayList<Students> listNewName = new ArrayList<>();
        for (Students student : list) {
            if (tekst.equals(student.getName())) {
                System.out.println("Совпадает имя");
                listNewName.add(student);
                break;
            } else {
                System.out.println("Не совпадает имя");
            }
        }

        return listNewName;
    }

    public ArrayList<Students> getFindbyAge(String tekst) {
        SimpleDateFormat s = new SimpleDateFormat();
        s.applyPattern("yyyy-MM-dd");
        Date date = null;
        try {
            date = s.parse(String.valueOf(tekst));
            System.out.println("date " + date);
        } catch (ParseException ex) {
        }
        ArrayList<Students> listNewName = new ArrayList<>();
        for (Students student : list) {
            if (date.equals(student.getDateOfBirth())) {
                System.out.println("Совпадает год");
                listNewName.add(student);
                break;
            } else {
                System.out.println("Не совпадает год");
            }
        }
        return listNewName;
    }
    
    public ArrayList<Students> getParseGSON() {
        Parser parse = new ParseGSON();
        Root root = parse.parse();     
        list = root.getStudList();
        return list;
    }
    public ArrayList<Students> getParseXML() {
        Parser parsexml = new ParseSAX();
        Root handler = parsexml.parse();
        list = handler.getStudList();
        return list;
    }

}
