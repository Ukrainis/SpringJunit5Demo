package com.example.demo;

import org.junit.jupiter.api.*;
import lombok.extern.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;

import com.example.demo.steps.FirstFeatureSteps;

@Slf4j
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT,
classes = DemoApplication.class)
@ActiveProfiles(resolver=SpringActiveProfileResolver.class)
public class DemoApplicationTests {
	
	@Autowired
	protected FirstFeatureSteps firstFeatureSteps;
	
	@BeforeEach
	public void setUp(TestInfo testInfo) {
		log.info("Now test will be: {}", testInfo.getDisplayName());
	}
}
