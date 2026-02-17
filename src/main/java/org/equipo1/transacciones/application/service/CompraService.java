package org.equipo1.transacciones.application.service;

import lombok.RequiredArgsConstructor;
import org.equipo1.transacciones.application.ports.in.CompraUseCase;
import org.equipo1.transacciones.application.ports.out.CompraRepository;
import org.equipo1.transacciones.domain.model.Compra;
import org.equipo1.transacciones.domain.model.CompraDetalle;
import org.equipo1.transacciones.infrastructure.adapter.input.rest.dto.request.CompraRequestDto;
import org.equipo1.transacciones.infrastructure.adapter.input.rest.dto.response.CompraDetalleResponseDto;
import org.equipo1.transacciones.infrastructure.adapter.input.rest.dto.response.CompraResponseDto;
import org.equipo1.transacciones.infrastructure.adapter.output.messaging.CompraRabbitMQPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompraService implements CompraUseCase {

    private final CompraRepository compraRepository;
    private final CompraRabbitMQPublisher publisher;


    public CompraResponseDto registrarCompra(CompraRequestDto request) {

        List<CompraDetalle> detalles = request.getDetalles().stream()
                .map(d -> {
                    CompraDetalle detalle = CompraDetalle.builder()
                            .sku(d.getSku())
                            .numeroLote(d.getNumeroLote())
                            .fechaVencimiento(d.getFechaVencimiento())
                            .cantidad(d.getCantidad())
                            .costoUnitario(d.getCostoUnitario())
                            .build();

                    detalle.actualizarSubtotal();
                    return detalle;
                })
                .toList();

        Compra compra = Compra.builder()
                .fechaCompra(request.getFechaCompra())
                .proveedor(request.getProveedor())
                .estado("REGISTRADA")
                .detalles(detalles)
                .build();

        compra.actualizarTotal();


        Compra compraGuardada = compraRepository.guardarCompra(compra);


        return mapToResponse(compraGuardada);
    }


    public CompraResponseDto publicarCompra(Integer idCompra) {
        Compra compra = compraRepository.obtenerPorId(idCompra);
        if (compra == null) {
            throw new RuntimeException("Compra no encontrada con id: " + idCompra);
        }

        // Publicar evento RabbitMQ
        publisher.publicar(compra);

        // Cambiar estado a ENVIADA
        compra.setEstado("ENVIADA");
        compraRepository.guardarCompra(compra);

        return mapToResponse(compra);
    }


    private CompraResponseDto mapToResponse(Compra compra) {
        List<CompraDetalleResponseDto> detallesResponse = compra.getDetalles().stream()
                .map(d -> CompraDetalleResponseDto.builder()
                        .sku(d.getSku())
                        .numeroLote(d.getNumeroLote())
                        .fechaVencimiento(d.getFechaVencimiento())
                        .cantidad(d.getCantidad())
                        .costoUnitario(d.getCostoUnitario())
                        .subtotal(d.getSubtotal())
                        .build())
                .toList();

        return CompraResponseDto.builder()
                .idCompra(compra.getIdCompra())
                .fechaCompra(compra.getFechaCompra())
                .proveedor(compra.getProveedor())
                .total(compra.getTotal())
                .estado(compra.getEstado())
                .detalles(detallesResponse)
                .build();
    }
}
