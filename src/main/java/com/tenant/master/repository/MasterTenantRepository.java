package com.tenant.master.repository;

import com.tenant.master.entity.MasterTenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterTenantRepository extends JpaRepository<MasterTenant, String> {
    MasterTenant findByTenantClientId(String clientId);
}
