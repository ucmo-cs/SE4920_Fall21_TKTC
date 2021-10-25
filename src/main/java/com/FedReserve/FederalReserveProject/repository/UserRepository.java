package com.FedReserve.FederalReserveProject.repository;

import com.FedReserve.FederalReserveProject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    //User findOne(int id);
}
