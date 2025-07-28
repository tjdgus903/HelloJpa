package jpabook.jpashop;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member extends BaseEntity{

    @Id
    @GeneratedValue
    @Column(name="MEMBER_ID")
    private Long id;

    @Column(name="USERNAME")
    private String username;


    //@ManyToOne(fetch = FetchType.EAGER)     // 즉시 로딩(실무에서는 사용 X)
    // 즉시로딩을 사용하면 join 해서 연관있는 테이블까지 모두 조회를 하기 때문에
    // DB 운영에서 성능 이슈가 발생할 수 있음
    @ManyToOne(fetch = FetchType.LAZY)   // 지연로딩
    @JoinColumn
    private Team team;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String name) {
        this.username = name;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
