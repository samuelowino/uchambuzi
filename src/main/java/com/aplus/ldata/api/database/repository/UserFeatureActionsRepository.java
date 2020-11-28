package com.aplus.ldata.api.database.repository;

import com.aplus.ldata.api.database.UserFeatureActions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserFeatureActionsRepository extends JpaRepository<UserFeatureActions,Long> {
    Optional<UserFeatureActions> findByUuid(String uuid);
}
