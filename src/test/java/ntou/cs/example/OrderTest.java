package ntou.cs.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    public void testShoppingCart() {
        User user = new User("U001", "Curry", new Address(), MemberLevel.GOLD);
        final Order order = new Order("P001", "2024-06-15", user);
        order.addOrderItem(new OrderItem("Lattee", 150, 4));
        order.addOrderItem(new OrderItem("Baggle", 80, 6));
        order.finalizeOrder();
        System.out.println(order);
        int total = order.getTotal();
        assertEquals(972, total);
    }
}