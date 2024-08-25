package com.booking.user.service;

import com.booking.user.Model.UserData;
import com.booking.user.repository.UserDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserDataService {
    //    @Autowired
    private final UserDataRepo userDataRepo;
    @Autowired
    public UserDataService(UserDataRepo userDataRepo) {
        this.userDataRepo = userDataRepo;
    }

    public List<UserData> getAllUsers(){
        return userDataRepo.findAll();
    }

    public  String saveNewUser(UserData user){
        try{
            userDataRepo.save(user);
            return "Succefully Registered the user";
        }catch(Exception ex){
            return "Registration failed";
        }
    }
    public String deleteByEmail(Integer id) {
        try {
            Optional<UserData> optionalUser = userDataRepo.findById(id);
            if (optionalUser.isPresent()) {
                UserData requestedUser = optionalUser.get();
                UserData userData = userDataRepo.findByEmail(requestedUser.getEmail());
                if (userData != null) {
                    // Delete the user by ID
                    userDataRepo.deleteById(userData.getId());
                    return userData.getEmail();
                } else {
                    return "No user found with the email " + requestedUser.getEmail();
                }
            } else {
                return "User not found with ID " + id;
            }
        } catch (Exception ex) {
            // Handle exceptions properly
            ex.printStackTrace();
            return "Error occurred while deleting user";
        }
    }

    public String updateuser(UserData updatedUserData, Integer id) {
        try {
            Optional<UserData> optionalUser = userDataRepo.findById(id);
            if (optionalUser.isPresent()) {
                UserData updatedUser = optionalUser.get();
                updatedUser.setEmail(updatedUserData.getEmail());
                updatedUser.setPhoneNumber(updatedUserData.getPhoneNumber());
                updatedUser.setRole(updatedUserData.getRole());

                userDataRepo.save(updatedUser);
                return "User updated successfully";
            } else {
                return "User not found with ID " + id;
            }
        } catch (Exception ex) {
            // Handle exceptions properly
            ex.printStackTrace();
            return "An error occurred while updating the user";
        }
    }


}
