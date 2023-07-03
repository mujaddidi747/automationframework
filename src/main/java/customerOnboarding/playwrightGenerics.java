package customerOnboarding;

import com.microsoft.playwright.*;

public class playwrightGenerics {
    static Playwright playwright = Playwright.create();
    static Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    static BrowserContext context = browser.newContext();
    static Page page = context.newPage();


}
