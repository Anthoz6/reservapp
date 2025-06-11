package com.anthonycorp.reservapp;

import com.anthonycorp.reservapp.User.domain.Role.RoleEnum;
import com.anthonycorp.reservapp.User.infrastructure.model.RoleEntity;
import com.anthonycorp.reservapp.User.infrastructure.model.UserEntity;
import com.anthonycorp.reservapp.User.infrastructure.repository.RoleRepository;
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
	CommandLineRunner init(UserRepository userRepository, RoleRepository roleRepository) {
		return	args -> {

			/* Create Roles */
			RoleEntity roleEntityAdmin = roleRepository.save(RoleEntity.builder()
					.role(RoleEnum.ADMIN)
					.build());
			RoleEntity roleEntityCustomer = roleRepository.save(RoleEntity.builder()
					.role(RoleEnum.CUSTOMER)
					.build());
			RoleEntity roleEntityProvider = roleRepository.save(RoleEntity.builder()
					.role(RoleEnum.PROVIDER)
					.build());

			/* Create Users */
			UserEntity userEntityAdmin = UserEntity.builder()
					.name("admin")
					.email("admin@gmail.com")
					.password("passwordexample1@")
					.enabled(true)
					.accountNonExpired(true)
					.accountNonLocked(true)
					.credentialsNonExpired(true)
					.roleEntity(roleEntityAdmin)
					.build();

			UserEntity userEntityCustomer = UserEntity.builder()
					.name("john doe")
					.email("example@gmail.com")
					.password("passwordexample10@")
					.enabled(true)
					.accountNonExpired(true)
					.accountNonLocked(true)
					.credentialsNonExpired(true)
					.roleEntity(roleEntityCustomer)
					.build();

			UserEntity userEntityProvider = UserEntity.builder()
					.name("taylor")
					.email("taylor@gmail.com")
					.password("passwordexample1@")
					.enabled(true)
					.accountNonExpired(true)
					.accountNonLocked(true)
					.credentialsNonExpired(true)
					.roleEntity(roleEntityProvider)
					.build();

			userRepository.saveAll(List.of(userEntityAdmin, userEntityProvider, userEntityCustomer));
		};
	}

}
