package com.example.tests;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

public class LoginPageTest {

    private static Playwright playwright;
    private Page page;

    @BeforeAll
    public static void setUp() {
        playwright = Playwright.create();
    }

    @BeforeEach
    public void init() {
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
    }

    @Test
    public void testLogin() {
        page.navigate("http://example.com/login");
        page.fill("#username", "testuser");
        page.fill("#password", "testpassword");
        page.click("#login-button");
        Assertions.assertTrue(page.isVisible("text=Welcome, testuser!"));
    }

    @AfterEach
    public void tearDown() {
        page.close();
    }

    @AfterAll
    public static void closePlaywright() {
        playwright.close();
    }
}