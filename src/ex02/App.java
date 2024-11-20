package ex02;


// 1. 람다는 인터페이스로 만든다
// 2. 인터페이스에는 메서드가 하나만 존재해야 한다.
// 3. 메서드가 인터페이스를 매개변수(파라미터)로 받고 있으면, 행위를 주세요!
// 4. 람다에서는 매개변수에 타입이 생략 가능하다.
// 5. @FunctionalInterface로 람다 인터페이스 표시 가능

// 람다식과 람다표현식의 차이점 >> 람다표현식은 return을 하지만 람다식은 안함 >> return의 유무
public class App {
    public static void main(String[] args) {
        // 람다식
        MyConsumer<Integer> r1 = (data) -> {
            System.out.println("소비할 데이터: " + data);
        };
        r1.accept(1);

        // 람다표현식
        MySupplier<String> r2 =() -> {return "good";};
        MySupplier<String> r3 =() -> "good"; // return은 생략가능
        String msg = r3.get();
        System.out.println(msg);

        MyFunction<Integer, Double> r4 = (x) -> {
            return x / 1.5;
        };
        System.out.println(r4.apply(3));

        MyPredicate<Integer> r5 = (x) -> {
            return true;
        };
    }
}
