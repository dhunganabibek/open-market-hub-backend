package com.openmarkethub.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
public class User {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;
    
    @Column(name = "email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="about")
    private String about;

}
