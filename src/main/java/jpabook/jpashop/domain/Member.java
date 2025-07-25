package jpabook.jpashop.domain;

import javax.persistence.*;

@Entity
public class Member {

    @Id
    @GeneratedValue
    @Column(name="MEMBER_ID")
    private Long id;

    @Column(name="USERNAME")
    private String username;

    @ManyToOne
    // 1. JoinColumn 에서 Team 테이블의 pk 를 셋팅
    // JoinColumn 은 관리한다는 의미(외래키가 있는 곳을 owner로 설정해야됨)
    // 보통 1:n 관계이면 n 이 연관관계 주인이 됨
    @JoinColumn(name="TEAM_ID")
    private Team team;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
