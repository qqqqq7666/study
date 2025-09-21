package class1.ex;

public class ProductOrderMain {
    public static void main(String[] args) {
        ProductOrder tofu = new ProductOrder();
        ProductOrder kimchi = new ProductOrder();
        ProductOrder coke = new ProductOrder();
        tofu.productName = "tofu";
        tofu.price = 2000;
        tofu.quantity = 2;
        kimchi.productName = "kimchi";
        kimchi.price = 5000;
        kimchi.quantity = 1;
        coke.productName = "coke";
        coke.price = 1500;
        coke.quantity = 2;

        ProductOrder[] productOrders = new ProductOrder[]{tofu, kimchi, coke};
        int sum = 0;
        for(ProductOrder p : productOrders){
            System.out.println("name: " + p.productName + " | price: " + p.price + " | quantity: "+ p.quantity);
            sum += p.price * p.quantity;
        }

        System.out.println("total price: " + sum);
    }
}
