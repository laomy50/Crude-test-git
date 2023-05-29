package com.example.pazaSautiDb.Dto;

import com.example.pazaSautiDb.Model.User;
import lombok.Data;

@Data
public class JwtResponce {

    public String token;
    private User user;
    private String jwtToken;

    public JwtResponce(User user, String newGeneratedToken) {
        this.user = user;
        this.jwtToken = jwtToken;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
