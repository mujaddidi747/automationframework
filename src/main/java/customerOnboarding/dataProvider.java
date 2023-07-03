package customerOnboarding;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.testng.annotations.DataProvider;
import org.testng.collections.Lists;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class dataProvider {

    static Object[][] data;

    @DataProvider(name = "registrationGroup")
    public static Object[][] gettestDataRegistrationGroup() throws IOException{
        System.out.println("*** Into the gettestDataRegistrationGroup ***");
        String[] noOfSheets = {};
        noOfSheets = Utility.getSheetNames();

        for(int i=0;i<noOfSheets.length;i++){
            if(i == 0){
                data = Utility.ReadSheet(noOfSheets[i]);
            }

            else{
                List<Object[]> result = Lists.newArrayList();
                result.addAll(Arrays.asList(data));
                result.addAll(Arrays.asList(Utility.ReadSheet(noOfSheets[i])));
                data = result.toArray(new Object[result.size()][]);
            }
        }

        return data;

    }



    }
