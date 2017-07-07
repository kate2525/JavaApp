import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.*;


public class Adapter extends AbstractTableModel {
    
    ArrayList<Students> list = new ArrayList<>();
  

    public Adapter(ArrayList<Students> list) {
        this.list = list;
    }


 


    @Override
    public int getRowCount() {
       return list.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }
    
    public String getColumnName(int col) {
        
        switch (col) {
            case 0:
                return "id";
            case 1:
                return "name";
            case 2:
                return "degree";
            case 3:
                return "dateOfBirth";
            case 4:
                return "rating";
            case 5:
                return "visible";
        }
        return "";
    }

    @Override
    public Object getValueAt(int row, int col) {
      
        Students students = list.get(row);
        switch(col){
            case 0:
               return students.getId();
            case 1:
               return students.getName();
            case 2:
               return students.getDegree();
            case 3:
                SimpleDateFormat s = new SimpleDateFormat();
                s.applyPattern("yyyy-MM-dd");
              return s.format(students.getDateOfBirth());
            case 4:
                return students.getRatingList();
            case 5:
               return students.isVisible(); 
        }
        return "";
    }
    
    
    
}





  