package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {

    @Id
    @GeneratedValue
    @Column(name="TEAM_ID")
    private Long id;
    private String name;

    // 2. Member 테이블에서 team 테이블의 pk 를 JoinColumn 으로 참조
    // 3. team pk 를 참조한 컬럼의 값을 mappedBy 로 셋팅
    // mappedBy 는 team에 의해서 관리가 된다는 의미!
    // mappedBy 는 읽기만 함
    @OneToMany(mappedBy = "team")
    private List<Member> members = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }
}
