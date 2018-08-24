package cz.softwarebuilders.quicknote.web.controller;

import cz.softwarebuilders.quicknote.oauth.GoogleTokenVerifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Date;

@RestController
public class HelloController {
    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public String googleSignIn() throws GeneralSecurityException, IOException {
        return "Hello this is QuickNote " + new Date();
    }
}
