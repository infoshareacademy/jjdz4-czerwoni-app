package com.infoshareacademy.czerwoni.users.ejb;

import java.security.SecureRandom;
import javax.xml.bind.DatatypeConverter;

public class SecurityServiceBean implements SecurityService {

    private final SecureRandom secureRandom = new SecureRandom();

    @Override
    public String generateToken() {
        byte[] buffer = new byte[50];
        this.secureRandom.nextBytes(buffer);
        return DatatypeConverter.printHexBinary(buffer);
    }

    @Override
    public String fetchCookieName(String reqURI) {
        return null;
    }
}
