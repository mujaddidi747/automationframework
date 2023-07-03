package customerOnboarding;

import com.microsoft.playwright.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static customerOnboarding.playwrightGenerics.page;

public class Utility {
    static Playwright playwright = Playwright.create();
    static Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

    // static BrowserContext context = browser.newContext();

    static FileInputStream file = null;
    static Workbook book;
    static Sheet sheet;
    public static String TestData_Sheet_Path = "D:\\MobiliserCustomerOnboardingAutomation\\customerOnboarding.xlsx";

    Login login = new Login();

    ///////////////////////////////////////////////////////

    ///////////////////////////////////////////////////////

    public static synchronized void getActionsObject_submenu_homepage(Locator submenu, Locator submenu1) throws InterruptedException {

    //    submenu = page.locator("//*[@id=\"pageWrap\"]/div[3]/ul[1]/span/span[6]/li/span");
        submenu = page.getByText("CUSTOMER CARE");
        submenu.hover();

        //  submenu.selectOption(setDropdown.setLabel("CUSTOMER REGISTRATION"));

        submenu1 = page.getByText("CUSTOMER REGISTRATION").last();

        synchronized (playwright) {
            if(submenu1.isEnabled())
            submenu1.click();
        }

    }

    public static String[] getSheetNames() {

        System.out.println("*** Into the Sheets Name ***");


        try {
            file = new FileInputStream(TestData_Sheet_Path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            book = WorkbookFactory.create(file);
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Get No Of Sheets : " + book.getNumberOfSheets());

        String[] strName = new String[book.getNumberOfSheets()];

        for (int i = 0; i < book.getNumberOfSheets(); i++) {

            strName[i] = book.getSheetAt(i).getSheetName();
            System.out.println(strName[i]);
        }

        return strName;
    }

    public static Object[][] ReadSheet(String sheetName) throws IOException {

        System.out.println("*** Into the ReadFile ***");

        Object[][] data = null;

        sheet = book.getSheet(sheetName);

        data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

        System.out.println("Sheet Total Records:" + sheet.getLastRowNum());

        try {

            for (int j = 0; j < sheet.getLastRowNum(); j++) {
                for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {

                    if ((data[j][k]) == null) {
                        //we have to add check here that if the array value contains the null values delete the array
                        data[j][k] = sheet.getRow(j + 1).getCell(k).toString();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }


   /* public static void selectDate(String month_year, String select_day) throws InterruptedException {

        page.setDefaultTimeout(3500);
        page.locator(".ui-datepicker-prev ui-corner-all");

      //  page.click("ui-datepicker-div");

        String randomDateSelector = getRandomDateSelector();
        page.click(randomDateSelector);


    }*/

    private static void selectDate() {


    }

    public static void riskTypes() {

        Locator AccountOrganizationType = playwrightGenerics.page.locator("#id6e");

        AccountOrganizationType.selectOption("Low Risk");

        Locator PoliticallyExposedPerson = playwrightGenerics.page.locator("#id6f");
        PoliticallyExposedPerson.selectOption("Low Risk");

        Locator CustomerOwnership = playwrightGenerics.page.locator("#id70");
        CustomerOwnership.selectOption("Low Risk");

        Locator CustomerRefuse = playwrightGenerics.page.locator("#id71");
        CustomerRefuse.selectOption("Low Risk");

        Locator CustomerDealing = playwrightGenerics.page.locator("#id72");
        CustomerDealing.selectOption("Low Risk");

        Locator IsResident = playwrightGenerics.page.locator("#id73");
        IsResident.selectOption("Low Risk");

        Locator IsActualOwner = playwrightGenerics.page.locator("#id74");
        IsActualOwner.selectOption("Low Risk");

        Locator IsCustomerDirector = playwrightGenerics.page.locator("#id75");
        IsCustomerDirector.selectOption("Low Risk");

        Locator IsCustomerHouseWife = playwrightGenerics.page.locator("#id76");
        IsCustomerHouseWife.selectOption("Low Risk");

        Locator IsMinorAccount = playwrightGenerics.page.locator("#id77");
        IsMinorAccount.click();
        IsMinorAccount.selectOption("High Risk");

        Locator IsHighRiskBusiness = playwrightGenerics.page.locator("#id78");
        IsHighRiskBusiness.selectOption("Low Risk");

        Locator IsClientProfile = playwrightGenerics.page.locator("#id79");
        IsClientProfile.selectOption("Low Risk");

        Locator IsComplexStructure = playwrightGenerics.page.locator("#id7a");
        IsComplexStructure.selectOption("High Risk");

        Locator IsMailInstruction = playwrightGenerics.page.locator("#id7b");
        IsMailInstruction.selectOption("High Risk");

        //RISK RATING
        Locator RiskRating = playwrightGenerics.page.locator("#riskRating");
        RiskRating.selectOption("Low Risk");

    }


}
