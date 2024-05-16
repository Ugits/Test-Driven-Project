package se.reky.hakan.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ActorTest {

    private Actor player;
    private Actor goblin;

    @BeforeEach
    public void instantiateActor() {
        player = new Player("Jonas", 100, 20);
        goblin = new Goblin("Baba Yaga", 50, 30);
    }

    @Test
    public void testAttack() {
        player.attack(goblin);
        assertEquals(30, goblin.getHp());
    }




}