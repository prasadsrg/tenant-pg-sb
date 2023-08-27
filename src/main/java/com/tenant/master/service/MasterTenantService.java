package com.tenant.master.service;

import com.tenant.master.entity.MasterTenant;

/**
 * @author Md. Amran Hossain
 */
public interface MasterTenantService {

    MasterTenant findByClientId(String clientId);
}
