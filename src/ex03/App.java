package ex03;

import java.util.Optional;

// 옵셔널: null 처리
public class App {
    public static void main(String[] args) {
        String data1 = null;
        Optional<String> op1 = Optional.ofNullable(data1);
        // .isPresent() >> 안에 값이 존재하면 true
        if (op1.isPresent()) {
            String r1 = op1.get();
            System.out.println("r1: " + r1);
        }
        String data2 = null;
        //
        String r2 = Optional.ofNullable(data2).orElseGet(() -> "없음");
        System.out.println("r2: " + r2);

        String data3 = "대충 아무 값";
        // null이면 예외 던지기
        String r3 = Optional.ofNullable(data3).orElseThrow(() -> new RuntimeException("값이 없음, 확인 바람"));
        System.out.println("r3: " + r3);
    }
}
