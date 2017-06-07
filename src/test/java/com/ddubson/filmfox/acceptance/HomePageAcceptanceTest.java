package com.ddubson.filmfox.acceptance;

import com.ddubson.filmfox.acceptance.pages.HomePage;
import org.fluentlenium.core.annotation.Page;
import org.junit.Test;

public class HomePageAcceptanceTest extends AcceptanceTest {
    @Page
    HomePage homePage;

    @Test
    public void whenIndexPageLoads_itShouldDisplayAllMovies() {
        homePage.go();
        find("movie-list").present();
    }

}
