package io.iamofoe.servicespike.domain.repository;

import io.iamofoe.servicespike.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
