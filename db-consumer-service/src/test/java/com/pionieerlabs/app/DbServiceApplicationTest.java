package com.pionieerlabs.app;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import org.junit.runner.RunWith;

@RunWith(SpringRunner.class)
@ContextConfiguration
@SpringBootTest
@ActiveProfiles("test")
public class DbServiceApplicationTest {
}
