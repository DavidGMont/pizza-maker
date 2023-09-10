package com.pizzability.maker.service.dto;

import lombok.Data;

@Data
public class UpdatePizzaPriceDTO {
    private int pizzaId;
    private double newPrice;
}
