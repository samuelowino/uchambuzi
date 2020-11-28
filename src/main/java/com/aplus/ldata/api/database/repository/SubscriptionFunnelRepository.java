package com.aplus.ldata.api.database.repository;

import com.aplus.ldata.api.database.SubscriptionFunnel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubscriptionFunnelRepository extends JpaRepository<SubscriptionFunnel,Long> {
    Optional<SubscriptionFunnel> findByUuid(String uuid);
}
