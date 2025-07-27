package jpabook.jpashop;

import javax.persistence.Enumerated;

public enum DeleveryStatus {
    ORDERED,
    SHIPPED,
    DELIVERED,
    CANCELLED
}
