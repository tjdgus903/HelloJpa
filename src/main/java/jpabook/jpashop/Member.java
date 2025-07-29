package jpabook.jpashop;

import net.bytebuddy.agent.builder.AgentBuilder;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.logging.Level.ALL;

@Entity
public class Member {

    @Id
    @GeneratedValue
    @Column(name="MEMBER_ID")
    private Long id;

    @Column(name="USERNAME")
    private String username;

    // 기간
    @Embedded
    private Period workPeriod;

    // 주소
    // 이렇게 Embedded 타입이 설정되어있으면
    // create table 할 때 컬럼이 추가됨
    @Embedded
    private Address homeAddress;

    @ElementCollection // 기본값 지연로딩(LAZY)
    @CollectionTable(name = "FAVORITE_FOOD", joinColumns =
        @JoinColumn(name="MEMBER_ID")
    )
    @Column(name="FOOD_NAME")   // 값 타입 컬랙션을 설정할 때 리스트가 String이나 Int 같은 변환자일때는 컬럼명을 지정
    private Set<String> favoriteFoods = new HashSet<>();

/*    @ElementCollection
    @CollectionTable(name="address", joinColumns =
        @JoinColumn(name="MEMBER_ID")
    ) // Address 로 설정되어있기 때문에 따로 컬럼명 지정 안해도 됨
    private List<Address> addressHistory = new ArrayList<>();*/

    // 주로 위처럼 값타입 컬랙션은[리스트인거같음] 잘 안쓰고
    // 대부분 일대다 매핑으로 씀(실무에서 잘 안씀)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="MEMBER_ID")
    private List<AddressEntity> addressHistory = new ArrayList<>();

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

    public Period getWorkPeriod() {
        return workPeriod;
    }

    public void setWorkPeriod(Period vorkPeriod) {
        this.workPeriod = vorkPeriod;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Set<String> getFavoriteFoods() {
        return favoriteFoods;
    }

    public void setFavoriteFoods(Set<String> favoriteFoods) {
        this.favoriteFoods = favoriteFoods;
    }

    public List<AddressEntity> getAddressHistory() {
        return addressHistory;
    }

    public void setAddressHistory(List<AddressEntity> addressHistory) {
        this.addressHistory = addressHistory;
    }
}
