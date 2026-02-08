package org.equipo1.transacciones.infrastructure.adapter.input.rest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponseDto {

    private String token;
    private String role;

    public static AuthResponseDto fromToken( String role, String token) {
        return AuthResponseDto.builder()

                .role(role)
                .token(token)
                .build();
    }
}
