package jpabook.jpashop;

import javax.persistence.Entity;


public enum OrderState {
    ORDERED, SHIPPED, DELIVERED, CANCELLED
}
