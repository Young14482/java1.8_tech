package ex01.mydto;

import ex01.model.OrderOption;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OrderResponse {

    public static class OrderMainDTO {
        Integer id;
        List<OrderDTO> orderDTOS;
        int totalPrice;

        public Integer getId() {
            return id;
        }

        public List<OrderDTO> getOrderDTOS() {
            return orderDTOS;
        }

        public int getTotalPrice() {
            return totalPrice;
        }

        @Override
        public String toString() {
            return "주문번호: " + id + "\n" + orderDTOS + "\n최종가격=" + totalPrice;
        }

        public OrderMainDTO(List<OrderOption> or1Option) {
            this.id = or1Option.get(0).getOrder().getId();
            this.orderDTOS = new ArrayList<OrderDTO>();

            Set<Integer> idSet = new HashSet<Integer>();
            for (OrderOption orderOption : or1Option) {
                idSet.add(orderOption.getId());
            }
            // productId랑 비교하고 같은것끼리 리스트로 묶기
            for (Integer id : idSet) {
                List<OrderOption> opList = new ArrayList<>(); // 주문 번호가 같은 것들 묶을 리스트
                for (int j = 0; j < or1Option.size(); j++) {
                    if (id == or1Option.get(j).getProduct().getId()) {
                        opList.add(or1Option.get(j));
                    }
                }
                orderDTOS.add(new OrderDTO(opList));
            }
            this.totalPrice = 0;
            for (OrderOption o : or1Option) {
                totalPrice += o.getTotalPrice();
            }

        }

        public static class OrderDTO {
            Integer productId;
            List<OrderDetailDTO> OrderDetailDTO;

            public OrderDTO(List<OrderOption> orderOptionDTOS) {
                this.productId = orderOptionDTOS.get(0).getProduct().getId();
                this.OrderDetailDTO = new ArrayList<>();
                for (OrderOption o : orderOptionDTOS) {
                    OrderDetailDTO.add(new OrderDetailDTO(o));
                }
            }

            @Override
            public String toString() {
                return "상품번호=" + productId + "\n" + OrderDetailDTO;
            }

            public static class OrderDetailDTO {
                Integer optionId;
                String optionName;
                int optionQty;
                int price;

                public OrderDetailDTO(OrderOption option) {
                    this.optionId = option.getId();
                    this.optionName = option.getOptionName();
                    this.optionQty = option.getQty();
                    this.price = option.getTotalPrice();
                }

                @Override
                public String toString() {
                    return "옵션번호=" + optionId +
                            "\n옵션이름=" + optionName +
                            "\n구매수=" + optionQty +
                            "\n가격=" + price + "\n";
                }
            }
        }
    }
}
