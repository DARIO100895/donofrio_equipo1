package org.equipo1.transacciones.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Rol {

    private Integer idRol;
    private String nombreRol;

 /**Verificar el rol de Administrador*/

    public boolean esAdmin() {
        return "ROLE_ADMIN".equals(this.nombreRol);
    }

    public boolean esVendedor() {
        return "ROLE_VENDEDOR".equals(this.nombreRol);
    }
}
