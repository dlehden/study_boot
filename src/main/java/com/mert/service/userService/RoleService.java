package com.mert.service.userService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mert.model.userModel.Role;
import com.mert.repository.userInfoRepository.RoleRepository;
@Service("roleService")
public class RoleService {

	
	@Autowired
    private RoleRepository roleRepository;
	
	
	public RoleService(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}
	
	public List<Role> findAll(){
		List<Role> roles = new ArrayList<>();
		roles = roleRepository.findAll();
		return roles;
	}
	
	public Role findRole(int id){
		return roleRepository.findById(id).get();
	}
	
	public void save(Role role){
		roleRepository.save(role);
	}
	
	public void delete(int id){
		roleRepository.deleteById(id);

	}

	public Role findRole(String role) {
		// TODO Auto-generated method stub
		return roleRepository.findByRole(role);
	}

}
