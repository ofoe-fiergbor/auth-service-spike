package io.iamofoe.servicespike.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuthDto {
    private String idTokenString;
}
