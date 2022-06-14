import lombok.Data;

import java.util.Objects;

@Data
public class Product {
    protected int id;
    protected String name;
    protected int price;


    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // метод определения соответствия товара product запросу search
    public boolean matches(Product product, String search) {
        return product.getName().contains(search);
    }


}


