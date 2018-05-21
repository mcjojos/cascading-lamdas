package com.jojos.steppedbuilder;

import java.time.LocalDate;
import java.time.Month;

/**
 * todo: create javadoc
 * <p>
 * Created by karanikasg@gmail.com.
 */
public class App {

    public static void main(String[] args) {

        Person person1 = ((Person.PersonBuilder)Person.builder()).build();

        Person person = Person.builder()
                .firstName("John")
                .lastName("Doe")
                .build();


        Person personWithDate = Person.builder()
                .firstName("John")
                .lastName("Doe")
                .dateOfBirth(LocalDate.of(1998, Month.DECEMBER, 19))
                .build();
    }
}
