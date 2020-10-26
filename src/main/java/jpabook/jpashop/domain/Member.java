package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded//내장 타입
    private Address address;

    @OneToMany(mappedBy = "member") //양반향 관계 , 읽기 전용, 값을 변경하여도 외래키 변하지 않음
    private List<Order> orders = new ArrayList<>();

}
