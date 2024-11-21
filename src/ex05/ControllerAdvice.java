package ex05;

public class ControllerAdvice {

    public void process(RuntimeException e) {
        System.out.println("에러 공톨 처리: " + e.getMessage());
    }
}
