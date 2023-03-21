package food.domain;

import food.domain.*;
import food.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Deliveryconfimed extends AbstractEvent {

    private Long id;
    private Long ordNo;
    private String riderId;
    private String deliveryStatus;

    public Deliveryconfimed(Delivery aggregate) {
        super(aggregate);
    }

    public Deliveryconfimed() {
        super();
    }
}
