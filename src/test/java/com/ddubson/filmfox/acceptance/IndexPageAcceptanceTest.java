package com.ddubson.filmfox.acceptance;

import org.junit.Test;

import static org.fluentlenium.core.filter.FilterConstructor.withText;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class IndexPageAcceptanceTest extends AcceptanceTest {
    @Test
    public void whenIndexPageLoads_itShouldDisplayHelloWorld() {
        goTo(this.getBaseUrl());
        assertTrue(find("div", withText().contains("Hello World")).present());
    }
}
