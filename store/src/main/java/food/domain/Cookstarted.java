package food.domain;

import food.domain.*;
import food.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Cookstarted extends AbstractEvent {

    private Long id;
    private Long ordNo;
    private String foodStatus;

    public Cookstarted(Cooking aggregate) {
        super(aggregate);
    }

    public Cookstarted() {
        super();
    }
}
