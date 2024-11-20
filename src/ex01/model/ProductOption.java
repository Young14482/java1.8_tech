package ex01.model;

public class ProductOption {
    private int id;
    private String name;
    private int price;
    private int qty;
    private Product product;

    public ProductOption(int id, String name, int price, int qty, Product product) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.qty = qty;
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}