package jpabook.jpashop;

import javax.persistence.*;

@Entity
public class Delivery {

    @Id @GeneratedValue
    private Long id;

    private String city;
    private String street;
    private String zipCode;
    private DeleveryStatus status;

/*    @OneToOne
    @JoinColumn(name="delivery")
    private Order order;*/
}
