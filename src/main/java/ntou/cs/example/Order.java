package ntou.cs.example;

import java.util.ArrayList;

/*
 * Type: Entity and Aggregate Root
 */
public class Order {

    private final String id;
    private final String orderCreationTime;
    private final User user;
    private final ArrayList<OrderItem> items;
    private Address shipmentAddress;
    private DiscountPolicy discountPolicy;
    private int total;

    private UserService userService = new UserService();

    public Order(String orderId, String orderCreationTime, User user) {
        this.orderCreationTime = orderCreationTime;
        this.id = orderId;
        this.items = new ArrayList<OrderItem>();
        this.user = user;
    }

    public void addOrderItem(OrderItem item) {
        items.add(item);
    }

    public void setShipmentAddress(Address shipmentAddress) {
        this.shipmentAddress = shipmentAddress;
    }

    public void setDiscountPolicy(DiscountPolicy discountManager) {
        this.discountPolicy = discountManager;
    }

    private void setDefaultDiscountPolicy() {
        this.discountPolicy = userService.determineDiscountPolicy(user.getLevel());
    }

    private void setDefaultShipmentAddress() {
        this.shipmentAddress = user.getAddress();
    }

    private void calculateOrderTotal() {
        int originalTotal = 0;

        for (OrderItem item : items) {
            originalTotal += item.getPrice() * item.getQuantity();
        }

        if (discountPolicy != null) {
            total = discountPolicy.calculateTotal(originalTotal);
        } else {
            total = originalTotal;
        }
    }

    public void finalizeOrder() {

        if (shipmentAddress == null) {
            setDefaultShipmentAddress();
        }

        if (discountPolicy == null) {
            setDefaultDiscountPolicy();
        }

        calculateOrderTotal();
    }

    public void placeOrder() {

        if (shipmentAddress == null) {
            setDefaultShipmentAddress();
        }

        if (discountPolicy == null) {
            setDefaultDiscountPolicy();
        }

        calculateOrderTotal();
    }

    public String getId() {
        return id;
    }

    public Address getShipmentAddress() {
        return shipmentAddress;
    }

    public String getOrderCreationTime() {
        return orderCreationTime;
    }

    public ArrayList<OrderItem> getItems() {
        return items;
    }

    public String getUserId() {
        return user.getId();
    }

    public DiscountPolicy getDiscountPolicy() {
        return discountPolicy;
    }

    public int getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "Order [id=" + id + ", orderCreationTime=" + orderCreationTime + ", user=" + user + ", items=" + items
                + ", shipmentAddress=" + shipmentAddress + ", discountPolicy=" + discountPolicy + ", total=" + total
                + "]";
    }
}
