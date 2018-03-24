package com.infoshareacademy.czerwoni.users.ejb;

import javax.ejb.Local;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Local
public interface TokenService {

    String CSRF_TOKEN_NAME = "X-TOKEN";
    String LOGIN_URI = "/login";

    String generateToken();

    String buildCookieName(String reqURI);

    boolean validateTokens(ServletRequest servletReq) throws IOException;
}
