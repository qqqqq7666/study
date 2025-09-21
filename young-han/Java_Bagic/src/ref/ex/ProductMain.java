package ref.ex;

import class1.ex.ProductOrder;
import java.util.Scanner;

public class ProductMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input quantity");
        int n = scanner.nextInt();
        ProductOrder[] productOrder = new ProductOrder[n];
        int sum = 0;
        for(int i = 0; i < n; i++){
            System.out.println("ordering number: " + (i + 1));
            System.out.print("product name: ");
            String name = scanner.next();
            System.out.print("price: ");
            int price = scanner.nextInt();
            System.out.print("quantity: ");
            int quantity = scanner.nextInt();
            productOrder[i] = product(name, price, quantity);
            sum += price * quantity;
        }

        for(ProductOrder p : productOrder)
            printProduct(p);

        System.out.println("total price: " + sum);

    }

    static ProductOrder product(String name, int price, int quantity){
        ProductOrder p = new ProductOrder();
        p.productName = name;
        p.price = price;
        p.quantity = quantity;

        return p;
    }

    static void printProduct(ProductOrder p){
        System.out.println("product name: " + p.productName + " price: " + p.price + " quantity: " + p.quantity);
    }
}
