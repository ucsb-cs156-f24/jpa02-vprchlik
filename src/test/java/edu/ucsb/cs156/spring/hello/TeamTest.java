package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
        assertEquals("test-team", team.getName());
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void hashCode_returns_same_for_equal_objects() {
        Team t1 = new Team("test-team");
        t1.addMember("Alice");
        Team t2 = new Team("test-team");
        t2.addMember("Alice");
        assertEquals(t1.hashCode(), t2.hashCode());
    }

    @Test
    public void hashCode_returns_different_for_unequal_objects() {
        Team t1 = new Team("team1");
        t1.addMember("Alice");
        Team t2 = new Team("team2");
        t2.addMember("Bob");
        assertNotEquals(t1.hashCode(), t2.hashCode());
    }

    @Test
    public void hashCode_specific_value_test() {
        Team t = new Team("test-team");
        int result = t.hashCode();
        int expectedResult = -1226298695;
        assertEquals(expectedResult, result);

    }


    @Test
    public void equals_same_object_returns_true() {
        assertTrue(team.equals(team));
    }

    @Test
    public void equals_different_class_returns_false() {
        String notATeam = "I am a string";
        assertFalse(team.equals(notATeam));
    }

    @Test
    public void equals_different_members_returns_false() {
        Team otherTeam = new Team("test-team");
        otherTeam.addMember("Alice");
        assertFalse(team.equals(otherTeam));
    }

    @Test
    public void equals_different_name_returns_false() {
        Team otherTeam = new Team("other-team");
        assertFalse(team.equals(otherTeam));
    }

    @Test
    public void equals_same_name_and_members_returns_true() {
        Team otherTeam = new Team("test-team");
        assertTrue(team.equals(otherTeam));
    }
}
