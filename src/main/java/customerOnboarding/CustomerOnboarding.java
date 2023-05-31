package customerOnboarding;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class CustomerOnboarding {


    static Date d = new Date();
    static SimpleDateFormat formatter = new SimpleDateFormat("MMM-dd-yyyy");
    static String date = formatter.format(d);
    static String[] splitter = date.split("-");
    static String month_year = splitter[0];
    static String day = splitter[1];
    // Select selectCustomerType=null;

    static ElementHandle submenu;
    static ElementHandle submenu1;

    static SelectOption setDropdown = new SelectOption();

    public static boolean onBoarding(String accountTitle, String accountNumber, String nVerification, String motherName,
                                     String fatherName, String POB, String gender, String nationality, String identityType, String pProvince, String mProvince, String identityNumber, String permanentAddress,
                                     String permanentCity, String mailingAddress, String mailingCity, String customerType) throws InterruptedException, IOException {


        Utility.getActionsObject_submenu_homepage(submenu, submenu1);

        //dropdown/customer type selection

        try {
            Locator locator = (Locator) playwrightGenerics.page.locator("#id7");
            locator.selectOption(setDropdown.setLabel(customerType));
            System.out.println("Selected Customer Type : " + locator);

        } catch (Exception e) {

            Locator locator = (Locator) playwrightGenerics.page.locator("#id7");
            locator.selectOption(setDropdown.setLabel(customerType));
            System.out.println("Selected Customer Type : " + locator);
        }


        if (playwrightGenerics.page.locator("#id7").selectOption(customerType).equals(("L0"))) {

            onBoardingcustomerl0(accountTitle, accountNumber, nVerification, motherName, fatherName, POB, gender, nationality,
                    identityType, pProvince, mProvince, identityNumber, permanentAddress, permanentCity, mailingAddress, mailingCity);

        } else if (playwrightGenerics.page.locator("#id7").selectOption(customerType).equals("L1 Corporate SimSim User")) {
            OnBoardingL1CorporateUser(accountTitle, accountNumber, nVerification, motherName, fatherName, POB, gender, nationality,
                    identityType, pProvince, mProvince, identityNumber, permanentAddress, permanentCity, mailingAddress, mailingCity);
        } else if (playwrightGenerics.page.locator("#id7").selectOption(customerType).equals("L1 Guest Corporate SimSim User")) {

            OnBoardingL1GuestCorporateSimSim(accountTitle, accountNumber, nVerification, motherName, fatherName, POB, gender, nationality, identityType, pProvince, mProvince, identityNumber, permanentAddress, permanentCity, mailingAddress, mailingCity);
        } else if (playwrightGenerics.page.locator("#id7").selectOption(customerType).equals("Remote Zero - Digital Transaction")) {

            onBoardingRemoteZeroDigitalTransaction(accountTitle, accountNumber, nVerification, motherName, fatherName, POB, gender, nationality, identityType,
                    pProvince, mProvince, identityNumber, permanentAddress, permanentCity, mailingAddress, mailingCity);
        } else if (playwrightGenerics.page.locator("#id7").selectOption(customerType).equals("L0 BVS CORPORATE USER")) {
            onBoardingL0bvsCorporateUser(accountTitle, accountNumber, nVerification, motherName, fatherName, POB, gender, nationality, identityType, pProvince, mProvince, identityNumber,
                    permanentAddress, permanentCity, mailingAddress, mailingCity);
        } else if (playwrightGenerics.page.locator("#id7").selectOption(customerType).equals("L1")) {
            onBoardingL1(accountTitle, accountNumber, nVerification, motherName, fatherName, POB, gender, nationality, identityType,
                    pProvince, mProvince, identityNumber, permanentAddress, permanentCity, mailingAddress, mailingCity);
        } else if (playwrightGenerics.page.locator("#id7").selectOption(customerType).equals("Remote Zero - Corporate Sim Sim User")) {
            onBoardingRemoteZeroCorporateSimSimUser(accountTitle, accountNumber, nVerification, motherName, fatherName, POB, gender, nationality,
                    identityType, pProvince, mProvince, identityNumber, permanentAddress, permanentCity, mailingAddress, mailingCity);
        } else if (playwrightGenerics.page.locator("#id7").selectOption(customerType).equals("Merchant Headquarter")) {

            merchantHeadquarter(accountTitle, accountNumber, nVerification, motherName, fatherName,
                    POB, gender, nationality, identityType, pProvince, mProvince, identityNumber, permanentAddress, permanentCity,
                    mailingAddress, mailingCity);

        } else if (playwrightGenerics.page.locator("#id7").selectOption(customerType).equals("Guest D/C Block User")) {

            onBoardingGuestDCUser(accountTitle, accountNumber, nVerification, motherName, fatherName, POB, gender, nationality,
                    identityType, pProvince, mProvince, identityNumber, permanentAddress, permanentCity, mailingAddress, mailingCity);

        } else if (playwrightGenerics.page.locator("#id7").selectOption(customerType).equals("Remote Zero - Corporate Sim Sim User")) {

            onBoardingRemoteZeroCorporateSimSimUser(accountTitle, accountNumber, nVerification, motherName, fatherName, POB, gender
                    , nationality, identityType, pProvince, mProvince, identityNumber, permanentAddress, permanentCity, mailingAddress, mailingCity);

        }

        return true;
    }

    private static boolean
    onBoardingcustomerl0(String accountTitle, String accountNumber, String nVerification, String motherName, String fatherName,
                         String pob, String gender, String nationality, String identityType, String pProvince, String mProvince,
                         String identityNumber, String permanentAddress, String permanentCity, String mailingAddress, String mailingCity) {


        Locator title = playwrightGenerics.page.locator("/html/body/div[1]/div[3]/div[4]/div/div[2]/div[2]/form/div[3]/div[1]/div[2]/input");
        title.fill(accountTitle);
        assert accountTitle.matches("^[a-zA-Z]+$");

        Locator AccountNumber = playwrightGenerics.page.locator("/html/body/div[1]/div[3]/div[4]/div/div[2]/div[2]/form/div[3]/div[1]/div[3]/div/input\")).sendKeys(accountNumber");
        AccountNumber.fill(accountNumber);
        assert accountNumber.matches("^(\\\\+){0,1}[0-9]+$");

        Locator MotherName = playwrightGenerics.page.locator("#motherName");
        MotherName.fill(motherName);


        Locator FatherName = playwrightGenerics.page.locator("#fatherHusbandName");
        FatherName.fill(fatherName);

        Locator placeofBirth = playwrightGenerics.page.locator("#placeOfBirth");
        placeofBirth.fill(pob);

        Locator IdentityNumber = playwrightGenerics.page.locator("#identityValue");
        IdentityNumber.fill(identityNumber);

        Locator PAddress = playwrightGenerics.page.locator("#permanentAddress");
        PAddress.fill(permanentAddress);

        Locator PCity = playwrightGenerics.page.locator("#permanentCity");
        PCity.fill(permanentCity);

        Locator MailingAddress = playwrightGenerics.page.locator("#mailingOrBusinessAddress");
        MailingAddress.fill(mailingAddress);


        Locator MailingCity = playwrightGenerics.page.locator("#mailingOrBusinessCity");
        MailingCity.fill(mailingCity);


        Locator verificationType = playwrightGenerics.page.locator("/html/body/div[1]/div[3]/div[4]/div/div[2]/div[2]/form/div[3]/div[1]/div[5]/select");
        verificationType.selectOption(setDropdown.setLabel(nVerification));
        System.out.println("Selected Customer Type : " + nVerification);

        Locator Gender = playwrightGenerics.page.locator("#kvGender");
        Gender.selectOption(new SelectOption().setLabel(gender));

        Locator Nationality = playwrightGenerics.page.locator("nationality2");
        Nationality.selectOption(setDropdown.setLabel(nationality));

        Locator Identity = playwrightGenerics.page.locator("#kvIdentityType");
        Identity.selectOption(setDropdown.setLabel(identityType));

        Locator Education = playwrightGenerics.page.locator("#education");
        Education.selectOption(setDropdown.setLabel(""));

        Locator Province = playwrightGenerics.page.locator("permanentState");
        Province.selectOption(setDropdown.setLabel(pProvince));

        Locator MailingProvince = playwrightGenerics.page.locator("mailingOrBusinessState");
        MailingProvince.selectOption(setDropdown.setLabel(""));

        Locator InfoMode = playwrightGenerics.page.locator("#id20");
        InfoMode.selectOption(setDropdown.setLabel(""));

        try {
            playwrightGenerics.page.locator("#birthDate").click();
            ;
            Thread.sleep(500);
            Utility.selectDate(month_year, day);

            Thread.sleep(500);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }

        try {
            playwrightGenerics.page.locator("#cnicExpiryDate").click();
            Thread.sleep(500);
            Utility.selectDate(month_year, day);
            Thread.sleep(500);

        } catch (InterruptedException e) {

            e.printStackTrace();
        }

        try {
            playwrightGenerics.page.locator("#issuanceDate").click();
            Thread.sleep(500);
            Utility.selectDate(month_year, day);
            Thread.sleep(500);

        } catch (InterruptedException e) {

            e.printStackTrace();
        }

        playwrightGenerics.page.locator("/html/body/div[1]/div[3]/div[4]/div/div[2]/div[2]/form/div[4]/div/div/input").click();
        playwrightGenerics.page.locator("/html/body/div/div[3]/div[4]/div/div[2]/div/div/form/div[4]/div/input[1]").click();


        return true;
    }


    public static boolean OnBoardingL1CorporateUser(String accountTitle, String accountNumber, String nVerification, String motherName,
                                                    String fatherName, String POB, String gender, String nationality, String identityType, String pProvince, String mProvince,
                                                    String identityNumber, String permanentAddress,
                                                    String permanentCity, String mailingAddress,
                                                    String mailingCity) throws InterruptedException, IOException {

        onBoardingcustomerl0(accountTitle, accountNumber, nVerification, motherName, fatherName, POB, gender, nationality, identityType, pProvince, mProvince, identityNumber, permanentAddress, permanentCity, mailingAddress, mailingCity);

        playwrightGenerics.page.locator("#employerName").fill("AutoSoft Dynamics");
        ElementHandle OtherCheckBox = (ElementHandle) playwrightGenerics.page.locator("/html/body/div[1]/div[3]/div[4]/div/div[2]/div[2]/form/div[3]/div[6]/div[4]/div[3]/div/div/div[1]/div/table/tbody/tr[2]/td/input");
        boolean isSelected = OtherCheckBox.isChecked();

        if (isSelected) {
            playwrightGenerics.page.locator("#sourcesOfIncomeCBOther").fill("absar");
        } else {
            playwrightGenerics.page.locator("/html/body/div[1]/div[3]/div[4]/div/div[2]/div[2]/form/div[3]/div[6]/div[4]/div[3]/div/div/div[1]/div/table/tbody/tr[1]/td/input").click();
        }

        return true;
    }


    public static boolean OnBoardingL1GuestCorporateSimSim(String accountTitle, String accountNumber,
                                                           String nVerification, String motherName, String fatherName, String POB, String gender, String nationality, String identityType, String pProvince, String mProvince,
                                                           String identityNumber, String permanentAddress, String permanentCity, String mailingAddress, String mailingCity) throws IOException {

        onBoardingcustomerl0(accountTitle, accountNumber, nVerification, motherName, fatherName, POB, gender,
                nationality, pProvince, mProvince, identityType, identityNumber, permanentAddress, permanentCity, mailingAddress, mailingCity);

        playwrightGenerics.page.locator("#employerName").fill("AutoSoft Dynamics");

        ElementHandle OtherCheckBox = (ElementHandle) playwrightGenerics.page.locator("/html/body/div[1]/div[3]/div[4]/div/div[2]/div[2]/form/div[3]" +
                "/div[6]/div[4]/div[3]/div/div/div[1]/div/table/tbody/tr[2]/td/input");
        boolean isSelected = OtherCheckBox.isChecked();

        if (isSelected) {
            playwrightGenerics.page.locator("#sourcesOfIncomeCBOther").fill("xyz");
        } else {
            playwrightGenerics.page.locator("/html/body/div[1]/div[3]/div[4]/div/div[2]/" +
                    "div[2]/form/div[3]/div[6]/div[4]/div[3]/div/div/div[1]/div/table/tbody/tr[1]/td/input").click();
        }

        return true;
    }

    public static boolean onBoardingRemoteZeroDigitalTransaction(String accountTitle, String accountNumber, String nVerification, String motherName,
                                                                 String fatherName, String POB, String gender, String nationality, String identityType, String pProvince,
                                                                 String mProvince, String identityNumber, String permanentAddress, String permanentCity, String mailingAddress, String mailingCity) throws IOException {
        onBoardingcustomerl0(accountTitle, accountNumber, nVerification, motherName, fatherName, POB, gender, nationality,
                identityType, pProvince, mProvince, identityNumber, permanentAddress, permanentCity, mailingAddress, mailingCity);
        return true;

    }

    public static boolean onBoardingL0bvsCorporateUser(String accountTitle,
                                                       String accountNumber, String nVerification, String motherName,
                                                       String fatherName, String POB, String gender, String nationality, String identityType, String pProvince, String mProvince, String identityNumber, String permanentAddress,
                                                       String permanentCity, String mailingAddress, String mailingCity) throws IOException {

        onBoardingcustomerl0(accountTitle, accountNumber, nVerification, motherName, fatherName, POB, gender, nationality, identityType, pProvince, mProvince, identityNumber, permanentAddress, permanentCity, mailingAddress, mailingCity);
        return true;
    }

    public static boolean onBoardingL1(String accountTitle, String accountNumber, String nVerification, String motherName, String fatherName, String POB, String gender,
                                       String nationality, String identityType, String pProvince, String mProvince,
                                       String identityNumber, String permanentAddress, String permanentCity, String mailingAddress, String mailingCity) throws IOException {

        onBoardingcustomerl0(accountTitle, accountNumber, nVerification, motherName, fatherName, POB, gender,
                nationality, identityType, pProvince, mProvince, identityNumber, permanentAddress, permanentCity, mailingAddress, mailingCity);
        return true;

    }

    public static boolean onBoardingRemoteZeroCorporateSimSimUser(String accountTitle, String accountNumber, String nVerification, String motherName, String fatherName, String POB, String gender,
                                                                  String nationality, String identityType, String pProvince, String mProvince, String identityNumber, String permanentAddress, String permanentCity, String mailingAddress, String mailingCity) throws IOException {

        onBoardingcustomerl0(accountTitle, accountNumber, nVerification, motherName, fatherName, POB, gender, nationality,
                identityType, pProvince, mProvince, identityNumber, permanentAddress, permanentCity, mailingAddress, mailingCity);
        return true;

    }

    public static boolean merchantHeadquarter(String accountTitle, String accountNumber, String nVerification,
                                              String motherName, String fatherName, String POB, String gender, String nationality, String identityType, String pProvince, String mProvince,
                                              String identityNumber, String permanentAddress,
                                              String permanentCity, String mailingAddress, String mailingCity) throws IOException {

        onBoardingcustomerl0(accountTitle, accountNumber, nVerification, motherName, fatherName, POB, gender, nationality,
                identityType, pProvince, mProvince, identityNumber, permanentAddress, permanentCity, mailingAddress, mailingCity);

        return true;

    }

    public static boolean onBoardingGuestDCUser(String accountTitle, String accountNumber, String nVerification, String motherName, String fatherName, String POB, String gender,
                                                String nationality, String identityType, String pProvince, String mProvince, String identityNumber, String permanentAddress, String permanentCity, String mailingAddress, String mailingCity) throws IOException {

        onBoardingcustomerl0(accountTitle, accountNumber, nVerification, motherName, fatherName, POB, gender, nationality, identityType, pProvince, mProvince, identityNumber, permanentAddress, permanentCity, mailingAddress, mailingCity);
        return true;
    }


    //////////////////// -------- ON BOARDING  L2 GROUP --------------- ///////////////////

    public static boolean onBoardingL2Group(String accountTitle,
                                            String accountNumber, String nVerification, String motherName,
                                            String fatherName, String POB, String gender, String nationality, String identityType, String pProvince, String mProvince, String identityNumber, String permanentAddress,
                                            String permanentCity, String mailingAddress, String mailingCity, String Name, String CNIC, String contactNumber, String residency
            , String address, String ActualOwner, String BenificiaryCNIC, String ExpextedMonthlyNoTransactionCR, String ExpextedMonthlyAmtTransactionDB,
                                            String ExpextedMonthlyAmtTransactionCR, String ExpextedMonthlyNoTransactionDB, String AvgYearlyIncome, String AvgYearlySales, String ntn,
                                            String TaxIdentificationNumber, String customerType) throws InterruptedException, IOException {


        Utility.getActionsObject_submenu_homepage(submenu, submenu1);

        try {
            Locator locator = (Locator) playwrightGenerics.page.locator("#id7");
            locator.selectOption(setDropdown.setLabel(customerType));
            System.out.println("Selected Customer Type : " + locator);

        } catch (Exception e) {

            Locator locator = (Locator) playwrightGenerics.page.locator("#id7");
            locator.selectOption(setDropdown.setLabel(customerType));
            System.out.println("Selected Customer Type : " + locator);
        }

        if (playwrightGenerics.page.locator("#id7").selectOption(setDropdown.setLabel(customerType)).equals("L2 Existing Customer")) {

            onBoardingL2(accountTitle,
                    accountNumber, nVerification, motherName,
                    fatherName, POB, gender, nationality, identityType, pProvince, mProvince, identityNumber, permanentAddress,
                    permanentCity, mailingAddress, mailingCity, Name, CNIC, contactNumber, residency
                    , address, ActualOwner, BenificiaryCNIC, ExpextedMonthlyNoTransactionCR, ExpextedMonthlyAmtTransactionCR,
                    ExpextedMonthlyAmtTransactionDB, ExpextedMonthlyNoTransactionDB, AvgYearlyIncome, AvgYearlySales, ntn,
                    TaxIdentificationNumber);

        }

        return true;
    }


    public static boolean onBoardingL2(String accountTitle,
                                       String accountNumber, String nVerification, String motherName,
                                       String fatherName, String POB, String gender, String nationality, String identityType, String pProvince, String mProvince, String identityNumber, String permanentAddress,
                                       String permanentCity, String mailingAddress, String mailingCity, String Name, String CNIC, String contactNumber, String residency
            , String address, String ActualOwner, String BenificiaryCNIC, String ExpextedMonthlyNoTransactionCR, String ExpextedMonthlyAmtTransactionCR,
                                       String ExpextedMonthlyAmtTransactionDB, String ExpextedMonthlyNoTransactionDB, String AvgYearlyIncome, String AvgYearlySales, String ntn,
                                       String TaxIdentificationNumber) throws IOException {


        Locator typeAccount = (Locator) playwrightGenerics.page.locator("#idd");
        typeAccount.selectOption("");

        Locator PoliticalExposed = (Locator) playwrightGenerics.page.locator(("#id27"));
        PoliticalExposed.selectOption("");

        // Login.driver.findElement(By.id("politicallyExposedComments")).sendKeys(PoliticalComments);

        playwrightGenerics.page.locator("#nextOfKinName").fill(Name);
        //	Assert.assertTrue(accountTitle.matches("^[a-zA-Z\\s]*$"));

        playwrightGenerics.page.locator("#nextOfKinCnic").fill(CNIC);
        //Assert.assertTrue(CNIC.matches("^(?=.*[1-9])[0-9+]{5}(-){1}[0-9+]{7}(-){1}[0-9]{1}$"));

        Locator nextofkinNationality = (Locator) playwrightGenerics.page.locator("#nextOfKinNationality");
        nextofkinNationality.selectOption("PAKISTAN");

        playwrightGenerics.page.locator("#nextOfKinContactNo").fill(contactNumber);

        playwrightGenerics.page.locator("#nextOfKinResidency").fill(residency);

        playwrightGenerics.page.locator("nextOfKinAddress").fill(address);
        //Assert.assertTrue(address.matches("^[0-9]*|^[-0-9a-zA-ZÀ-ÿ .']*$"));

        ElementHandle OccupationType = (ElementHandle) playwrightGenerics.page.locator("#id35");

        Locator occupationType = playwrightGenerics.page.locator("#id35");
        occupationType.selectOption("");

        try {
            Locator purAcc = playwrightGenerics.page.locator("#id46");
            purAcc.selectOption("Loan");
        } catch (Exception e) {
            Locator purAcc = playwrightGenerics.page.locator("#id46");
            purAcc.selectOption("Loan");
        }

        Locator BeneficialAccOwner = playwrightGenerics.page.locator("#id4d");
        BeneficialAccOwner.selectOption(setDropdown.setLabel("No"));

        Locator Relationship = playwrightGenerics.page.locator("#id32");
        Relationship.selectOption(setDropdown.setLabel("Brother"));

        playwrightGenerics.page.locator("#actualBeneficialOwner").fill(ActualOwner);
        //Assert.assertTrue(accountTitle.matches("^[a-zA-Z\\s]*$"));

        Locator Relation = playwrightGenerics.page.locator("#id51");
        Relation.selectOption(setDropdown.setLabel("Brother"));

        playwrightGenerics.page.locator("#cnicBeneficial").fill(BenificiaryCNIC);
        //Assert.assertTrue(CNIC.matches("^(?=.*[1-9])[0-9+]{5}(-){1}[0-9+]{7}(-){1}[0-9]{1}$"));

        Locator TxnMode = playwrightGenerics.page.locator("#modeOfTransaction");
        TxnMode.selectOption(setDropdown.setLabel("All"));

        playwrightGenerics.page.locator("#expectedCredit").fill(ExpextedMonthlyNoTransactionCR);
        //Assert.assertTrue(ExpextedMonthlyNoTransactionCR.matches("^[0-9]{1,12}$"));

        playwrightGenerics.page.locator("#monthlyExpectedWithdrawal").fill(ExpextedMonthlyAmtTransactionCR);
        //Assert.assertTrue(ExpextedMonthlyNoTransactionCR.matches("^[0-9]{1,12}$"));

        playwrightGenerics.page.locator("#expectedDebit").fill(ExpextedMonthlyAmtTransactionDB);
        //Assert.assertTrue(ExpextedMonthlyNoTransactionCR.matches("^[0-9]{1,12}$"));

        playwrightGenerics.page.locator("#monthlyExpectedDeposit").fill(ExpextedMonthlyNoTransactionDB);
        //Assert.assertTrue(ExpextedMonthlyNoTransactionCR.matches("^[0-9]{1,12}$"));

        playwrightGenerics.page.locator("#avergaeYearlyIncome").fill(AvgYearlyIncome);
        //Assert.assertTrue(ExpextedMonthlyNoTransactionCR.matches("^[0-9]{1,12}$"));

        playwrightGenerics.page.locator("#averageYearlySales").fill(AvgYearlySales);
        //Assert.assertTrue(ExpextedMonthlyNoTransactionCR.matches("^[0-9]{1,12}$"));

        playwrightGenerics.page.locator("ntn").fill(ntn);

        Locator TypeOfCustomer = playwrightGenerics.page.locator("#typeOfIncomingCustomer");

        TypeOfCustomer.selectOption(setDropdown.setLabel("Marketed"));

        Locator HearingMedium = playwrightGenerics.page.locator("#bankHearingMedium");
        HearingMedium.selectOption(setDropdown.setLabel("Others"));

        //RISK TYPES
        Utility.riskTypes();

        //RESIDENCE STATUS

        Locator ResidenceStatus = playwrightGenerics.page.locator("#residenceStatus");
        ResidenceStatus.selectOption(setDropdown.setLabel("Resident"));

        // CRS

        Locator CountryOfBirth = playwrightGenerics.page.locator("#id8e");
        CountryOfBirth.selectOption(setDropdown.setLabel(""));

        Locator TaxIsResident = playwrightGenerics.page.locator("#id8f");
        TaxIsResident.selectOption(setDropdown.setLabel("No"));

        //playwrightGenerics.page.locator("#id7").selectOption(setDropdown.setLabel(customerType))
        if (TaxIsResident.selectOption(setDropdown).equals("No")) {
            Locator TaxResidenceCountry = playwrightGenerics.page.locator("#id91");
            TaxResidenceCountry.selectOption(setDropdown.setLabel("Pakistan"));

            playwrightGenerics.page.locator("#id92").fill(TaxIdentificationNumber);

            Locator Reason = playwrightGenerics.page.locator("#id94");
            Reason.selectOption(setDropdown.setLabel(""));

            System.out.print("\n \t HI PLEASE ATTEST THAT I AM HERE");
        } else {

            ElementHandle UsPerson = (ElementHandle) playwrightGenerics.page.locator("#id99");
            UsPerson.click();
        }


        onBoardingcustomerl0(accountTitle, accountNumber, nVerification, motherName, fatherName,
                POB, gender, nationality, identityType, pProvince, mProvince, identityNumber, permanentAddress, permanentCity, mailingAddress, mailingCity);

        return true;
    }


    public boolean onboardingCorporateGroup(String accountTitle,
                                            String sellerCODE, String nameCnic, String motherName,
                                            String fatherName, String placeofBirth, String identityType, String identityNumber, String permanentAddress,
                                            String permanentCity, String mailingAddress, String mailingCity, String email,
                                            String accountHolderMN, String actualOwner, String beneficialCnic,
                                            String expectedCredit, String monthlyExpectedWithdrawal,
                                            String expectedDebit, String monthlyExpectedDeposit,
                                            String avergaeYearlyIncome, String averageYearlySales,
                                            String expectedMonthlyThroughPut, String expectedAvgBalance,
                                            String expectedMonthlyCreditSales,
                                            String expectedMaxAmountPerTransaction,
                                            String expectedNoOfTransaction, String annualTurnover,
                                            String natureOfBusiness, String noTinComments, String customerType) throws InterruptedException, IOException {


        Utility.getActionsObject_submenu_homepage(submenu, submenu1);

        // selecting the dropdown

        try {
            Locator locator = (Locator) playwrightGenerics.page.locator("#id7");
            locator.selectOption(setDropdown.setLabel(customerType));
            System.out.println("Selected Customer Type : " + locator);

        } catch (Exception e) {

            Locator locator = (Locator) playwrightGenerics.page.locator("#id7");
            locator.selectOption(setDropdown.setLabel(customerType));
            System.out.println("Selected Customer Type : " + locator);
        }

        if (playwrightGenerics.page.locator("#id7").selectOption(customerType).equals(("Corporate Account Master Wallet"))) {

            onboardingCorporateGroupMasterWallet(accountTitle, sellerCODE,
                    nameCnic, motherName, fatherName, placeofBirth, identityNumber, identityType, permanentAddress, permanentCity,
                    mailingAddress, mailingCity, email, accountHolderMN, actualOwner,
                    beneficialCnic,
                    expectedCredit, monthlyExpectedWithdrawal, expectedDebit, monthlyExpectedDeposit,
                    avergaeYearlyIncome, averageYearlySales,
                    expectedMonthlyThroughPut, expectedAvgBalance, expectedMonthlyCreditSales, expectedMaxAmountPerTransaction,
                    expectedNoOfTransaction, annualTurnover, natureOfBusiness, noTinComments, customerType);

        } else if (playwrightGenerics.page.locator("#id7").selectOption(customerType).equals(("Corporate Sim Sim Account User"))) {

            onboardingCorporateGroupMasterWallet(accountTitle, sellerCODE,
                    nameCnic, motherName, fatherName, placeofBirth, identityType, identityNumber, permanentAddress, permanentCity,
                    mailingAddress, mailingCity, email, accountHolderMN, actualOwner,
                    beneficialCnic,
                    expectedCredit, monthlyExpectedWithdrawal, expectedDebit, monthlyExpectedDeposit,
                    avergaeYearlyIncome, averageYearlySales,
                    expectedMonthlyThroughPut, expectedAvgBalance, expectedMonthlyCreditSales, expectedMaxAmountPerTransaction,
                    expectedNoOfTransaction, annualTurnover, natureOfBusiness, noTinComments, customerType);

        } else if (playwrightGenerics.page.locator("#id7").selectOption(customerType).equals(("Agent FINJA"))) {

            /// for different corporate groups

            playwrightGenerics.page.locator("#workingWithOtherBank").fill("NO");
            playwrightGenerics.page.locator("#netWorth").fill("60000");
            playwrightGenerics.page.locator("#typeOfTransaction").fill("Business");
            playwrightGenerics.page.locator("#currentBusinessSince").fill("2000");

            Locator premises = playwrightGenerics.page.locator("#premises");
            premises.selectOption(setDropdown.setLabel(""));

            onboardingCorporateGroupMasterWallet(accountTitle, sellerCODE,
                    nameCnic, motherName, fatherName, placeofBirth, identityType, identityNumber, permanentAddress, permanentCity,
                    mailingAddress, mailingCity, email, accountHolderMN, actualOwner,
                    beneficialCnic,
                    expectedCredit, monthlyExpectedWithdrawal, expectedDebit, monthlyExpectedDeposit,
                    avergaeYearlyIncome, averageYearlySales,
                    expectedMonthlyThroughPut, expectedAvgBalance, expectedMonthlyCreditSales, expectedMaxAmountPerTransaction,
                    expectedNoOfTransaction, annualTurnover, natureOfBusiness, noTinComments, customerType);

        } else if ((playwrightGenerics.page.locator("#id7").selectOption(customerType).equals(("Agent Finca")))) {

            onboardingCorporateGroupMasterWallet(accountTitle, sellerCODE,
                    nameCnic, motherName, fatherName, placeofBirth, identityType, identityNumber, permanentAddress, permanentCity,
                    mailingAddress, mailingCity, email, accountHolderMN, actualOwner,
                    beneficialCnic,
                    expectedCredit, monthlyExpectedWithdrawal, expectedDebit, monthlyExpectedDeposit,
                    avergaeYearlyIncome, averageYearlySales,
                    expectedMonthlyThroughPut, expectedAvgBalance, expectedMonthlyCreditSales, expectedMaxAmountPerTransaction,
                    expectedNoOfTransaction, annualTurnover, natureOfBusiness, noTinComments, customerType);
        }

        return true;

    }

    public boolean onboardingCorporateGroupMasterWallet(String accountTitle, String SellerCODE,
                                                        String NameCnic, String motherName, String FatherName, String PlaceofBirth, String identityType, String identityNumber, String PermanentAddress, String PermanentCity,
                                                        String MailingAddress, String MailingCity, String email, String AccountHolderMN, String ActualOwner,
                                                        String beneficialCnic,
                                                        String expectedCredit, String monthlyExpectedWithdrawal, String expectedDebit, String monthlyExpectedDeposit,
                                                        String avergaeYearlyIncome, String averageYearlySales,
                                                        String expectedMonthlyThroughPut, String expectedAvgBalance, String expectedMonthlyCreditSales, String expectedMaxAmountPerTransaction,
                                                        String expectedNoOfTransaction, String annualTurnover, String natureOfBusiness, String noTinComments, String customerType) throws InterruptedException, IOException {


        playwrightGenerics.page.locator("#sellerCode").fill(SellerCODE);

        Locator typeAccount = playwrightGenerics.page.locator("#idd");
        typeAccount.selectOption(setDropdown.setLabel(""));

        Locator nationality =playwrightGenerics.page.locator("#nationality2");
        nationality.selectOption(setDropdown.setLabel(""));

        playwrightGenerics.page.locator("#id4").fill(accountTitle);
        //	Assert.assertTrue(accountTitle.matches("^[a-zA-Z\\s]*$"));

      playwrightGenerics.page.locator("#nameAsPerCnic").fill(NameCnic);
        //Assert.assertTrue(NameCnic.matches("^(?=.*[1-9])[0-9+]{5}(-){1}[0-9+]{7}(-){1}[0-9]{1}$"));

      playwrightGenerics.page.locator("#motherName").fill(motherName);
        //Assert.assertTrue(motherName.matches("^[a-zA-Z\\s]*$"));

      playwrightGenerics.page.locator("#fatherHusbandName").fill(FatherName);
        //Assert.assertTrue(FatherName.matches("^[a-zA-Z\\s]*$"));

        playwrightGenerics.page.locator("#placeOfBirth").fill(PlaceofBirth);
        playwrightGenerics.page.locator("#permanentCity").fill(PermanentCity);

        //SELECTING RANDOM DATES

        try {
           playwrightGenerics.page.locator("#birthDate").click();
            ;
            Thread.sleep(500);
            Utility.selectDate( month_year, day);

            Thread.sleep(500);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }

        try {
          playwrightGenerics.page.locator("#cnicExpiryDate").click();
            ;
            Thread.sleep(500);
            Utility.selectDate(month_year, day);

            Thread.sleep(500);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }

        try {
           playwrightGenerics.page.locator("#issuanceDate").click();
            ;
            Thread.sleep(500);
            Utility.selectDate(month_year, day);

            Thread.sleep(500);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }

        //SELECT STATEMENTS ARE USED FOR DROPDOWNS

        Locator gender = playwrightGenerics.page.locator("#kvGender");
        gender.selectOption(setDropdown.setLabel(""));

        playwrightGenerics.page.locator("#identityValue").fill(identityNumber);
      playwrightGenerics.page.locator("#permanentAddress").fill(PermanentAddress);
        //Login.driver.findElement(By.id("permanentCity")).sendKeys(PermanentCity);

  /*      DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
*/
        playwrightGenerics.page.locator("#mailingOrBusinessAddress").fill(MailingAddress);
   //     dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);

      playwrightGenerics.page.locator("#mailingOrBusinessCity").fill(MailingCity);
        playwrightGenerics.page.locator("#email").fill(email);

        Locator pOA = playwrightGenerics.page.locator("#id46");
        pOA.selectOption(setDropdown.setLabel(""));

        playwrightGenerics.page.locator("#accountHolderMsisdn").fill(AccountHolderMN);

        Locator province = playwrightGenerics.page.locator("#permanentState");
        province.selectOption(setDropdown.setLabel(""));

        Locator MailingProvince =playwrightGenerics.page.locator("#mailingOrBusinessState");
        MailingProvince.selectOption(setDropdown.setLabel(""));


        Locator BeneficialAccOwner = playwrightGenerics.page.locator("#id4d");
        BeneficialAccOwner.selectOption(setDropdown.setLabel(""));

        playwrightGenerics.page.locator("#actualBeneficialOwner").fill(ActualOwner);

        Locator Relation = playwrightGenerics.page.locator("#id51");
        Relation.selectOption(setDropdown.setLabel(""));

      playwrightGenerics.page.locator("#cnicBeneficial").fill(beneficialCnic);

        Locator TxnMode = playwrightGenerics.page.locator("#modeOfTransaction");
        TxnMode.selectOption(setDropdown.setLabel(""));

        playwrightGenerics.page.locator("#expectedCredit").fill(expectedCredit);
        playwrightGenerics.page.locator("#monthlyExpectedWithdrawal").fill(monthlyExpectedWithdrawal);
        playwrightGenerics.page.locator("#expectedDebit").fill(expectedDebit);
        playwrightGenerics.page.locator("#monthlyExpectedDeposit").fill(monthlyExpectedDeposit);
        playwrightGenerics.page.locator("#avergaeYearlyIncome").fill(avergaeYearlyIncome);
        playwrightGenerics.page.locator("#averageYearlySales").fill(averageYearlySales);
        playwrightGenerics.page.locator("#expectedMonthlyThroughPut").fill(expectedMonthlyThroughPut);
        playwrightGenerics.page.locator("#expectedAvgBalance").fill(expectedAvgBalance);
        playwrightGenerics.page.locator("#expectedMonthlyCreditSales").fill(expectedMonthlyCreditSales);
        playwrightGenerics.page.locator("#expectedMaxAmountPerTransaction").fill(expectedMaxAmountPerTransaction);
        playwrightGenerics.page.locator("#expectedNoOfTransaction").fill(expectedNoOfTransaction);
        playwrightGenerics.page.locator("#annualTurnover").fill(annualTurnover);
        playwrightGenerics.page.locator("#natureOfBusiness").fill(natureOfBusiness);

        Locator businessType = playwrightGenerics.page.locator("#typeOfBusiness");
        businessType.selectOption(setDropdown.setLabel(""));

        playwrightGenerics.page.locator("#noTinComments").fill(noTinComments);

        Utility.riskTypes();

        Locator CountryOfBirth = playwrightGenerics.page.locator("#id8e");
        CountryOfBirth.selectOption(setDropdown.setLabel(""));


        Locator TaxResidentYN = playwrightGenerics.page.locator("#id8f");
        TaxResidentYN.selectOption(setDropdown.setLabel(""));

        ElementHandle UsPerson = (ElementHandle) playwrightGenerics.page.locator("#id99");
        UsPerson.click();

        //Utility.Submit(Login.driver);

        playwrightGenerics.page.locator("/html/body/div[1]/div[3]/div[4]/div/div[2]/div[2]/form/div[4]/div/div/input").click();

        playwrightGenerics.page.wait(1000);

        ///////////////////////////////////////
        //////AUTOMATING DIRECTOR'S PAGE///////
        //////////////////////////////////////

        playwrightGenerics.page.locator(("/html/body/div[1]/div[3]/div[4]/div/div[2]/div/div/form/div[2]/div[2]/div[2]/div[2]/div/input"))
                .fill("Absar ahmed Mujaddidi");

        playwrightGenerics.page.locator("/html/body/div[1]/div[3]/div[4]/div/div[2]/div/div/form/div[2]/div[2]/div[2]/div[3]/div/input").
        fill("lahore rehman gardens");

        Locator ID = playwrightGenerics.page.locator(("/html/body/div[1]/div[3]/div[4]/div/div[2]/div/div/form/div[2]/div[2]/div[2]/div[4]/div/select"));
        ID.selectOption(setDropdown.setLabel(""));

        playwrightGenerics.page.locator("/html/body/div[1]/div[3]/div[4]/div/div[2]/div/div/form/div[2]/div[2]/div[2]/div[5]/div/input").fill("3001254");

        Locator residentCountry = playwrightGenerics.page.locator(("/html/body/div[1]/div[3]/div[4]/div/div[2]/div/div/form/div[2]/div[2]/div[2]/div[6]/div/select"));
        residentCountry.selectOption(setDropdown.setLabel(""));
        playwrightGenerics.page.locator("/html/body/div[1]/div[3]/div[4]/div/div[2]/div/div/form/div[2]/div[2]/div[2]/div[7]/div/input").fill("Lahore");

        //////////////////////////////////////////
        //SELECTING RANDOM DATE FOR DIRECTOR DOB//
        //////////////////////////////////////////

        try {
            playwrightGenerics.page.locator("#directorDateofBirth").click();
            Thread.sleep(500);
            Utility.selectDate(month_year, day);

            Thread.sleep(500);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }

        //for proceeding after adding director//
        playwrightGenerics.page.locator("#idb8").click();

        playwrightGenerics.page.wait(1000);

        Thread.sleep(250);
        //CLICKING ON CONTINUE BUTTON ON DIRECTOR'S PAGE//
        playwrightGenerics.page.locator("/html/body/div[1]/div[3]/div[4]/div/div[2]/div/div/form/div[2]/div[3]/div/input[3]").click();

        Thread.sleep(300);

        //CLICKING ON CONTINUE BUTTON ON CORPORATE CUSTOMER ONBOARDING PAGE AFTER ADDING DIRECTOR//
        playwrightGenerics.page.locator("/html/body/div/div[3]/div[4]/div/div[2]/div/div/form/div[4]/div/input[1]").click();

        return true;

    }


}