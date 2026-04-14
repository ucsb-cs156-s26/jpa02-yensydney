package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("Nini", Developer.getName());
    }

    @Test
        public void getGithubId_returns_correct_githubId() {
            assertEquals("Nini", Developer.getGithubId());
        }

    @Test
        public void getTeam_returns_team_with_correct_name() {
            Team  t = Developer.getTeam();
            assertEquals("s26-11", t.getName());
        }
    
    @Test
        public void getTeam_returns_team_with_correct_members() {
            Team  t = Developer.getTeam();
            assertTrue(t.getMembers().contains("Anish"),"Team should contain Anish");
            assertTrue(t.getMembers().contains("Brian H"),"Team should contain Brian H");
            assertTrue(t.getMembers().contains("Nini"),"Team should contain Nini");
            assertTrue(t.getMembers().contains("Rushabh"),"Team should contain Rushabh");
            assertTrue(t.getMembers().contains("Tien"),"Team should contain Tien");
            assertTrue(t.getMembers().contains("Wilson"),"Team should contain Wilson");
        }
}
