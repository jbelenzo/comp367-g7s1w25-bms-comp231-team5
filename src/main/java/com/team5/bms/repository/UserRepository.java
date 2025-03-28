package com.team5.bms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import com.team5.bms.model.User;
import com.team5.bms.model.enumeration.Roles;

import java.util.List;

/**
*
* @author Jasper Belenzo
* 
*/
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsernameAndPassword(String username, String password);

    List<User> findByBuildingId(Long buildingId);
    
    List<User> findByBuildingIdAndRole(Long buildingId, Roles role);

}
