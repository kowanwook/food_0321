package food.domain;

import food.StoreApplication;
import food.domain.Rejected;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Cooking_table")
@Data
public class Cooking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String customerId;

    private String dishname;

    private Long ordNo;

    private String foodStatusYn;

    @PostPersist
    public void onPostPersist() {
        Rejected rejected = new Rejected(this);
        rejected.publishAfterCommit();
    }

    public static CookingRepository repository() {
        CookingRepository cookingRepository = StoreApplication.applicationContext.getBean(
            CookingRepository.class
        );
        return cookingRepository;
    }

    public void acceptOrReject(AcceptOrRejectCommand acceptOrRejectCommand) {
        Accepted accepted = new Accepted(this);
        accepted.publishAfterCommit();
    }

    public void cookStart() {
        Cookstarted cookstarted = new Cookstarted(this);
        cookstarted.publishAfterCommit();
    }

    public void cookFinish() {
        Cookfinished cookfinished = new Cookfinished(this);
        cookfinished.publishAfterCommit();
    }

    public static void loadOrderInfo(Orderplaced orderplaced) {
        /** Example 1:  new item 
        Cooking cooking = new Cooking();
        repository().save(cooking);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderplaced.get???()).ifPresent(cooking->{
            
            cooking // do something
            repository().save(cooking);


         });
        */

    }
}
