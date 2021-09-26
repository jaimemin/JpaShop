package com.tistory.jaimemin.jpabook.jpashop.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Address {

    // 룰을 공통으로 적용 가능
    @Column(length = 10)
    private String city;

    @Column(length = 30)
    private String street;

    @Column(length = 6)
    private String zipcode;

    // 이런 유의미한 비즈니스 메서드를 생성 가능
    public String fullAddress() {
        return getCity() + getStreet() + getZipcode();
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getZipcode() {
        return zipcode;
    }

    private void setCity(String city) {
        this.city = city;
    }

    private void setStreet(String street) {
        this.street = street;
    }

    private void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        Address address = (Address) o;

        // JPA에서는 proxy 때문에 getter로 해야함
        return Objects.equals(getCity(), address.city)
                && Objects.equals(getStreet(), address.street)
                && Objects.equals(getZipcode(), address.zipcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCity(), getStreet(), getZipcode());
    }
}
