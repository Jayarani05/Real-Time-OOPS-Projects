class OrderFactory {
    public static Order createOrder(int id, User user, Restaurant restaurant) {
        return new Order(id, user, restaurant);
    }
}