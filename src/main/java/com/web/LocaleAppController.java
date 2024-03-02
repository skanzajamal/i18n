package com.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequestMapping("locale")
public class LocaleAppController {

    @Autowired
    private final MessageSource messageSource;

    @Autowired
    public LocaleAppController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    // test api
    @GetMapping
    public String welcome(){
        return messageSource.getMessage("welcome.message", null, LocaleContextHolder.getLocale());
    }

    @GetMapping("/with-header")
    public String welcomeWithHeader(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
        return messageSource.getMessage("welcome.message", null, locale);
    }

}//ENDCLASS
