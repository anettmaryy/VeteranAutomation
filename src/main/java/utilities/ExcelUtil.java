package utilities;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ExcelUtil
{

    private static final String filepath=System.getProperty("user.dir")+"/src/test/resources/TestData.xlsx";


    public static Map<String,String> getTestData(String identifier)
    {
        Map<String,String> dataMap=new HashMap<>();
        try
        {
            FileInputStream fis=new FileInputStream(filepath);
            XSSFWorkbook workbook=new XSSFWorkbook(fis);
            XSSFSheet sheet=workbook.getSheet("TestData");
            XSSFRow headerRow=sheet.getRow(0);
            int totalRows=sheet.getPhysicalNumberOfRows();
            for(int i=1;i<totalRows;i++)
            {
                XSSFRow row=sheet.getRow(i);
                XSSFCell identifierCell=row.getCell(0);
                if(identifierCell!=null && identifierCell.getStringCellValue().equalsIgnoreCase(identifier))
                {
                    for(int j=1;j<headerRow.getPhysicalNumberOfCells();j++)
                    {
                        String key=headerRow.getCell(j).getStringCellValue().trim();
                        String value=getCellValue(row.getCell(j));
                        dataMap.put(key,value);
                    }
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading from Excel file: " + filepath, e);
        }
        return dataMap;
    }
    public static String getCellValue(XSSFCell cell)
    {
        if(cell==null)
            return "";
        switch (cell.getCellType())
        {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf((long)cell.getNumericCellValue());
            case BOOLEAN:
                return String.valueOf(cell.getStringCellValue());

            default:return "";
        }
    }



    public static void writeResult(String sheetName,String[] data) throws IOException {
        try {
            FileInputStream fis = new FileInputStream(filepath);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheet(sheetName);

            int rowNum = sheet.getLastRowNum();
            XSSFRow row = sheet.createRow(rowNum+1);
            for (int i = 0; i < data.length; i++) {
                row.createCell(i).setCellValue(data[i]);
            }

            FileOutputStream fos = new FileOutputStream(filepath);
            workbook.write(fos);
            workbook.close();
            System.out.println("Details added into Result Excel sheet");
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }



}
