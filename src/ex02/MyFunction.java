package ex02;

// 입력을 받아서 결과를 반환
// T는 파라미터의 타입, R은 리턴 타입
public interface MyFunction<T,R> {
    R apply(T t);
}
