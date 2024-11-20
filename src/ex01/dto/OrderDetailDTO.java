package ex01.dto;

import lombok.Data;
import ex01.model.OrderOption;

import java.util.*;

@Data
public class OrderDetailDTO {
    private int orderId;
    private List<OrderProductDTO> products = new ArrayList<>();
    private int sumPrice;

    public OrderDetailDTO(List<OrderOption> options) {
        // 1. orderId
        this.orderId = options.get(0).getOrder().getId();

        // 2. sumPrice
        for (OrderOption option : options) {
            this.sumPrice += option.getTotalPrice();
        }

        // 3. products
        // 3-1. 주문옵션들 productId [1,1,2] -> [1,2] >> 돈봉투를 두번 만들어야 함

        Set<Integer> ids = new HashSet<>(); // [1, 2]
        for (OrderOption option : options) {
            ids.add(option.getProduct().getId());
        }

        // 3-2. 중복된 상품의 크기만큼 반복하면서 주문 옵션 추가하기
        for (Integer id : ids) {
            List<OrderOption> temp = new ArrayList<>();

            for(OrderOption option : options) {
                if (id == option.getProduct().getId()) {
                    temp.add(option);
                }
            }

            OrderProductDTO product = new OrderProductDTO(temp);
            products.add(product);
        }
    }

    @Data
    class OrderProductDTO { // 돈봉투
        private int productId;
        private List<OrderOptionDTO> option = new ArrayList<>();

        public OrderProductDTO(List<OrderOption> options) {
            this.productId = options.get(0).getProduct().getId();
            for (OrderOption option : options) {
                this.option.add(new OrderOptionDTO(option));
            }
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
