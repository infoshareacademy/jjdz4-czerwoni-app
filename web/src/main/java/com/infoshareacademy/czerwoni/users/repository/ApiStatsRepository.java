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
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Stateless
public class ApiStatsRepository {

    @Inject
    AuthorizedUsersRepository authorizedUsersRepository;

    private final static String API_URL = "http://localhost:8080/api/GetStats";

    public List<ApiStats> getLoginCount() {
        List<ApiStats> listFromAPI = getFullReport();
        List<ApiStats> returnList = new ArrayList<>();
        for (ApiStats apiStat: listFromAPI) {
            if (!checkIfAdded(apiStat, returnList)) {
                returnList.add(new ApiStats(apiStat.getUserLogin(),
                        getLogin(apiStat.getUserLogin()),
                        getVisitCount(apiStat.getUserLogin(), listFromAPI),
                        getLastVisit(apiStat.getUserLogin(), listFromAPI)));
            }
        }
        return returnList;
    }

    public List<ApiStats> getLoginCount(String email) {
        List<ApiStats> listFromAPI = getReportByEmail(email);
        List<ApiStats> returnList = new ArrayList<>();
        try {
            for (ApiStats apiStat: listFromAPI) {
                if (!checkIfAdded(apiStat, returnList)) {
                    returnList.add(new ApiStats(apiStat.getUserLogin(),
                            getLogin(apiStat.getUserLogin()),
                            getVisitCount(apiStat.getUserLogin(), listFromAPI),
                            getLastVisit(apiStat.getUserLogin(), listFromAPI)));
                }
            }
        } catch (NullPointerException e) {
            returnList = Collections.EMPTY_LIST;
        }
        return returnList;
    }

    private String getLastVisit(String userLogin, List<ApiStats> apiStats)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String lastVisit = apiStats.stream()
                .filter(stat -> stat.getUserLogin().equalsIgnoreCase(userLogin))
                .reduce((first, second) -> second)
                .get()
                .getLoginTime()
                .format(formatter);
        return lastVisit;
    }

    private Integer getVisitCount(String userLogin, List<ApiStats> apiStats) {
        return apiStats.stream()
                .filter(user -> user.getUserLogin().equals(userLogin))
                .collect(Collectors.toList())
                .size();
    }

    private String getLogin(String userLogin) {
        String login;
        try {
            login = getUserByEmail(userLogin).getLogin();
        } catch (NullPointerException e) {
            return "Google User";
        }
        return login;
    }

    private boolean checkIfAdded(ApiStats apiStat, List<ApiStats> returnList) {
        return returnList.stream()
                .anyMatch(stat -> stat.getUserLogin().equalsIgnoreCase(apiStat.getUserLogin()));
    }

    public List<ApiStats> getFullReport() {
        List<ApiStats> apiStats = getStatsList(API_URL.concat("/all"));
        return apiStats;
    }

    public List<ApiStats> getReportByEmail(String email) {
        List<ApiStats> apiStats = getStatsList(API_URL.concat("/email?email=")
                .concat(email));
        return apiStats;
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
                .filter(users -> users.getEmail().equalsIgnoreCase(email))
                .findAny()
                .orElse(null);
    }

}
