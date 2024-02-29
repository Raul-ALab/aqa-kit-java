package org.raul;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.raul.lesson_2.tests.DriverSetUp;

public class AppTest extends TestCase {
    public static void main(String[] args) throws InterruptedException {
        DriverSetUp.setUpDriver();
    }
}
