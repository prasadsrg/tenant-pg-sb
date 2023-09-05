package com.tenant.master.service;

import com.tenant.master.entity.MasterTenant;

public interface MasterTenantService {

    MasterTenant findByClientId(String clientId);
}
