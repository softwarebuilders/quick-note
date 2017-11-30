package cz.softwarebuilders.quicknote.web.controller;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.apache.ApacheHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

@RestController
public class Controller {
    @RequestMapping("/hello")
    public String hello() {
        return "hello quick note how are you";
    }

    @RequestMapping(value = "/verify", method = RequestMethod.POST)
    public String verifyToken(@RequestParam(name = "token") String token) throws GeneralSecurityException, IOException {
        GoogleIdTokenVerifier tokenVerifier = new GoogleIdTokenVerifier
                .Builder(new ApacheHttpTransport(), JacksonFactory.getDefaultInstance())
                .setAudience(Collections.singletonList("94278606361-98l5spr2iakcb1gavm38t5vhdrqvo5o4.apps.googleusercontent.com"))
                .build();
        GoogleIdToken idToken = tokenVerifier.verify(token);
        if (idToken != null) {
            GoogleIdToken.Payload payload = idToken.getPayload();

            // Print user identifier
            //TODO: store user id to db
            String userId = payload.getSubject();
            System.out.println("User ID: " + userId);

            // Get profile information from payload
            String email = payload.getEmail();
            boolean emailVerified = Boolean.valueOf(payload.getEmailVerified());
            String name = (String) payload.get("name");
            String pictureUrl = (String) payload.get("picture");
            String locale = (String) payload.get("locale");
            String familyName = (String) payload.get("family_name");
            String givenName = (String) payload.get("given_name");
            return userId + " " + email + " " + familyName + " " + givenName;
        } else {
            return "Invalid token";
        }
    }

}
