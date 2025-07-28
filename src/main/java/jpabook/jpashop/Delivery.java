package jpabook.jpashop;

import net.bytebuddy.dynamic.TypeResolutionStrategy;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
public class Delivery {

    @Id @GeneratedValue
    private Long id;

    private String city;
    private String street;
    private String zipCode;
    private DeleveryStatus status;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name="delivery")
    private Order order;
}
