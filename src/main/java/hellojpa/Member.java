package hellojpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Entity를 선언하면 jpa 가 관리하는 객체로 선언이 됨(name은 class name이 기본값(변경할 일이 거의 없음))
@Entity
// class name과 테이블 name이 다르면 그 때 name 선언해서 변경
// @Table(name="Member")
public class Member {

    @Id
    private Long id;
    private String name;
    private int gogo;

    public Member(){

    }
    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }

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
}
