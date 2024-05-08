package se.reky.hakan;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.reky.hakan.model.Player;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class PlayerInteractionTest {

    private Player player;


    private PlayerInteraction instantiatePlayerInteraction(String dataForScanner) {
        Scanner scanner = new Scanner(dataForScanner);
        IOHandler ioHandler = new IOHandler(scanner);
        return new SimplePlayerInteraction(ioHandler);
    }

    @BeforeEach
    public void instantiatePlayer() {
        player = new Player();
    }

    @Test
    public void testSetupPlayer() {
        PlayerInteraction playerInteraction = instantiatePlayerInteraction("Baba Yaga");
        playerInteraction.setupPlayer(player);
        assertEquals("Baba Yaga",player.getName());
    }

    @Test
    public void testUpdatePlayerHealth() {
        PlayerInteraction playerInteraction = instantiatePlayerInteraction("");
        playerInteraction.updatePlayerHealth(player,50);
        assertEquals(50, player.getHp());
    }


}