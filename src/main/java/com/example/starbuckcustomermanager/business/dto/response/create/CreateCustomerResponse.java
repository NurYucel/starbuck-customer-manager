package com.example.starbuckcustomermanager.business.dto.response.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateCustomerResponse {
    private int id;
    private String firstName;
    private String lastName;
    private LocalDate birthYear;
    private String nationalityIdentity;
}
