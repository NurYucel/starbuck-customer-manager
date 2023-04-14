package com.example.starbuckcustomermanager.business.dto.response.get;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GetCustomerResponse {
    private int id;
    private String firstName;
    private String lastName;
    private LocalDate birthYear;
    private String nationalityIdentity;
}
