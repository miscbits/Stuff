package com.zipcodewilmington.looplabs;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import parsing_json.ElementCollection;
import parsing_json.ElementCollectionInitializerTest;
import parsing_json.ElementCollectionTest;
import parsing_json.ElementTest;
import user_management.UserCollectionInitializerTest;
import user_management.UserCollectionTest;
import user_management.UserTest;
import user_management.security.AuthenticatorTest;
import user_management.security.Password;
import user_management.security.PasswordTest;

/**
 * Created by leon on 1/28/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying this class.
 */
@RunWith(Suite.class)

@Suite.SuiteClasses({
        ElementTest.class,
        ElementCollectionTest.class,
        ElementCollectionInitializerTest.class,
        PasswordTest.class,
        AuthenticatorTest.class,
        UserCollectionInitializerTest.class,
        UserCollectionTest.class,
        UserTest.class
})
public class TestSuite {
}