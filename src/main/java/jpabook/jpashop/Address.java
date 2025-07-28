package jpabook.jpashop;

import javax.persistence.Column;
import javax.persistence.Embeddable;

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

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
