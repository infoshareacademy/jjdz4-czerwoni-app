package com.infoshareacademy.czerwoni.users.ejb;

import com.infoshareacademy.czerwoni.users.domain.ApiStats;
import com.infoshareacademy.czerwoni.users.repository.ApiStatsRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class ApiStatsServiceBean implements ApiStatsService {

    @Inject
    ApiStatsRepository apiStatsRepository;

    @Override
    public List<ApiStats> getLoginCount() {
        return apiStatsRepository.getLoginCount();
    }

    @Override
    public List<ApiStats> getLoginCount(String email) {
        return apiStatsRepository.getLoginCount(email);
    }

    @Override
    public List<ApiStats> getFullReport() {
        return apiStatsRepository.getFullReport();
    }

    @Override
    public List<ApiStats> getReportByEmail(String email) {
        return apiStatsRepository.getReportByEmail(email);
    }


}
