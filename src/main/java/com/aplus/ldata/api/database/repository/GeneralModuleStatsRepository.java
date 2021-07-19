package com.aplus.ldata.api.database.repository;

import com.aplus.ldata.api.database.GeneralModuleStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GeneralModuleStatsRepository extends JpaRepository<GeneralModuleStats,Long> {
    Optional<GeneralModuleStats> findByUuid(String uuid);

    @Query(value = "SELECT * FROM general_module_stats WHERE module_name = ?1", nativeQuery = true)
    List<GeneralModuleStats> getModuleStatsByName(String name);
}
