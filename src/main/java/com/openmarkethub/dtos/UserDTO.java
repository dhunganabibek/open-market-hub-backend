package com.openmarkethub.dtos;

public class UserDTO {

    private String username;

    private Integer id;

    private String password;

    public UserDTO() {
    }

    public UserDTO(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
