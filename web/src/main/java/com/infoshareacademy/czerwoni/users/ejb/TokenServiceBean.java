package com.infoshareacademy.czerwoni.users.ejb;

import java.security.SecureRandom;
import javax.ejb.Stateless;
import javax.xml.bind.DatatypeConverter;

@Stateless
public class TokenServiceBean implements TokenService {

    private final SecureRandom secureRandom = new SecureRandom();

    @Override
    public String generateToken() {
        byte[] buffer = new byte[50];
        this.secureRandom.nextBytes(buffer);
        return DatatypeConverter.printHexBinary(buffer);
    }

    @Override
    public String buildCookieName(String reqURI) {
        String backendServiceName = reqURI.replaceAll("/", "-");
        return CSRF_TOKEN_NAME + "-" + backendServiceName;
    }
}
