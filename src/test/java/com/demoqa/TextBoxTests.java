package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillFormTest() {
        String name = "Artem";

        open("/text-box");
        $("#userName").setValue(name);
        $("#userEmail").setValue("artem@artem.com");
        $("#currentAddress").setValue("Pushkina street");
        $("#permanentAddress").setValue("Kolotushkina dom 1");
        $("#submit").click();

        $("#output #name").shouldHave(text(name));
        $("#output #email").shouldHave(text("artem@artem.com"));
        $("#output #currentAddress").shouldHave(text("Pushkina street"));
        $("#output #permanentAddress").shouldHave(text("Kolotushkina dom 1"));

    }
}
