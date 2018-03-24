package com.infoshareacademy.czerwoni.users.ejb;

import javax.ejb.Local;

@Local
public interface TokenService {

    String CSRF_TOKEN_NAME = "X-TOKEN";

    String generateToken();

    String buildCookieName(String reqURI);
}
