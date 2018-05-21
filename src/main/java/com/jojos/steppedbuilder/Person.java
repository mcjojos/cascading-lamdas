package com.jojos.steppedbuilder;

import java.time.LocalDate;
import java.util.Optional;

import static java.util.Objects.requireNonNull;

/**
 *  Step Builder pattern
 */
public final class Person {
 
    private final String firstName;
    private final String lastName;
 
    private final LocalDate dateOfBirth;
 
    private Person(String firstName, String lastName, LocalDate dateOfBirth) {
        this.firstName = requireNonNull(firstName, "firstName cannot be null");
        this.lastName = requireNonNull(lastName, "lastName cannot be null");
        this.dateOfBirth = dateOfBirth;
    }
 
    public String getFirstName() {
        return firstName;
    }
 
    public String getLastName() {
        return lastName;
    }
 
    public Optional<LocalDate> getDateOfBirth() {
        return Optional.ofNullable(dateOfBirth);
    }

    public static FirstNameBuilder builder() {
        return new PersonBuilder();
    }

    public static class PersonBuilder implements FirstNameBuilder, LastNameBuilder {

        private String firstName;
        private String lastName;

        private LocalDate dateOfBirth;

        private PersonBuilder() {
        }

        @Override
        public LastNameBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        @Override
        public PersonBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public PersonBuilder dateOfBirth(LocalDate birthday) {
            this.dateOfBirth = birthday;
            return this;
        }

        public Person build() {
            return new Person(firstName, lastName, dateOfBirth);
        }
    }
}

