package com.booking.user.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "UserData")
@NoArgsConstructor
@Setter
@Getter
@ToString
@AllArgsConstructor
public class UserData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int id;
    private String name;
    private String email;
    private String phoneNumber;
    private String role;
}
