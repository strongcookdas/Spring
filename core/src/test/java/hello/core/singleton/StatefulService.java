package hello.core.singleton;

public class StatefulService {

//    private int price;

    // 싱글톤에서 공유되는 필드는 생성하면 안된다.
    public int order(String name, int price){
        System.out.println("name = " + name + " price = " + price);
//        this.price = price;
        return price;
    }

//    public int getPrice(){
//        return price;
//    }
}
