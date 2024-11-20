package ex01.mydto;

import ex01.model.Product;
import ex01.model.ProductOption;

import java.util.ArrayList;
import java.util.List;

public class ProductResponse {

    public static class IndexDTO {
        private Integer id;
        private String name;

        public IndexDTO(Product product) {
            this.id = product.getId();
            this.name = product.getName();
        }

        public Integer getId() {
            return id;
        }

        public String getName() {
            return name;
        }

    }
//////////////////////////////////////////////////////
    public static class DetailDTO {
        private Integer id;
        private String name;
        private List<OptionDTO> options;

        public class OptionDTO {
            private Integer id;
            private String name;
            private int price;
            private int qty;

            public OptionDTO(ProductOption productOption) {
                this.id = productOption.getId();
                this.name = productOption.getName();
                this.price = productOption.getPrice();
                this.qty = productOption.getQty();
            }

            @Override
            public String toString() {
                return  "번호=" + id +
                        " 옵션명=" + name +
                        " 가격=" + price +
                        " 재고=" + qty;
            }
        }

        public DetailDTO(Product product, List<ProductOption> options) {
            this.id = product.getId();
            this.name = product.getName();
            this.options = new ArrayList<OptionDTO>();
            for(ProductOption productOption : options) {
                this.options.add(new OptionDTO(productOption));
            }
        }

    }

}
