import ex01.model.*;
import ex01.mydto.OrderResponse;
import ex01.mydto.ProductResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// 과제 부분 >> 내가 한 코드
public class App2 {
    public static void main(String[] args) {
        // 1. 상품 2개
        Product p1 = new Product(1, "바지");
        Product p2 = new Product(2, "티");

        List<Product> products = Arrays.asList(p1, p2);


        // 2. 옵션 4개 생성 (2-1, 2-2)
        ProductOption op1 = new ProductOption(1, "파란바지", 1000, 10, p1);
        ProductOption op2 = new ProductOption(2, "빨간바지", 2000, 10, p1);
        ProductOption op3 = new ProductOption(3, "노랑티", 1000, 10, p2);
        ProductOption op4 = new ProductOption(4, "하얀티", 2000, 10, p2);

        List<ProductOption> p1Option = Arrays.asList(op1, op2);
        List<ProductOption> p2Option = Arrays.asList(op3, op4);

        // 3. 구매
        Order or1 = new Order(1);
        OrderOption orOption1 = new OrderOption(1, "파란바지", 2, 2000, p1, or1);
        OrderOption orOption2 = new OrderOption(2, "빨간바지", 2, 4000, p1, or1);
        OrderOption orOption3 = new OrderOption(3, "하얀티", 5, 10000, p2, or1);
        List<OrderOption> or1Option = Arrays.asList(orOption1, orOption2, orOption3); // 이놈 활용

        op1.setQty(op1.getQty() - 2);
        op2.setQty(op2.getQty() - 2);
        op4.setQty(op4.getQty() - 5);


        Order or2 = new Order(2);
        OrderOption orOption4 = new OrderOption(4, "노랑티", 7, 7000, p2, or2);
        op3.setQty(op3.getQty() - 7);

        List<OrderOption> or2Option = Arrays.asList(orOption4);

        // 4. 상품 목록 화면
        // 상품번호, 상품이름 출력되게 sout
        List<ProductResponse.IndexDTO> list1 = new ArrayList<>();
        for (Product p : products) {
            list1.add(new ProductResponse.IndexDTO(p));
        }

        System.out.println("상품 목록");
        for (ProductResponse.IndexDTO i : list1) {
            System.out.print(i.getId() + "  ");
            System.out.println(i.getName());
        }
        System.out.println("----------");

        // 5. 상품 상세 화면(p1)
        System.out.println("상품 상세 화면");
        ProductResponse.DetailDTO detailDTO = new ProductResponse.DetailDTO(p1, p1Option);
        System.out.print(detailDTO.getId() + " ");
        System.out.println(detailDTO.getName());
        for (ProductResponse.DetailDTO.OptionDTO p : detailDTO.getOptions()) {
            System.out.println(p);
        }
        System.out.println("----------");
        /////////////////////

        // 6-1. 주문 확인 상세 화면 (or2)
        OrderResponse.OrderMainDTO orderMainDTO2 = new OrderResponse.OrderMainDTO(or2Option);
        System.out.println(orderMainDTO2);
        System.out.println("------------------");
        // 6-2. 주문 확인 상세 화면 (or1)
        OrderResponse.OrderMainDTO orderMainDTO = new OrderResponse.OrderMainDTO(or1Option);
        System.out.println(orderMainDTO);

    }
}