package com.infoshareacademy.czerwoni.users.ejb;

public interface SecurityService {

    String generateToken();

    String fetchCookieName(String reqURI);
}
