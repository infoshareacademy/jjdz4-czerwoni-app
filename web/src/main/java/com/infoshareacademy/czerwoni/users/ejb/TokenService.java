package com.infoshareacademy.czerwoni.users.ejb;

import javax.ejb.Local;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Local
public interface TokenService {

    String CSRF_TOKEN_NAME = "X-TOKEN";

    String generateToken();

    String buildCookieName(String reqURI);

    Cookie fetchTokenCookie(HttpServletRequest httpReq);
}
