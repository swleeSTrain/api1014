package org.zerock.api1014.member.repository;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.api1014.cart.domain.Cart;
import org.zerock.api1014.cart.domain.CartDetails;
import org.zerock.api1014.cart.repository.CartDetailsRepository;
import org.zerock.api1014.cart.repository.CartRepository;
import org.zerock.api1014.common.dto.PageRequestDTO;
import org.zerock.api1014.member.domain.MemberEntity;
import org.zerock.api1014.member.domain.MemberRole;
import org.zerock.api1014.product.domain.Product;
import org.zerock.api1014.product.repository.ProductRepository;

@Log4j2
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private CartDetailsRepository CartDetailsRepository;
    @Autowired
    private CartDetailsRepository cartDetailsRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductRepository productRepository;


    @Test
    public void testCartList(){
        String email = "user1@aaa.com";

        Pageable pageable = PageRequest.of(0, 10);

        cartDetailsRepository.listOfMember(email, pageable);
    }

    @Test
    @Transactional
    @Commit
    public void testCartDummies(){

    }

    @Test
    @Transactional
    @Commit
    public void testDummies() {

        for (int i = 1; i <= 10; i++) {

            MemberEntity member = MemberEntity.builder()
                    .email("user" + i + "@aaa.com")
                    .pw(passwordEncoder.encode("1111"))
                    .role(i < 8 ? MemberRole.USER : MemberRole.ADMIN)
                    .build();

            memberRepository.save(member);

        }
    }
}
