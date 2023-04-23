package org.lecture;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * In the WindforceTest class there are the Unittest.
 */

public class WindforceTest {

    @Test
    public void consoleInput1() {
        InputStream sysIn = System.in;
        ByteArrayInputStream is = new ByteArrayInputStream("1\n".getBytes());
        System.setIn(is);
        Menu menu = new Menu();
        int guessCount = menu.consoleInput();
        assertTrue(guessCount == 1);
        System.setIn(sysIn);
    }

    @Test
    public void consoleInput2() {
        InputStream sysIn = System.in;
        ByteArrayInputStream is = new ByteArrayInputStream("2\n".getBytes());
        System.setIn(is);
        Menu menu = new Menu();
        int guessCount = menu.consoleInput();
        assertTrue(guessCount == 2);
        System.setIn(sysIn);
    }

    @Test
    public void consoleInput3() {
        InputStream sysIn = System.in;
        ByteArrayInputStream is = new ByteArrayInputStream("3\n".getBytes());
        System.setIn(is);
        Menu menu = new Menu();
        int guessCount = menu.consoleInput();
        assertTrue(guessCount == 3);
        System.setIn(sysIn);
    }

    @Test
    public void consoleInput4() {
        InputStream sysIn = System.in;
        ByteArrayInputStream is = new ByteArrayInputStream("4\n".getBytes());
        System.setIn(is);
        Menu menu = new Menu();
        int guessCount = menu.consoleInput();
        assertTrue(guessCount == 4);
        System.setIn(sysIn);
    }

    @Test
    public void consoleInputInvalid() {
        InputStream sysIn = System.in;
        ByteArrayInputStream is = new ByteArrayInputStream("5\n".getBytes());
        System.setIn(is);
        Menu menu = new Menu();
        int guessCount = menu.consoleInput();
        assertEquals(1, guessCount);
        System.setIn(sysIn);
    }

    @Test
    public void askWindforce() {
        InputStream sysIn = System.in;
        ByteArrayInputStream is = new ByteArrayInputStream("5.5\n".getBytes());
        System.setIn(is);
        Menu menu = new Menu();
        double result = menu.askWindforce();
        assertEquals(5.5, result);
        System.setIn(sysIn);
    }

    @Test
    public void askWindforceInvalid() {
        InputStream sysIn = System.in;
        ByteArrayInputStream is = new ByteArrayInputStream("2\n".getBytes());
        System.setIn(is);
        Menu menu = new Menu();
        double result = menu.askWindforce();
        assertEquals(5.5, result);
        System.setIn(sysIn);
    }

    @Test
    public void askWindforceEmptyInput() {
        InputStream sysIn = System.in;
        ByteArrayInputStream is = new ByteArrayInputStream("\n".getBytes());
        System.setIn(is);
        Menu menu = new Menu();
        double result = menu.askWindforce();
        assertNull(result);
        System.setIn(sysIn);
    }

    @Test
    public void askTemp() {
        InputStream sysIn = System.in;
        ByteArrayInputStream is = new ByteArrayInputStream("2\n".getBytes());
        System.setIn(is);
        Menu menu = new Menu();
        double result = menu.askTemp();
        assertEquals(2, result);
        System.setIn(sysIn);
    }

    @Test
    public void askTempInvalid() {
        InputStream sysIn = System.in;
        ByteArrayInputStream is = new ByteArrayInputStream("4\n".getBytes());
        System.setIn(is);
        Menu menu = new Menu();
        double result = menu.askTemp();
        assertEquals(2, result);
        System.setIn(sysIn);
    }

    @Test
    public void askStation() {
        InputStream sysIn = System.in;
        ByteArrayInputStream is = new ByteArrayInputStream("Donnerskirchen\n".getBytes());
        System.setIn(is);
        Menu menu = new Menu();
        String result = menu.askStation();
        assertEquals("Donnerskirchen", result);
        System.setIn(sysIn);
    }

    @Test
    public void askStationInvalid() {
        InputStream sysIn = System.in;
        ByteArrayInputStream is = new ByteArrayInputStream("Schützen\n".getBytes());
        System.setIn(is);
        Menu menu = new Menu();
        String result = menu.askStation();
        assertEquals("Donnerskirchen", result);
        System.setIn(sysIn);
    }

    @Test
    public void askBearing() {
        InputStream sysIn = System.in;
        ByteArrayInputStream is = new ByteArrayInputStream("N\n".getBytes());
        System.setIn(is);
        Menu menu = new Menu();
        String result = menu.askBearing();
        assertEquals("N", result);
        System.setIn(sysIn);
    }

    @Test
    public void askBearingInvalid() {
        InputStream sysIn = System.in;
        ByteArrayInputStream is = new ByteArrayInputStream("S\n".getBytes());
        System.setIn(is);
        Menu menu = new Menu();
        String result = menu.askBearing();
        assertEquals("N", result);
        System.setIn(sysIn);
    }

    @Test
    public void askBearingEmptyInput() {
        InputStream sysIn = System.in;
        ByteArrayInputStream is = new ByteArrayInputStream("\n".getBytes());
        System.setIn(is);
        Menu menu = new Menu();
        String result = menu.askBearing();
        assertNull(result);
        System.setIn(sysIn);
    }

    @Test
    public void askWeather() {
        InputStream sysIn = System.in;
        ByteArrayInputStream is = new ByteArrayInputStream("sonnig\n".getBytes());
        System.setIn(is);
        Menu menu = new Menu();
        String result = menu.askWeather();
        assertEquals("sonnig", result);
        System.setIn(sysIn);
    }

    @Test
    public void askWeatherInvalid() {
        InputStream sysIn = System.in;
        ByteArrayInputStream is = new ByteArrayInputStream("schnee\n".getBytes());
        System.setIn(is);
        Menu menu = new Menu();
        String result = menu.askWeather();
        assertEquals("sonnig", result);
        System.setIn(sysIn);
    }

    @Test
    public void testPrintWindforce() {
        // Prepare
        ArrayList<Windforce> list = new ArrayList<>();
        Windforce f1 = new Windforce();
        f1.setId(1);
        f1.setWindforce(5);
        f1.setDateTime(new Date());
        f1.setStation("Station 1");
        f1.setTemp(20.5);
        f1.setBearing("N");
        f1.setWeather("Cloudy");
        list.add(f1);
        Windforce f2 = new Windforce();
        f2.setId(2);
        f2.setWindforce(10);
        f2.setDateTime(new Date());
        f2.setStation("Station 2");
        f2.setTemp(25.0);
        f2.setBearing("S");
        f2.setWeather("Sunny");
        list.add(f2);

        // Execute
        Main.printWindforce(list);
    }
}
