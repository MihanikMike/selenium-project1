package com.cydeo.tests.day9_review_javafaker_driverUtil;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class JavaFakerPractice {

    @Test
    public void test_javaFaker() {

        Faker faker = new Faker();

        System.out.println("faker.name().firstName() = " + faker.name().firstName());

        System.out.println("faker.name().lastName() = " + faker.name().lastName());

        System.out.println("faker.name().fullName() = " + faker.name().fullName());

        System.out.println("faker.address().city() = " + faker.address().city());

        System.out.println("faker.address().zipCode() = " + faker.address().zipCode());

        System.out.println("faker.numerify(\"###-###-####\") = " + faker.numerify("215-###-####"));

        System.out.println("faker.numerify(\"####-####-####-####\") = " + faker.numerify("####-####-####-####"));

        System.out.println("faker.letterify(\"???????\") = " + faker.letterify("???????"));

        System.out.println("faker.bothify(\"###???#?#?#\") = " + faker.bothify("###???#?#?#"));

        System.out.println("faker.chuckNorris().fact() = " +
                faker.chuckNorris().fact().replace("Chuck Norris", "Igor"));

    }
}
