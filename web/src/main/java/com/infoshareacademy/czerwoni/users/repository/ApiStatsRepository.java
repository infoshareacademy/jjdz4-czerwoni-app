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
import java.time.LocalDateTime;
import java.util.List;

@Stateless
public class ApiStatsRepository {

    @Inject
    AuthorizedUsersRepository authorizedUsersRepository;

    private final static String API_URL = "http://localhost:8080/api/GetStats";

    public List<ApiStats> getFullReport() {
        return getStatsList(API_URL.concat("/all"));
    }

    public List<ApiStats> getReportByUserName(String userName) {
        List<Users> users = authorizedUsersRepository.getAllUsers();
        String searchedUserEmail = users.stream()
                .filter(user -> user.getName() == userName)
                .findFirst()
                .get()
                .getEmail();
        return getStatsList(API_URL.concat("/email/")
                .concat(searchedUserEmail));
    }

    public List<ApiStats> getReportByEmail(String email) {
        return getStatsList(API_URL.concat("/email?email=")
                .concat(email));
    }

    public List<ApiStats> getReportbyDate(LocalDateTime startDate, LocalDateTime endDate) {
        return getStatsList(API_URL.concat("/date?startDate=")
                .concat(startDate.toString())
                .concat("&endDate=")
                .concat(endDate.toString()));
    }

    private List<ApiStats> getStatsList(String URL) {
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(URL);
        Response resp = webTarget.request().get();

        List<ApiStats> stats = resp.readEntity(new GenericType<List<ApiStats>>(){});
        resp.close();
        return stats;
    }
}
