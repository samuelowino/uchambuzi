package com.aplus.ldata.api.database.repository;

import com.aplus.ldata.api.database.UserSurveyData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSurveyDataRepository extends JpaRepository<UserSurveyData, Long> {
}
