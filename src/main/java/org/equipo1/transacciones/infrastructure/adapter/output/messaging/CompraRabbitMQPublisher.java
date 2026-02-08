package org.equipo1.transacciones.infrastructure.adapter.output.messaging;

import lombok.RequiredArgsConstructor;
import org.equipo1.transacciones.domain.model.Compra;
import org.equipo1.transacciones.infrastructure.adapter.output.messaging.dto.CompraIngresadaEvent;
import org.equipo1.transacciones.infrastructure.adapter.output.persistence.mapper.CompraIngresadaEventMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CompraRabbitMQPublisher {


    private final RabbitTemplate rabbitTemplate;
    private final String exchange = "ventas_compras.exchange";
    private final String routingKey = "compra.ingresada";

    public void publicar(Compra compra) {
        CompraIngresadaEvent event = CompraIngresadaEventMapper.fromDomain(compra);
        rabbitTemplate.convertAndSend(exchange, routingKey, event);
    }


}
