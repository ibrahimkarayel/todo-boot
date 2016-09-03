package com.pironix.utils;

import org.junit.*;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.Assert.*;

/**
 * Created by ibrahim KARAYEL
 *
 * @version 1.0
 * @since 9/3/2016.
 */
public class PassEncodingTest {

    public static BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    private static final String password_ = "123456";

    @BeforeClass
    public static void oneTimeSetUp() {
        // one-time initialization code
        System.out.println("@BeforeClass - oneTimeSetUp");
    }

    @AfterClass
    public static void oneTimeTearDown() {
        // one-time cleanup code
        System.out.println("@AfterClass - oneTimeTearDown");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("@Before - PassEncodingTest setUp");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("@After - PassEncodingTest tearDown");
    }

    @Test
    public void testPassword() {

        String pass=passwordEncoder.encode(password_);
        System.out.println(pass);
        Assert.assertNotEquals(pass, password_);

    }


}