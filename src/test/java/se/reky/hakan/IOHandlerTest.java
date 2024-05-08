package se.reky.hakan;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class IOHandlerTest {

    private IOHandler instantiateIOHandler(String dataForScanner) {
        Scanner scanner = new Scanner(dataForScanner);
        return new IOHandler(scanner);
    }


    @Test
    public void testHasNextInt() {
        IOHandler ioHandler = instantiateIOHandler("3");
        assertTrue(ioHandler.hasNextInt());
    }

}