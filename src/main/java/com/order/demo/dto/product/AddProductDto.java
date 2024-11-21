package com.order.demo.dto.product;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AddProductDto {
    @NotBlank(message = "La dénomination d'un produit ne peut être nulle ou vide")
    private String label;

    @NotNull(message = "Le prix unitaire du produit ne peut être nul ")
    @Min(value = 1,message = "Le prix unitaire doit être supérieur ou égal à 1")
    private double  unitPrice;

    @NotNull(message = "La quantité d'un produit ne peut être nulle")
    @Min(value = 1,message = "La quantité d'un produit ne peut être supérieure ou égale à 1")
    private int quantity;
}
