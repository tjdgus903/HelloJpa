package jpabook.jpashop;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;


// 값타입은 데이터를 객체간에 공유를 하기 때문에 불변으로 만들어야 오류가 안남
// set 을 통해 값이 변경이 일어날 경우 다른 객체의 데이터도 변경되기 때문
@Embeddable
public class Address {

    // 주소
    private String city;
    private String street;

    @Column(name="ZIPCODE")
    private String zipCode;

    // Embeddable 은 db에서 값을 조회하거나 엔티티, 임베디드를 통해서 객체를 만들 수 없음
    // 리플렉션으로 객체를 생성하는데 이 때 기본 생성자(매개변수 없는 생성자)가 있어야 함
    public Address(){
    }

    public Address(String city, String street, String zipCode){
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }


    public String getStreet() {
        return street;
    }


    public String getZipCode() {
        return zipCode;
    }

    public void setCity(String city) {
        this.city = city;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    // equals 는 직접 코딩하지말고 참조하여 쓰는걸 권장
    // 값타입을 비교할 때에는 equals 를 써야됨!!
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(city, address.city) && Objects.equals(street, address.street) && Objects.equals(zipCode, address.zipCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, zipCode);
    }
}
