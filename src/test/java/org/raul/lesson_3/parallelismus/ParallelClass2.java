package org.raul.lesson_3.parallelismus;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


/*
 * Создать отдельный пакет parallelismus. В нем класс ParallelClass1.
 * В котором  создать тесты parallel1, parallel2, parallel3,
 * parallel4, parallel5. Создать класс ParallelClass2. В котором
 * создать тесты parallel6, parallel7, parallel8, parallel9, parallel10.
 * Создать отдельный xml файл testngParallelHome.xml в котором
 * параллельно будут прогоняться выше созданные два класса ParallelClass1
 * и ParallelClass2.
 * */
public class ParallelClass2 {

    @Test
    public void parallel6() throws InterruptedException {
        Thread.sleep(2000);
        assertTrue(true);
    }

    @Test
    public void parallel7() throws InterruptedException {
        Thread.sleep(2000);
        assertTrue(true);
    }

    @Test
    public void parallel8() throws InterruptedException {
        Thread.sleep(2000);
        assertTrue(true);
    }

    @Test
    public void parallel9() throws InterruptedException {
        Thread.sleep(2000);
        assertTrue(true);
    }

    @Test
    public void parallel10() throws InterruptedException {
        Thread.sleep(2000);
        assertTrue(true);
    }
}
