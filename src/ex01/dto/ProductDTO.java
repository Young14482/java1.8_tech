package ex01.dto;

import lombok.Data;
import ex01.model.Product;

@Data
public class ProductDTO {
    private int id;
    private String name;

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
    }
}
