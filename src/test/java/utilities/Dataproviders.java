package utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class Dataproviders {
    //Dataprovider 1

    @DataProvider(name="Logindata")
    public String[][] getdata() throws IOException {
        String path=".\\testdata\\opencart_logindata.xlsx";//taking excel file from testdata
        Excelutility xlutil=new Excelutility(path);//createing and object for excelutility

        int totalrows=xlutil.GetRowCount("Sheet1");
        int totalcells= xlutil.GetCellCount("Sheet1",1);

        String Logindata[][]=new String[totalrows][totalcells];//created 2 dimesional array which can store value

        for (int i=1;i<=totalrows;i++){
            for (int j=0;j<totalcells;j++){
                Logindata[i-1][j]=xlutil.GetCellData("Sheet1",i,j);
            }
        }
        return Logindata;
    }
    //dataprovider 2
}
