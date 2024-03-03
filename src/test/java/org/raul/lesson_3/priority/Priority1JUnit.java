package org.raul.lesson_3.priority;


import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertTrue;


/*
 * Рауль: Поскольку в требованиях к задаче было указано предоставить
 * 'как минимум' два решения для данной задачи, я добавил еще
 * один отдельный класс, чтобы предоставить третье дополнительное
 * решение с помощью JUnit.
 * Не смог придумать, как лучше предоставить решения как для JUnit,
 * так и для TestNG в одном классе, чтобы избежать проблем с читаемостью,
 * поэтому решил использовать дополнительный отдельный класс.
 * */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Priority1JUnit {

    @Test
    @Order(7)
    public void a() {
        assertTrue(true);
    }

    @Test
    @Order(6)
    public void b() {
        assertTrue(true);
    }

    @Test
    @Order(5)
    public void c() {
        assertTrue(true);
    }

    @Test
    @Order(4)
    public void d() {
        assertTrue(true);
    }

    @Test
    @Order(3)
    public void e() {
        assertTrue(true);
    }

    @Test
    @Order(2)
    public void f() {
        assertTrue(true);
    }

    @Test
    @Order(1)
    public void g() {
        assertTrue(true);
    }
}
