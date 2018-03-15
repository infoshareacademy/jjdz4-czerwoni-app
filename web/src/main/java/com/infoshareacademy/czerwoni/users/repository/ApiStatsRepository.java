package com.infoshareacademy.czerwoni.users.repository;

import com.infoshareacademy.czerwoni.users.domain.ApiStats;
import com.infoshareacademy.czerwoni.users.domain.Users;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.List;

@Stateless
public class ApiStatsRepository {

    @Inject
    AuthorizedUsersRepository authorizedUsersRepository;

    private final static String API_URL = "http://localhost:8080/api/GetStats";

    public List<Users> getFullReport() {
        List<ApiStats> apiStats = getStatsList(API_URL.concat("/all"));
        return Collections.emptyList();
    }

    public List<Users> getReportByEmail(String email) {
        List<ApiStats> apiStats = getStatsList(API_URL.concat("/email?email=")
                .concat(email));
        return Collections.emptyList();
    }

    private List<ApiStats> getStatsList(String URL) {
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(URL);
        Response resp = webTarget.request().get();

        List<ApiStats> stats = resp.readEntity(new GenericType<List<ApiStats>>(){});
        resp.close();
        return stats;
    }

    private Users getUserByEmail(String email) {
        return authorizedUsersRepository.getAllUsers().stream()
                .filter(users -> users.getEmail() == email)
                .findAny()
                .orElse(null);
    }
}
