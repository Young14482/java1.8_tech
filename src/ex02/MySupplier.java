package ex02;

// 입력 없이 값을 반환(return)
@FunctionalInterface // 람다인터페이스로 사용할 때 붙이는 어노테이션
public interface MySupplier<T> {
    T get();
}
