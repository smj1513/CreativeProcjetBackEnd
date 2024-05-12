package _2024.creativeproject.repository;

import _2024.creativeproject.persistence.entity.UserEntity;
import _2024.creativeproject.persistence.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@SpringBootTest
class UserRepositoryTest {

	private static final Logger log = LoggerFactory.getLogger(UserRepositoryTest.class);
	@Autowired
	UserRepository userRepository;

	@Test
	@Transactional
	void 값확인(){
		Optional<UserEntity> test1 = userRepository.findByLoginId("test1");
		UserEntity userEntity = test1.get();
		log.info(userEntity.toString());
		Assertions.assertThat(test1.isPresent()).isTrue();
	}


}