package ru.mishkin.lab4.classes;

import org.junit.Test;
import static org.junit.Assert.*;

public class VolumeTest {

@Test
public void testVolume() {
System.out.println("Проверка метода volume()");
Volume p = new Volume(3,4);
assertEquals(5, p.distance(0,0),0.00001);
}
}

