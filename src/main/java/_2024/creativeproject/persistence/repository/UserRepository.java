package _2024.creativeproject.persistence.repository;

import _2024.creativeproject.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, String> {

	Optional<UserEntity> findByLoginId(String userId);
}
