package com.cmpe281.smartcargonode;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SmartcargonodeApplicationTests {

	private static final Logger logger = LogManager.getLogger(SmartcargonodeApplicationTests.class);

	@Test
	void contextLoads() {
		logger.info("@@@@ contextLoads() -- here!");
	}
}
