package com.ddubson.filmfox.acceptance;

import com.ddubson.filmfox.FilmFoxApplication;
import org.fluentlenium.adapter.junit.FluentTest;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FilmFoxApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
abstract public class AcceptanceTest extends FluentTest {
    @LocalServerPort
    int serverPort;

    @Override
    public String getBaseUrl() {
        return "http://localhost:" + serverPort;
    }

    @Override
    public WebDriver newWebDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String execPath;

        if (System.getProperty("os.name").toLowerCase().contains("windows")) {
            execPath = "node_modules/phantomjs-prebuilt/lib/phantom/bin/phantomjs.exe";
        } else {
            execPath = "node_modules/phantomjs-prebuilt/bin/phantomjs";
        }
        capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, execPath);
        capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, new String[]{"--webdriver-loglevel=WARN", "--webdriver-logfile=logs/phantomjs.log"});
        PhantomJSDriverService service = PhantomJSDriverService.createDefaultService(capabilities);
        return new PhantomJSDriver(service, capabilities);
    }
}
