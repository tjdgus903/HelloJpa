package hellojpa;

import jakarta.persistence.*;

import java.util.Locale;

// Entity를 선언하면 jpa 가 관리하는 객체로 선언이 됨(name은 class name이 기본값(변경할 일이 거의 없음))
@Entity
@TableGenerator(
        name="MEMBER_SEQ_GENERATOR",
        table = "MY_SEQUENCES",
        initialValue = 1, allocationSize = 50
)
public class Member {

    @Id
    // IDENTITY : 기본키를 db에 위임
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "MEMBER_SEQ_GENERATOR")
    private Long id;

    @Column(name="name", nullable = false)
    private String username;

    public Member(){

    }

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
}
