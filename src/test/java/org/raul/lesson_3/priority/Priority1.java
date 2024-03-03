package org.raul.lesson_3.priority;


import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/*
 * Task1: Создать отдельный пакет priority. В нем класс Priority1.
 * В этом классе создать тесты a, b, c, d, e, f, g. Сделать так,
 * чтобы при запуске данного класса эти тесты проходили в порядке
 * обратном алфавитному. Придумать по крайней мере два способа,
 * как это можно сделать.
 * */
public class Priority1 {

    @Test(priority = 7)
//    @Test(dependsOnMethods = "b")
    public void a() {
        assertTrue(true);
    }

    @Test(priority = 6)
//    @Test(dependsOnMethods = "c")
    public void b() {
        assertTrue(true);
    }

    @Test(priority = 5)
//    @Test(dependsOnMethods = "d")
    public void c() {
        assertTrue(true);
    }

    @Test(priority = 4)
//    @Test(dependsOnMethods = "e")
    public void d() {
        assertTrue(true);
    }

    @Test(priority = 3)
//    @Test(dependsOnMethods = "f")
    public void e() {
        assertTrue(true);
    }

    @Test(priority = 2)
//    @Test(dependsOnMethods = "g")
    public void f() {
        assertTrue(true);
    }

    @Test(priority = 1)
//    @Test
    public void g() {
        assertTrue(true);
    }
}
