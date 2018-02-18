package com.infoshareacademy.czerwoni.service;

import com.infoshareacademy.czerwoni.domain.LoginStat;
import com.infoshareacademy.czerwoni.repository.LoginStatsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/")
public class LoginStatsService {

    private Logger LOGGER = LoggerFactory.getLogger(LoginStatsService.class);

    @Inject
    private LoginStatsRepository statsRepository;

    public LoginStatsService() {
    }

    @POST
    @Path("/AddLoginStat")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addLoginStat(LoginStat loginStat) {

        if (loginStat.getUserLogin().isEmpty()) {
            LOGGER.warn("Pusty login!");
        } else {
            LOGGER.info("login: {} czas logowania: {}",
                    loginStat.getUserLogin(),
                    loginStat.getLoginTime());
        }

        Response.Status status = statsRepository.addStat(loginStat)
                ? Response.Status.CREATED : Response.Status.NOT_IMPLEMENTED;
        return Response.status(status).build();
    }
}
