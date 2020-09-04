package dataDriven;

import common.WebAPI;
import databases.ConnectToSqlDB;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import utility.DataReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataSource {
    public static ConnectToSqlDB connectToSqlDB = new ConnectToSqlDB();
    public static DataReader excelReader = new DataReader();
    public static WebAPI webAPI = new WebAPI();


    //
    public static List<String> getItemValue() {
        List<String> itemsList = new ArrayList<String>();
        itemsList.add("headphone");
        itemsList.add("iphone 8 plus");
        itemsList.add("iphone x");
        itemsList.add("iphone 11 pro max");
        return itemsList;
    }
    //insert data from  a class to database to store it
    public static void insertDataIntoDB(){
        List<String> list = getItemValue();
        connectToSqlDB = new ConnectToSqlDB();
        connectToSqlDB.insertDataFromArrayListToSqlTable(list,"itemsForATNT","items");

    }

    //read the data from database and later search on ATNT
    public static List<String> getItemsListFromDB() throws Exception, IOException, SQLException, ClassNotFoundException {
        List<String> list = new ArrayList<>();
        list = connectToSqlDB.readDataBase("itemsForATNT", "items");
        return list;
    }


    //search  data from Excel file
    public static List<String> getItemsListFromExcel() throws Exception, IOException, SQLException, ClassNotFoundException{
        String path = "../ATNT/DataTest/mentoringATnT.xlsx";
        String[] myStringArray = excelReader.fileReader2(path, 0);
        for(int i=1;i<myStringArray.length; i++)
            System.out.println(myStringArray[i] + " ");
        ArrayList<String> list = new ArrayList<String>();
        // Using add() method to add elements in array_list
        //System.out.println();
        for (int i = 0; i < myStringArray.length; i++) {
            list.add(myStringArray[i]);
            //System.out.print(list.get(i+1) + " ");
        }
        return list;
    }



    public static String getCellValue(String xl, String Sheet, int r, int c) {
        try {
            FileInputStream fis = new FileInputStream(xl);
            Workbook wb = WorkbookFactory.create(fis);
            Cell cell = wb.getSheet(Sheet).getRow(r).getCell(c);
            return cell.getStringCellValue();
        } catch (Exception e) {
            return "";
        }
    }

    public static int getRowCount (String xl, String Sheet) {
        try {
            FileInputStream fis = new FileInputStream(xl);
            Workbook wb = WorkbookFactory.create(fis);
            return wb.getSheet(Sheet).getLastRowNum();
        } catch (Exception e) {
            return 0;
        }

    }




}
