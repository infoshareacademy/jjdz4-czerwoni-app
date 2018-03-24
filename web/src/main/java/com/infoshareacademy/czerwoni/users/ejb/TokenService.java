package com.infoshareacademy.czerwoni.users.ejb;

import javax.ejb.Local;
import javax.servlet.ServletRequest;
import java.io.IOException;

@Local
public interface TokenService {

    String generateToken();

    String buildCookieName(String reqURI);

    boolean validateTokens(ServletRequest servletReq) throws IOException;
}
