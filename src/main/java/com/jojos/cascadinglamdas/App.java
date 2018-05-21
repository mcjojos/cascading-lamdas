package com.jojos.cascadinglamdas;
/**
 * todo: create javadoc
 * <p>
 * Created by karanikasg@gmail.com.
 */
public class App {

    public static void main(String[] args) {

        Person person = Person.builder()
                .firstName("John")
                .middleName("jojos")
                .lastName("Doe")
                .build();

    }
}
