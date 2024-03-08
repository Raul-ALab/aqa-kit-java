package org.raul.lesson_3.grouping;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/*
 * Task2: Создать отдельный пакет grouping. В нем класс Groups.
 * В этом классе создать тесты one, two, three, four, five, six,
 * seven, eight.
 * Сделать так, чтобы тесты, которые называются нечетными числами
 * принадлежали группе first, а тесты четных чисел принадлежали
 * группе second. Создать отдельный xml файл testngGroupingHome.xml
 * в котором последовательно прогонялись вначале файлы группы first,
 * а после файлы группы second.
 * P.S. В каждой группе тесты должны проходить в порядке возрастания.
 * */
public class Groups {

    @Test(priority = 1, groups = "first")
    public void one() {
        assertTrue(true);
    }

    @Test(priority = 2, groups = "second", dependsOnGroups = "first")
    public void two() {
        assertTrue(true);
    }

    @Test(priority = 3, groups = "first")
    public void three() {
        assertTrue(true);
    }

    @Test(priority = 4, groups = "second", dependsOnGroups = "first")
    public void four() {
        assertTrue(true);
    }

    @Test(priority = 5, groups = "first")
    public void five() {
        assertTrue(true);
    }

    @Test(priority = 6, groups = "second", dependsOnGroups = "first")
    public void six() {
        assertTrue(true);
    }

    @Test(priority = 7, groups = "first")
    public void seven() {
        assertTrue(true);
    }

    @Test(priority = 8, groups = "second", dependsOnGroups = "first")
    public void eight() {
        assertTrue(true);
    }
}
