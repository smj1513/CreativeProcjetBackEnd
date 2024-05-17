package _2024.creativeproject.utils.api;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class DomesticAPITest {

	private static final Logger log = LoggerFactory.getLogger(DomesticAPITest.class);
	@Autowired
	DomesticAPI domesticAPI;

	@BeforeEach
	void setUp() {
	}

	@AfterEach
	void tearDown() {
	}

	@Test
	void test(){
		String url = domesticAPI.getContentUrl("126.981611", "37.568477", 39);
		log.info(url);
	}

	@Test
	void test2(){
		try {
			log.info(domesticAPI.get("128.3902984", "36.1539771", 39).toString());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}