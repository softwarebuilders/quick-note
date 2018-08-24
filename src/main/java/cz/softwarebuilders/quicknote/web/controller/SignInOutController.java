package cz.softwarebuilders.quicknote.web.controller;

import cz.softwarebuilders.quicknote.oauth.GoogleTokenVerifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.GeneralSecurityException;

@RestController
public class SignInOutController {
    @RequestMapping(value = "/googleSignIn", method = RequestMethod.POST)
    public String googleSignIn(@RequestParam(name = "token") String token) throws GeneralSecurityException, IOException {
        return new GoogleTokenVerifier().verify(token);
    }
    @RequestMapping(value = "/googleSignOut", method = RequestMethod.POST)
    public String googleSignOut() throws GeneralSecurityException, IOException {
        return "signed out";
    }

}
