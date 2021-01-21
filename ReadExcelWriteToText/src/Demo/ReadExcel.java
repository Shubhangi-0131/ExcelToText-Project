package Demo;


import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.Iterator;

//Apache POI Java Library used to work with excel 
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
 
public class ReadExcel {
 
    public static void main( String [] args ) {
      Writer writer = null;
        try {
   
             InputStream input = new BufferedInputStream(
             new FileInputStream("C:\\Demo\\Test.xls"));
            POIFSFileSystem fs = new POIFSFileSystem( input );
            
            //Create Workbook instance holding reference to .xls file
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            
          //Get first/desired sheet from the workbook
            HSSFSheet sheet = wb.getSheetAt(0); 
         
            //create text file
            File file = new File("C:\\Demo\\Test.txt");  
            
            writer = new BufferedWriter(new FileWriter(file));
            //Iterate all the row in current sheet
            Iterator rows = sheet.rowIterator();
            while( rows.hasNext() ) {  
                HSSFRow row = (HSSFRow) rows.next();
                System.out.println("\n");
                //Iterate all the cell of current row
                Iterator cells = row.cellIterator();
               
                   writer.write("(");
                while( cells.hasNext() ) {
                     
                    HSSFCell cell = (HSSFCell) cells.next();
                    //Checking for numeric value in cell
                    if(HSSFCell.CELL_TYPE_NUMERIC==cell.getCellType())
                    {
                    	
                    System.out.print( cell.getNumericCellValue()+"     "/*+cell.getColumnIndex() */);
                    if(cell.getColumnIndex()==4) {
                    	
                    writer.write(String.valueOf(cell.getNumericCellValue()));
                    }
                    else
                    
                     writer.write(String.valueOf(cell.getNumericCellValue()+","));
                    }
                    else
                    	//Checking string value in cell
                    if(HSSFCell.CELL_TYPE_STRING==cell.getCellType()) {
                        System.out.print( cell.getStringCellValue()+"     " );
                        writer.write("'"+cell.getStringCellValue()+"',");
                    }
                   
                       else
                        	//Checking blank value in cell
                            if(HSSFCell.CELL_TYPE_BLANK==cell.getCellType())
                            {
                                System.out.print( "BLANK     " );
                            }
                                else
                            System.out.print("Unknown cell type");
             
                   
                }
                 
                writer.write(");"+"\n");
            }
           
             
        } catch ( IOException ex ) {
            ex.printStackTrace();
        } finally {             try {                 if (writer != null) {                     writer.close();                 }             } catch (IOException e) {                 e.printStackTrace();             }         }
    }
     
}