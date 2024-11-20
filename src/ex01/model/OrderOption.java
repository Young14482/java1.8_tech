package ex01.model;

public class OrderOption {
    private int id;
    private String optionName; // 하얀티
    private int qty; // 5개
    private int totalPrice; // 10000원

    private Product product;
    private Order order;

    public OrderOption(int id, String optionName, int qty, int totalPrice, Product product, Order order) {
        this.id = id;
        this.optionName = optionName;
        this.qty = qty;
        this.totalPrice = totalPrice;
        this.product = product;
        this.order = order;
    }

    public int getId() {
        return id;
    }

    public String getOptionName() {
        return optionName;
    }

    public int getQty() {
        return qty;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public Product getProduct() {
        return product;
    }

    public Order getOrder() {
        return order;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}