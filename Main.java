public class Main {
    public static void main(String[] args) {

        User user = new User(1, "Jaya");
        Restaurant restaurant = new Restaurant(1, "Pizza Hut");

        Order order = OrderFactory.createOrder(101, user, restaurant);

        
        order.addObserver(new UserNotification(user));

        
        PaymentStrategy payment = new UpiPayment();
        order.makePayment(payment, 500);

        
        order.updateStatus(OrderStatus.PREPARING);
        order.updateStatus(OrderStatus.OUT_FOR_DELIVERY);
        order.updateStatus(OrderStatus.DELIVERED);
    }
}