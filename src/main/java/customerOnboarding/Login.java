package customerOnboarding;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class Login {


    @BeforeMethod
    public void setup() throws InterruptedException {


        String url = String.valueOf(playwrightGenerics.page.navigate("*********"));


        playwrightGenerics.page.locator("//*[@id='user']").fill("**********");
        playwrightGenerics.page.locator("//*[@id='password']").fill("******");

        playwrightGenerics.page.locator("//*[@id='consumerForm']/li[3]/table/tbody/tr/td[1]/input")
                .click();


    }

    @Test(dataProvider = "registrationGroup", dataProviderClass = dataProvider.class)
    public static void registrationSelectionFunction(String dataValues[]) throws InterruptedException, IOException {

        System.out.println("HI I AM AUTOMATING CUSTOMER ONBOARDING WITH PLAYWRIGHT");

        System.out.println("*** Into the CustomerRegistration ***");
        System.out.println("length of string : " + dataValues.length);

        String customerType = dataValues[dataValues.length - 1];

        System.out.println("*** Into the CustomerRegistration ***"
                + customerType);

        // calling classes


        CustomerOnboarding cstOnboard = new CustomerOnboarding();

        playwrightGenerics.page.wait(1000);

        if (customerType.equalsIgnoreCase("L0")
                || customerType.equalsIgnoreCase("L1 Corporate SimSim User")
                || customerType.equalsIgnoreCase("L1 Guest Corporate SimSim User")
                || customerType.equalsIgnoreCase("L0 BVS CORPORATE USER")
                || customerType.equalsIgnoreCase("Remote Zero - Digital Transaction")
                || customerType.equalsIgnoreCase("Remote Zero - Corporate Sim Sim User")
                || customerType.equalsIgnoreCase("Guest D/C Block User")
                || customerType.equalsIgnoreCase("L1")
                || customerType.equalsIgnoreCase("L0 BVS User")
                || customerType.equalsIgnoreCase("Merchant Headquarter")) {

            CustomerOnboarding.onBoarding(dataValues[0], dataValues[1],
                    dataValues[2], dataValues[3], dataValues[4], dataValues[5],
                    dataValues[6], dataValues[7], dataValues[8], dataValues[9],
                    dataValues[10], dataValues[11], dataValues[12],
                    dataValues[13], dataValues[14], dataValues[15],
                    dataValues[16]);

        }



        else if( customerType.equalsIgnoreCase("L2-Individual")
                || customerType.equalsIgnoreCase("L2 Existing Customer")
                || customerType.equalsIgnoreCase("L2-Individual-10000")
                || customerType.equalsIgnoreCase("L2-Individual-250000")
                || customerType.equalsIgnoreCase("L2-Individual-500000")
                || customerType.equalsIgnoreCase("L2-Individual-99999")
                || customerType.equalsIgnoreCase("L2 Individual Staff")
                || customerType.equalsIgnoreCase("L2 Individual Staff-100000")
                || customerType.equalsIgnoreCase("L2 Individual Staff-2500000")
                || customerType.equalsIgnoreCase("L2 Individual Staff-700000")) {

            cstOnboard.onBoardingL2Group(dataValues[0], dataValues[1],
                    dataValues[2], dataValues[3], dataValues[4], dataValues[5],
                    dataValues[6], dataValues[7], dataValues[8], dataValues[9],
                    dataValues[10], dataValues[11], dataValues[12],
                    dataValues[13], dataValues[14], dataValues[15],
                    dataValues[16], dataValues[17], dataValues[18],
                    dataValues[19], dataValues[20], dataValues[21],
                    dataValues[22], dataValues[23], dataValues[24],
                    dataValues[25], dataValues[26], dataValues[27],
                    dataValues[28], dataValues[29], dataValues[30],
                    dataValues[31]);

        }


        else if (customerType.equalsIgnoreCase("Corporate Account Master Wallet")
                || customerType.equalsIgnoreCase("Corporate Sim Sim Account User")
                || customerType.equalsIgnoreCase("Agent FINJA")
                || customerType.equalsIgnoreCase("Agent Finca")) {

            cstOnboard.onboardingCorporateGroup(dataValues[0],
                    dataValues[1], dataValues[2], dataValues[3], dataValues[4],
                    dataValues[5], dataValues[6], dataValues[7], dataValues[8],
                    dataValues[9], dataValues[10], dataValues[11],
                    dataValues[12], dataValues[13], dataValues[14],
                    dataValues[15], dataValues[16], dataValues[17],
                    dataValues[18], dataValues[19], dataValues[20],
                    dataValues[21], dataValues[22], dataValues[23],
                    dataValues[24], dataValues[25], dataValues[26],
                    dataValues[27], dataValues[28], dataValues[29],
                    dataValues[30]);

        }



    }


    @AfterMethod
    public static void testBrowserClose() {

        playwrightGenerics.playwright.close();

    }


}
