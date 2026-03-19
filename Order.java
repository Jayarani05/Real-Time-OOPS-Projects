import java.util.ArrayList;
import java.util.List;

class Order {
    private int id;
    private User user;
    private Restaurant restaurant;
    private OrderStatus status;
    private List<OrderObserver> observers = new ArrayList<>();

    public Order(int id, User user, Restaurant restaurant) {
        this.id = id;
        this.user = user;
        this.restaurant = restaurant;
        this.status = OrderStatus.CREATED;
    }

    public void addObserver(OrderObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers() {
        for (OrderObserver observer : observers) {
            observer.update("Order " + id + " is " + status);
        }
    }

    public void updateStatus(OrderStatus status) {
        this.status = status;
        notifyObservers();
    }

    public void makePayment(PaymentStrategy paymentStrategy, double amount) {
        paymentStrategy.pay(amount);
    }
}