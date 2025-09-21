package access.ex;

import java.util.List;

public class ShoppingCart {
    private Item[] items = new Item[10];
    private int itemCount;

    public ShoppingCart() {
        itemCount = 0;
    }

    public void addItem(Item item){
        if(itemCount >= 10){
            System.out.println("장바구니가 가득 찼습니다.");
            return;
        }
        items[itemCount++] = item;
    }

    public void removeItem(){
        if(itemCount <= 0){
            System.out.println("장바구니가 비었습니다.");
            return;
        }

        items[itemCount--] = null;
    }

    public void displayItems(){
        if(items[0] == null){
            System.out.println("장바구니가 비었습니다.");
            return;
        }
        System.out.println("장바구니 상품 출력");

        int sum = 0;
        for(int i = 0; i < itemCount; i++){
            System.out.println("상품명: " + items[i].getProductName() + " 합계: " + items[i].getTotalPrice());
            sum += items[i].getTotalPrice();
        }

        System.out.println("전체 가격 합: " + sum);
    }
}
