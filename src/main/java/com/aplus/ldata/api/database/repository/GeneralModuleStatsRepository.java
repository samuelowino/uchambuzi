package com.aplus.ldata.api.database.repository;

import com.aplus.ldata.api.database.GeneralModuleStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GeneralModuleStatsRepository extends JpaRepository<GeneralModuleStats,Long> {
    Optional<GeneralModuleStats> findByUuid(String uuid);
}
