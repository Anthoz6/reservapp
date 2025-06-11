package com.anthonycorp.reservapp;

import com.anthonycorp.reservapp.User.domain.Role.RoleEnum;
import com.anthonycorp.reservapp.User.infrastructure.model.Role;
import com.anthonycorp.reservapp.User.infrastructure.model.User;
import com.anthonycorp.reservapp.User.infrastructure.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;



@SpringBootApplication
public class ReservappApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservappApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UserRepository userRepository) {
		return	args -> {

			/* Create Roles */
			Role roleAdmin = Role.builder()
					.role(RoleEnum.ADMIN)
					.build();

			Role roleCustomer = Role.builder()
					.role(RoleEnum.CUSTOMER)
					.build();

			Role roleProvider = Role.builder()
					.role(RoleEnum.PROVIDER)
					.build();

			/* Create Users */
			User userAdmin = User.builder()
					.name("admin")
					.email("admin@gmail.com")
					.password("passwordexample1@")
					.enabled(true)
					.accountNonExpired(true)
					.accountNonLocked(true)
					.credentialsNonExpired(true)
					.role(roleAdmin)
					.build();

			User userCustomer = User.builder()
					.name("john doe")
					.email("example@gmail.com")
					.password("passwordexample10@")
					.enabled(true)
					.accountNonExpired(true)
					.accountNonLocked(true)
					.credentialsNonExpired(true)
					.role(roleCustomer)
					.build();

			User userProvider = User.builder()
					.name("taylor")
					.email("taylor@gmail.com")
					.password("passwordexample1@")
					.enabled(true)
					.accountNonExpired(true)
					.accountNonLocked(true)
					.credentialsNonExpired(true)
					.role(roleProvider)
					.build();

			userRepository.saveAll(List.of(userAdmin, userProvider, userCustomer));
		};
	}

}
