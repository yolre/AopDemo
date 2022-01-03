package com.yolre.delegatingintroductioninterceptor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
    private String name;
    private String phoneNumber;
    private String email;
}
