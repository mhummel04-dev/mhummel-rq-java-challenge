package com.challenge.api.model;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

public class EmployeeImpl implements Employee {
    /**
     * -- SETTER --
     * Set by either the Service or Data layer.
     *
     * @param uuid required non-null
     */
    @Setter
    @Getter
    UUID uuid;

    @Setter
    @Getter
    String firstName;

    @Setter
    @Getter
    String lastName;

    @Setter
    @Getter
    String fullName;

    @Setter
    @Getter
    Integer salary;

    @Setter
    @Getter
    Integer age;

    @Setter
    @Getter
    String jobTitle;

    @Setter
    @Getter
    String email;

    @Setter
    @Getter
    Instant contractHireDate;

    @Setter
    @Getter
    Instant contractTerminationDate;
}