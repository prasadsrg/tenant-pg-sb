package com.tenant.tenant.repository;

import com.tenant.tenant.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Md. Amran Hossain
 */
@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {

    Profile findByUserName(String userName);
}
