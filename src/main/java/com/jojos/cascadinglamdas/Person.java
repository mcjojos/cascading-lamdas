package com.jojos.cascadinglamdas;

import java.time.LocalDate;
import java.util.Optional;

import static java.util.Objects.requireNonNull;

/**
 *  Step Builder pattern
 */
public final class Person {
 
    private final String firstName;
    private final String middleName;
    private final String lastName;

    private final LocalDate dateOfBirth;
 
    private Person(String firstName, String middleName, String lastName, LocalDate dateOfBirth) {
        this.firstName = requireNonNull(firstName, "firstName cannot be null");
        this.middleName = requireNonNull(middleName, "middleName cannot be null");
        this.lastName = requireNonNull(lastName, "lastName cannot be null");
        this.dateOfBirth = dateOfBirth;
    }
 
    public String getFirstName() {
        return firstName;
    }
 
    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public Optional<LocalDate> getDateOfBirth() {
        return Optional.ofNullable(dateOfBirth);
    }

    @FunctionalInterface
    public interface FirstNameBuilder {
        MiddleNameBuilder firstName(String firstName);
    }

    @FunctionalInterface
    public interface MiddleNameBuilder {
        LastNameBuilder middleName(String middleName);
    }

    @FunctionalInterface
    public interface LastNameBuilder {
        PersonBuilder lastName(String lastName);
    }

    public static FirstNameBuilder builder() {
        return firstName -> middleName -> lastName -> new PersonBuilder(firstName, middleName, lastName);
        // the following is equivalent to the above line
//        return firstName -> {
//            return middleName -> {
//                return lastName -> {
//                    return new PersonBuilder(firstName, middleName, lastName);
//                };
//            };
//        };
    }

    public static class PersonBuilder {

        private final String firstName;
        private final String middleName;
        private final String lastName;
        private LocalDate dateOfBirth;

        private PersonBuilder(String firstName, String middleName, String lastName) {
            this.firstName = firstName;
            this.middleName = middleName;
            this.lastName = lastName;
        }

        public PersonBuilder dateOfBirth(LocalDate birthday) {
            this.dateOfBirth = birthday;
            return this;
        }

        public Person build() {
            return new Person(firstName, middleName, lastName, dateOfBirth);
        }
    }
}

