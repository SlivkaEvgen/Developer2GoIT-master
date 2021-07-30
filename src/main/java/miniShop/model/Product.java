package miniShop.model;
import lombok.Data;

@Data
public final class Product implements BaseModel<String>{

    private final String name;

    private final double price;

    private final double discountPrice;

    private final double amount;

    private final double discountAmount;

    @Override
    public String getId() {
        return name;
    }
}
