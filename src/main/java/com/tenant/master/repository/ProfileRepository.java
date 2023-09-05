package com.tenant.master.repository;

import com.tenant.master.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {

    Profile findByUserName(String userName);
}
