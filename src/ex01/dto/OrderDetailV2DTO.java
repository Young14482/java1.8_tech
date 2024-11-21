package ex01.dto;

import ex01.model.OrderOption;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

@Data
public class OrderDetailV2DTO {
    private int orderId;
    private List<OrderProductDTO> products = new ArrayList<>();
    private int sumPrice;

    public OrderDetailV2DTO(List<OrderOption> options) {
        // 1. orderId
        this.orderId = options.get(0).getOrder().getId();

        // 2. sumPrice
        this.sumPrice = options.stream()
                .mapToInt(value -> value.getTotalPrice())
                .sum();
        // 3. products
        // 3.1. List<OrderOption> options 물가에 던지기
        // 3.2. productId로 그룹화 (or1,or2) (or3)
        // 3.3. OrderProductDTO를 그룹개수만큼 생성해서 만들어주기
        options.stream()
                .collect(Collectors.groupingBy(product -> product.getOrder().getId()))
                .values()
                .forEach(value -> products.add(new OrderProductDTO(value)));

// 3-1. 주문옵션들 productId [1,1,2] -> [1,2] >> 돈봉투를 두번 만들어야 함
//        Set<Integer> ids = new HashSet<>(); // [1, 2]
//        for (OrderOption option : options) {
//            ids.add(option.getProduct().getId());
//        }
//
//        // 3-2. 중복된 상품의 크기만큼 반복하면서 주문 옵션 추가하기
//        for (Integer id : ids) {
//            List<OrderOption> temp = new ArrayList<>();
//
//            for (OrderOption option : options) {
//                if (id == option.getProduct().getId()) {
//                    temp.add(option);
//                }
//            }
//
//            OrderProductDTO product = new OrderProductDTO(temp);
//            products.add(product);
//        }
    }

    @Data
    class OrderProductDTO { // 돈봉투
        private int productId;
        private List<OrderOptionDTO> option = new ArrayList<>();

        public OrderProductDTO(List<OrderOption> options) {
            this.productId = options.get(0).getProduct().getId();
            this.option = options.stream().map(orderOption -> new OrderOptionDTO(orderOption)).toList();
        }

        @Data
        class OrderOptionDTO {
            private int id;
            private String optionName;
            private int qty;
            private int totalPrice;

            public OrderOptionDTO(OrderOption option) {
                this.id = option.getId();
                this.optionName = option.getOptionName();
                this.qty = option.getQty();
                this.totalPrice = option.getTotalPrice();
            }
        }
    }
}
