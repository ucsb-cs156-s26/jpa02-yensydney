package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_returns_correct_result() {
        // Case 1
        assertEquals(team, team);

        // Case 2
        assertNotEquals(team, "t");

        // Case 3: T, T
        Team t1 = new Team("test-team");
        assertEquals(team, t1);

        // Case 3: T, F
        Team t2 = new Team("test-team");
        t2.addMember("Nini");
        assertNotEquals(team, t2);

        // Case 3: F, T
        team.addMember("Nini");
        Team t3 = new Team("other-team");
        t3.addMember("Nini");
        assertNotEquals(team, t3);

        // Case 3: F, F
        Team t4 = new Team("another-team");
        t4.addMember("Simon");
        assertNotEquals(team, t4);

        Team t5 = new Team();
        t5.setName("foo");
        t5.addMember("bar");
        Team t6 = new Team();
        t6.setName("foo");
        t6.addMember("bar");
        assertEquals(t5.hashCode(), t6.hashCode());

        Team t = new Team();
        int result = t.hashCode();
        int expectedResult = 1;
        assertEquals(expectedResult, result);

    }
}
