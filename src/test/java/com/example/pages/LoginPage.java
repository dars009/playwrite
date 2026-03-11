package com.example.pages;

import com.microsoft.playwright.*;

public class LoginPage {
    private Page page;

    public LoginPage(Page page) {
        this.page = page;
    }

    public void navigateToLogin() {
        page.navigate("/login");
    }

    public void fillUsername(String username) {
        page.fill("input[name='username']", username);
    }

    public void fillPassword(String password) {
        page.fill("input[name='password']", password);
    }

    public void clickLogin() {
        page.click("button[type='submit']");
    }

    public String getErrorMessage() {
        return page.textContent(".error-message");
    }
}