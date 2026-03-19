class UserNotification implements OrderObserver {
    private User user;

    public UserNotification(User user) {
        this.user = user;
    }

    @Override
    public void update(String message) {
        System.out.println("Notify " + user.getName() + ": " + message);
    }
}