package com.infoshareacademy.czerwoni.users.ejb;

import com.infoshareacademy.czerwoni.users.domain.ApiStats;

import java.util.List;

public interface ApiStatsService {

    List<ApiStats> getLoginCount();

    List<ApiStats> getFullReport();
    List<ApiStats> getReportByEmail(String email);
}
