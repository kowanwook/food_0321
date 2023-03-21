package food.domain;

import food.domain.*;
import food.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Orderplaced extends AbstractEvent {

    private Long id;
    private String customerId;
    private String dishname;
    private Long ordNo;

    public Orderplaced(Order aggregate) {
        super(aggregate);
    }

    public Orderplaced() {
        super();
    }
}
