package com.aplus.ldata.api.database.repository;

import com.aplus.ldata.api.database.UserScreenVisits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserScreenVisitsRepository extends JpaRepository<UserScreenVisits,Long> {
    Optional<UserScreenVisits> findByUuid(String uuid);
}
