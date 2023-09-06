package com.tenant.master.controller;

import com.tenant.config.AppException;
import com.tenant.master.constant.UserStatus;
import com.tenant.master.dto.AuthResponse;
import com.tenant.master.dto.UserLoginDTO;
import com.tenant.master.config.DBContextHolder;
import com.tenant.master.entity.MasterTenant;
import com.tenant.master.service.MasterTenantService;
import com.tenant.security.UserTenantInformation;
import com.tenant.util.JwtTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.ApplicationScope;


import javax.validation.Valid;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController implements Serializable {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    private Map<String, String> mapValue = new HashMap<>();
    private Map<String, String> userDbMap = new HashMap<>();


    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    MasterTenantService masterTenantService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> userLogin(@Valid @RequestBody UserLoginDTO userLoginDTO) throws AuthenticationException {
        LOGGER.info("userLogin() method call...");
        if(userLoginDTO == null ) throw new AppException("Please provide user login");
        if(null == userLoginDTO.getUserName() || userLoginDTO.getUserName().isEmpty()){
            return new ResponseEntity<>("User name is required", HttpStatus.BAD_REQUEST);
        }
        //set database parameter
        MasterTenant masterTenant = masterTenantService.findByClientId(userLoginDTO.getTenant());
        if(null == masterTenant || masterTenant.getStatus().toUpperCase().equals(UserStatus.INACTIVE)){
            throw new AppException("Please contact service provider.");
        }
        //Entry Client Wise value dbName store into bean.
        loadCurrentDatabaseInstance(masterTenant.getDbName(), userLoginDTO.getUserName());
        final Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userLoginDTO.getUserName(), userLoginDTO.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        final String token = jwtTokenUtil.generateToken(userDetails.getUsername(),String.valueOf(userLoginDTO.getTenant()));
        //Map the value into applicationScope bean
        setMetaDataAfterLogin();
        return ResponseEntity.ok(new AuthResponse(userDetails.getUsername(),token));
    }

    private void loadCurrentDatabaseInstance(String databaseName, String userName) {
        DBContextHolder.setCurrentDb(databaseName);
        mapValue.put(userName, databaseName);
    }

    @Bean(name = "userTenantInfo")
    @ApplicationScope
    public UserTenantInformation setMetaDataAfterLogin() {
        UserTenantInformation tenantInformation = new UserTenantInformation();
        if (mapValue.size() > 0) {
            for (String key : mapValue.keySet()) {
                if (null == userDbMap.get(key)) {
                    //Here Assign putAll due to all time one come.
                    userDbMap.putAll(mapValue);
                } else {
                    userDbMap.put(key, mapValue.get(key));
                }
            }
            mapValue = new HashMap<>();
        }
        tenantInformation.setMap(userDbMap);
        return tenantInformation;
    }
}
