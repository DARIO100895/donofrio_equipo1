package org.equipo1.transacciones.infrastructure.adapter.input.rest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.equipo1.transacciones.infrastructure.adapter.input.rest.dto.LoteDto;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductoLotesResponseDto {

    private UUID sku;
    private String producto;
    private List<LoteDto> lotes;
}
