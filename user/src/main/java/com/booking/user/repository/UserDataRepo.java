package com.booking.user.repository;

import com.booking.user.Model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDataRepo extends JpaRepository<UserData,Integer> {
   UserData findByEmail(String email);
}
