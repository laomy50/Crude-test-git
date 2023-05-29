package com.example.pazaSautiDb.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"username"}),
        @UniqueConstraint(columnNames = {"email"})
})
public class User {
    @Id
    private String fname;
    private String lname;
    private String username;
    private String email;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns ={ @JoinColumn(name = "role_id")})
    private Set<Role> roles;

//    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinTable(name = "assigned_master",
//            joinColumns = {@JoinColumn(name = "user_id")},
//            inverseJoinColumns ={ @JoinColumn(name = "report_id")})
//    private Set<Report> reports;
}
