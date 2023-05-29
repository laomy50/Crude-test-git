package com.example.pazaSautiDb.Services;

import com.example.pazaSautiDb.Model.Role;
import com.example.pazaSautiDb.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role createNewRole(Role role){
        return roleRepository.save(role);
    }
}
