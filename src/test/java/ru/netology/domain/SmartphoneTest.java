package ru.netology.domain;

import org.junit.jupiter.api.Test;

public class SmartphoneTest {
    @Test
    public void shouldHaveAllFieldsAndMethodFromSuperClass() {
        Smartphone smartphone = new Smartphone();
    }

    @Test
    public void shouldCastFromBaseClass() {
        Product product = new Smartphone();
        if (product instanceof Smartphone) {
            Smartphone smartphone = (Smartphone) product;
        }
    }

//    @Test
//    public void shouldNotCastToDifferentClass() {
//        Product product = new Smartphone();
//        Book book = (Book) product;
//    }

    @Test
    public void shouldUseOverridedMethod() {
        Product product = new Smartphone();
        product.toString();
    }
}

