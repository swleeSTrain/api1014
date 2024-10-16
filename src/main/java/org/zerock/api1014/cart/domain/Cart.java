package org.zerock.api1014.cart.domain;

import jakarta.persistence.*;
import lombok.*;
import org.zerock.api1014.member.domain.MemberEntity;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cno;

    @OneToOne //원투원
    private MemberEntity member;
//테스트
}
