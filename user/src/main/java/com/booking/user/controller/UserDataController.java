package com.booking.user.controller;

import com.booking.user.Model.UserData;
import com.booking.user.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:3000")
public class UserDataController {


    @Autowired
    private final UserDataService userDataService;
    public UserDataController(UserDataService userDataService) {
        this.userDataService = userDataService;
    }

    @GetMapping("allUsers")
    public List<UserData> listAllUsers(){
        try{
            return  userDataService.getAllUsers();
        }catch(Exception ex){
            return new ArrayList<>();
        }
    }

    @PostMapping ("newUser")
    public String SaveNewUser(@RequestBody UserData newUser){
        try{
            return  userDataService.saveNewUser(newUser);
        }catch(Exception ex){
            return "Failed to save the NewUser please try again later";
        }
    }

    @PutMapping("updateuser")
    public String updateuser(@RequestBody UserData updateuser, @RequestParam Integer id) {
        return userDataService.updateuser(updateuser,id);
    }

    @DeleteMapping("deleteById")
    public String deleteById(@RequestParam Integer id) {
        return userDataService.deleteByEmail(id);
    }
}
