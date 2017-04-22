package com.ddubson.filmfox.acceptance;

import com.ddubson.filmfox.acceptance.pages.HomePage;
import org.fluentlenium.core.annotation.Page;
import org.junit.Test;

import static org.fluentlenium.core.filter.FilterConstructor.withText;
import static org.junit.Assert.assertTrue;

public class IndexPageAcceptanceTest extends AcceptanceTest {
    @Page
    HomePage homePage;

    @Test
    public void whenIndexPageLoads_itShouldDisplayHelloWorld() {
        homePage.go();
        assertTrue(homePage.find("div", withText().contains("Hello World")).present());
    }
}
