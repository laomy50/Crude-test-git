package com.example.pazaSautiDb.Services;

import com.example.pazaSautiDb.Model.Role;
import com.example.pazaSautiDb.Model.User;
import com.example.pazaSautiDb.Repository.RoleRepository;
import com.example.pazaSautiDb.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    public User registerNewUser(User user){

        Role role =  roleRepository.findById("User").get();
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRoles(roles);
        user.setPassword(getEncordedPassword(user.getPassword()));
        return userRepository.save(user);
    }

    public void initRolesAndUser(){
        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin area");
        roleRepository.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("User Member Area");
        roleRepository.save(userRole);

        User adminUser = new User();
        adminUser.setFname("admin");
        adminUser.setLname("admin");
        adminUser.setUsername("admin123");
        adminUser.setPassword(getEncordedPassword("admin@123"));
        Set<Role> adminRoles = new  HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRoles((adminRoles));
        userRepository.save(adminUser);

        User user = new User();
        user.setFname("Ashraf");
        user.setLname("Hakim");
        user.setUsername("ashraf123");
        user.setPassword(getEncordedPassword("ashraf@123"));
        Set<Role> userRoles = new  HashSet<>();
        userRoles.add(adminRole);
        user.setRoles(userRoles);
        userRepository.save(user);
    }

    public String getEncordedPassword(String password){
        return passwordEncoder.encode(password);
    }
}
