package com.infoshareacademy.czerwoni.users.ejb;

import com.infoshareacademy.czerwoni.users.repository.AuthorizedUsersRepository;
import org.jboss.crypto.CryptoUtil;
import com.infoshareacademy.czerwoni.users.domain.*;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDateTime;
import java.util.*;
import java.util.logging.Level;


@Stateless
public class AuthorizedUsersService implements AuthorizedUsersServiceLocal {

    @Inject
    private AuthorizedUsersRepository authorizedUsersRepository;
    private WebTarget webTarget;
    private static final String API_BASE_URL = "http://localhost:8080/api";

    @Override
    public void addAuthorizedUser(Users users, Roles roles) {
        authorizedUsersRepository.addAuthorizedUser(users, roles);
    }

    @Override
    public String getHexPassword(String password) {
        return CryptoUtil.createPasswordHash("MD5", "hex", null, null, password);
    }

    @Override
    public Set<String> getRolesNameList() {
        Set<String> rolesSet = new HashSet<>();
        authorizedUsersRepository
                .getAllRoles()
                .forEach(roles -> rolesSet.add(roles.getUserRole()));
        return rolesSet;
    }

    @Override
    public List<Users> getAllUsers() {
        return authorizedUsersRepository.getAllUsers();
    }

    @Override
    public boolean isEmailUserExist(String email) {
        return getAllUsers().stream().anyMatch(users -> users.getEmail().equals(email));
    }

    @Override
    public void updateAuthorizedUser(Users users, Roles roles) {
        authorizedUsersRepository.updateAuthorizedUser(users, roles);
    }

    @Override
    public Users getUserByEmail(String email){
        return authorizedUsersRepository.getUserByEmail(email);
    }
    public Roles getRolesByLogin(String login){
        return authorizedUsersRepository.getRolesByLogin(login);
    }
    @Override
    public void addStatsToApi(String userLogin, LocalDateTime loginTime) {
        webTarget = ClientBuilder.newClient().target(API_BASE_URL);
        ApiStats apiStats = new ApiStats();
        apiStats.setUserLogin(userLogin);
        apiStats.setLoginTime(loginTime);
        final Response response = webTarget.path("/AddLoginStat")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.entity(apiStats, MediaType.APPLICATION_JSON_TYPE));
        response.readEntity(ApiStats.class);

        }



//        String address = "localhost:8080/AddLoginStat";
//
//        ApiStats apiStats = new ApiStats();
//
//        Client client = ClientBuilder.newClient();
//        WebTarget webTarget = client.target(address);
//        Response response = webTarget.request().post(Entity.json(apiStats));
//        response.close();
//        if (response.getStatus() == 200) {
//            TranslateResponse result = response.readEntity(TranslateResponse.class);
//            response.close();
//
//            return result.getData().getTranslations().get(0).getTranslatedText();
//        } else {
//            ErrorResponse result = response.readEntity(ErrorResponse.class);
//            response.close();
//
//            throw new RuntimeException(result.getError().getMessage());
//        }

}
