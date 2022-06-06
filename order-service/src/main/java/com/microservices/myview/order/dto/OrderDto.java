package com.microservices.myview.order.dto;

import com.microservices.myview.order.model.OrderLineItems;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private List<OrderLineItems> orderLineItemsList;
}
