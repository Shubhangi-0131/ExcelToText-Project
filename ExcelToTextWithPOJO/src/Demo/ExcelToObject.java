package Demo;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelToObject {

    public static void main(String[] args) {
    	
         try
          {
        	 //Class to obtain input bytes from file.
              FileInputStream file = new FileInputStream(new File("C://Demo//EmpWorksheet.xlsx"));
              
             

              //Create Workbook instance holding reference to .xlsx file
              XSSFWorkbook workbook = new XSSFWorkbook(file);

              //Get first/desired sheet from the workbook
              XSSFSheet sheet = workbook.getSheetAt(0);

              ArrayList<NewEmployee> employeeList = new ArrayList<>();
              //I've Header and I'm ignoring header for that I've +1 in loop
              
              for(int i=sheet.getFirstRowNum()+1;i<=sheet.getLastRowNum();i++){
                  NewEmployee e= new NewEmployee();
                  Row ro=sheet.getRow(i);
                  for(int j=ro.getFirstCellNum();j<=ro.getLastCellNum();j++){
                	
                      Cell ce = ro.getCell(j);
                     
                    if(j==0){  
                        //If you have Header in text It'll throw exception because it won't get NumericValue
                        e.setId(ce.getNumericCellValue());
                     
                    }
                    if(j==1){
                        e.setFirstName(ce.getStringCellValue());
                     
                        
                    }
                    if(j==2){
                        e.setLastName(ce.getStringCellValue());
                       
                    }    
                    if(j==3){
                        e.setdateofBirth(ce.getDateCellValue());
                       
                    } 
                
                  }
                  employeeList.add(e);
                 
                  
              }
          //Class used to write chaarter in file
              FileWriter myWriter = new FileWriter("C://Demo//Empdata.txt");
             
             
              for(NewEmployee emp: employeeList){
            	  
                  System.out.println("ID:"+emp.getId()+" firstName:"+emp.getFirstName()+" LastName:"+emp.getLastName()+" dob:"+emp.getdateofBirth());
                  myWriter.write("\n");
                  myWriter.write("ID:"+emp.getId());
                  myWriter.write("\n");
                  myWriter.write("firstName:"+emp.getFirstName());
                  myWriter.write("\n");
                  myWriter.write("LastName:"+emp.getLastName());
                  myWriter.write("\n");
                  myWriter.write("DOB:"+emp.getdateofBirth());
                  
                  myWriter.close();
       
              }
              file.close();
          } 
          catch (Exception e) 
          {
              e.printStackTrace();
          }
         
      }
}