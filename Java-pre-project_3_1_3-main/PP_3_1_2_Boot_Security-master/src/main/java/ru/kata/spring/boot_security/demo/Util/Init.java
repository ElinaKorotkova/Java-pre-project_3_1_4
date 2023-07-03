package ru.kata.spring.boot_security.demo.Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repository.RoleRepository;
import ru.kata.spring.boot_security.demo.service.RoleServiceImpl;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Component
public class Init {
    private final UserService userService;
    private final RoleRepository roleRepository;

    @Autowired
    public Init(UserService userService, RoleRepository roleRepository) {
        this.userService = userService;
        this.roleRepository = roleRepository;
    }

    @PostConstruct
    private void init() {

        Role roleUser = new Role("ROLE_USER");
        roleRepository.save(roleUser);

        Role roleAdmin = new Role("ROLE_ADMIN");
        roleRepository.save(roleAdmin);

        User user = new User();
        user.setFirstName("elina");
        user.setLastName("korotkova");
        user.setAge(25L);
        user.setEmail("elina@mail.ru");
        user.setPassword("100");
        user.setRoles(Collections.singletonList(roleUser));
        userService.add(user);

        User user1 = new User();
        user1.setFirstName("sergey");
        user1.setLastName("ivanov");
        user1.setAge(30L);
        user1.setEmail("sergey@mail.ru");
        user1.setPassword("200");
        user1.setRoles(Collections.singletonList(roleAdmin));
        userService.add(user1);
    }

}
