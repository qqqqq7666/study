package access.ex;

public class ShoppingCartMain {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        Item item1 = new Item("마늘", 2000, 2);
        Item item2 = new Item("상추", 3000, 4);
        Item item3 = new Item("ddd", 2222, 90);
        cart.addItem(item1);
        cart.addItem(item2);
        cart.addItem(item3);
        cart.removeItem();
        cart.displayItems();
    }
}
