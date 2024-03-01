package org.raul.lesson_2.scripts;

import lombok.AccessLevel;
import lombok.Getter;
import org.openqa.selenium.WebElement;

/* 3)Написать метод в параметры которого принимаются два ВебЭлемента.*/
@Getter(AccessLevel.PRIVATE)
public class ElementComparison {
    private WebElement elementA;
    private WebElement elementB;

    public void compareElements(WebElement elementA, WebElement elementB) {
        this.elementA = elementA;
        this.elementB = elementB;

        System.out.println("Above on page: " + aboveOnPage().getText());
        System.out.println("Left on page: " + leftOnPage().getText());
        System.out.println("Occupies larger area: " + largerArea().getText());
    }

    /* 3.(a) ...какой из двух элементов располагается выше на странице*/
    public WebElement aboveOnPage() {
        int aLocationY = getElementA().getLocation().y;
        int bLocationY = getElementB().getLocation().y;

        return (aLocationY < bLocationY) ? getElementA() : getElementB();
    }

    /* 3.(b) ...какой из элементов располагается левее на странице*/
    public WebElement leftOnPage() {
        int aLocationX = getElementA().getLocation().x;
        int bLocationX = getElementB().getLocation().x;

        return (aLocationX < bLocationX) ? getElementA() : getElementB();
    }

    /* 3.(c) ...а также какой из элементов занимает большую площадь.*/
    public WebElement largerArea() {
        int areaElementA = getElementA().getSize().width * getElementA().getSize().height;
        int areaElementB = getElementB().getSize().width * getElementB().getSize().height;

        return (areaElementA > areaElementB) ? getElementA() : getElementB();
    }
}
