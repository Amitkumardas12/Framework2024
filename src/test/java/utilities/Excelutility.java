package utilities;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class Excelutility {
    public FileInputStream fi;
    public FileOutputStream fo;
    public XSSFWorkbook workbook;
    public XSSFSheet sheet;
    public XSSFRow row;
    public XSSFCell cell;
    public CellStyle style;

    String path;
    public Excelutility(String path){
        this.path=path;
    }

    public int GetRowCount(String sheetname) throws IOException {
        fi=new FileInputStream(path);
        workbook=new XSSFWorkbook(fi);
        sheet=workbook.getSheet(sheetname);
        int rowcount=sheet.getLastRowNum();
        workbook.close();
        fi.close();
        return rowcount;
    }
    public int GetCellCount(String sheetname,int rownum) throws IOException {
        fi=new FileInputStream(path);
        workbook=new XSSFWorkbook(fi);
        sheet=workbook.getSheet(sheetname);
        row=sheet.getRow(rownum);
        int cellcount=row.getLastCellNum();
        workbook.close();
        fi.close();
        return cellcount;
    }
    public String GetCellData(String sheetname,int rownum,int cellnum) throws IOException {
        fi=new FileInputStream(path);
        workbook=new XSSFWorkbook(fi);
        sheet=workbook.getSheet(sheetname);
        row=sheet.getRow(rownum);
        cell=row.getCell(cellnum);

        DataFormatter formatter=new DataFormatter();
        String Data;
        try{
            Data=formatter.formatCellValue(cell);//return the formated value of cell as string regardless
        }
        catch (Exception e){
            Data=" ";
        }
        workbook.close();
        fi.close();
        return Data;
    }

    public void SetCellData(String sheetname,int rownum,int cellnum,String data) throws IOException {
        File xlfile=new File(path);
        if(!xlfile.exists()) //if file not exist then create new file
        {
            workbook=new XSSFWorkbook();
            fo=new FileOutputStream(path);
            workbook.write(fo);
        }
        fi=new FileInputStream(path);
        workbook=new XSSFWorkbook(fi);

        if (workbook.getSheetIndex(sheetname)==-1)// if sheet not exist then create new sheet
            workbook.createSheet(sheetname);
        sheet=workbook.getSheet(sheetname);
        if (sheet.getRow(rownum)==null)
            sheet.createRow(rownum);
        row=sheet.getRow(rownum);
        cell=row.createCell(cellnum);
        cell.setCellValue(data);
        fo=new FileOutputStream(path);
        workbook.write(fo);
        workbook.close();
        fi.close();
        fo.close();
    }
    public void FillGreenColour(String sheetname,int rownum, int cellnum) throws IOException {
        fi=new FileInputStream(path);
        workbook=new XSSFWorkbook(fi);
        sheet=workbook.getSheet(sheetname);
        row=sheet.getRow(rownum);
        cell=row.getCell(cellnum);
        style=workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cell.setCellStyle(style);
        workbook.write(fo);
        workbook.close();
        fi.close();
        fo.close();
    }
    public void FillRedColour(String sheetname,int rownum, int cellnum) throws IOException {
        fi=new FileInputStream(path);
        workbook=new XSSFWorkbook(fi);
        sheet=workbook.getSheet(sheetname);
        row=sheet.getRow(rownum);
        cell=row.getCell(cellnum);

        style=workbook.createCellStyle();

        style.setFillForegroundColor(IndexedColors.RED.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        cell.setCellStyle(style);
        workbook.write(fo);
        workbook.close();
        fi.close();
        fo.close();
    }

}
