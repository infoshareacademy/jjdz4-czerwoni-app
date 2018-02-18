package com.infoshareacademy.czerwoni.service;

import com.infoshareacademy.czerwoni.domain.LoginStat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/")
public class LoginStatsService {

    private Logger LOGGER = LoggerFactory.getLogger(LoginStatsService.class);

    public LoginStatsService() {
    }

    @POST
    @Path("/AddLoginStat")
    @Consumes(MediaType.APPLICATION_JSON)
    /* {
        "userLogin": "adam",
        "loginTime": "2018-02-18T15:59:57.653"
       }        */
//    @Produces(MediaType.TEXT_PLAIN)
    public Response addLoginStat(LoginStat loginStat) {

        LOGGER.info("login stats: {} o {}",
                loginStat.getUserLogin(),
                loginStat.getLoginTime());

        return Response.status(Response.Status.CREATED).build();
    }
}
