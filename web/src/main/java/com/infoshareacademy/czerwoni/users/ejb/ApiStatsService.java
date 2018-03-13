package com.infoshareacademy.czerwoni.users.ejb;

import com.infoshareacademy.czerwoni.users.domain.ApiStats;

import java.time.LocalDateTime;
import java.util.List;

public interface ApiStatsService {

    List<ApiStats> getFullReport();
    List<ApiStats> getReportForUser(String userLogin);
    List<ApiStats> getReportByEmail(String email);
    List<ApiStats> getReportByDate(LocalDateTime startDate, LocalDateTime endDate);
}
