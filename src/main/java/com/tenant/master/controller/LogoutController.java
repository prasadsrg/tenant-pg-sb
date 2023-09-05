package com.tenant.master.controller;

import com.tenant.security.UserTenantInformation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.security.Principal;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/auth/logout")
public class LogoutController implements Serializable {

    @Autowired
    ApplicationContext applicationContext;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> logoutFromApp(Principal principal) {
        log.info("AuthenticationController::logoutFromApp() method call.. principal value {}", principal);
        UserTenantInformation userCharityInfo = applicationContext.getBean(UserTenantInformation.class);
        Map<String, String> map = userCharityInfo.getMap();
        log.info("user CharityInfo Map :: {}", map);
        if(map != null && principal != null && principal.getName() != null){
            map.remove(principal.getName());
            userCharityInfo.setMap(map);
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
