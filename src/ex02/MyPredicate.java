package ex02;

// 입력을 받아서 논리값(boolean)을 리턴
public interface MyPredicate<T> {
    boolean apply(T t);
}
