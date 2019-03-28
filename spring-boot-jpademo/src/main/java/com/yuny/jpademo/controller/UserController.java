package com.yuny.jpademo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.yuny.jpademo.pojo.User;
import com.yuny.jpademo.repository.UserRepository;


@RestController
public class UserController {
	@Autowired
	private UserRepository userRepository;

	@PostMapping("/login")
	public User personListByName(@RequestBody String username) {
		User n = userRepository.findByUsernameIs(username);
		 return n;
	}

	@PostMapping("/getName")
	public User personByName(@RequestBody String name) {
		User n = userRepository.findByName(name);
		return n;
	}

    @PostMapping("/change")
    public User personChange(@RequestBody User user) {
        User n = userRepository.findByName(user.getName());
        n.setPassword(user.getPassword());
        userRepository.save(n);
        return n;
    }
}
