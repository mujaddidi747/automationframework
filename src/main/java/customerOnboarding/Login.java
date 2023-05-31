package customerOnboarding;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class Login {


    @BeforeMethod
    public void setup() throws InterruptedException {


        String url = String.valueOf(playwrightGenerics.page.navigate("********"));
       // assert url.equalsIgnoreCase("http://10.11.11.75/");

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

        if (customerType.equalsIgnoreCase) {

            CustomerOnboarding.onBoarding(dataValues[0], dataValues[1],
                    dataValues[2], dataValues[3], dataValues[4], dataValues[5],
                    dataValues[6], dataValues[7], dataValues[8], dataValues[9],
                    dataValues[10], dataValues[11], dataValues[12],
                    dataValues[13], dataValues[14], dataValues[15],
                    dataValues[16]);

        }



        else if ) {

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


        else if (customerType.equalsIgnoreCase) {

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
