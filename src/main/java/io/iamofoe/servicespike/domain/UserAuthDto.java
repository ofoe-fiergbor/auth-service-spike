package io.iamofoe.servicespike.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder @Jacksonized
public class UserAuthDto {
    @JsonProperty("given_name")
    String givenName;
    @JsonProperty("family_name")
    String familyName;
    String email;
    String picture;

}
