package jpabook.jpashop;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@Embeddable
public class Period {

    // 기간
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public boolean checkWork() {
        return false;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
}
