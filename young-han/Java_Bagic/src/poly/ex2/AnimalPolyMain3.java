package poly.ex2;

public class AnimalPolyMain3 {
    public static void main(String[] args) {

        Animal animal1 = new Animal();
        animal1.sound();

        Animal[] animalArr = {new Dog(), new Cat(), new Cow(), new Duck(), new Pig()};

        for (Animal animal : animalArr) {
            soundAnimal(animal);
        }
    }

    private static void soundAnimal(Animal animal) {
        System.out.println("동물 소리 테스트 시작");
        animal.sound();
        System.out.println("동물 소리 테스트 종료");
    }
}
