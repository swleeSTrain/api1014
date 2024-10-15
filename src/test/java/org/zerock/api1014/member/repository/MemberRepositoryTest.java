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
import org.zerock.api1014.cart.dto.CartDetailsListDTO;
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

        Pageable pageable = PageRequest.of(0, 50);

        log.info(cartDetailsRepository.listOfMember(email, pageable).getContent());
    }

    @Test
    @Transactional
    @Commit
    public void testCartDummies(){
        for (int i = 0; i < 10; i++) {
            MemberEntity member = MemberEntity.builder()
                    .email("user"+i+"@aaa.com")
                    .pw(passwordEncoder.encode("1111"))
                    .build();

            Cart cart = Cart.builder()
                    .member(member)
                    .build();
            cartRepository.save(cart);
        }

    }

    @Test
    @Transactional
    @Commit
    public void testCartDetailDummies(){
        for (int i = 1; i < 11; i++) {

            CartDetails cartDetails = CartDetails.builder()
                    .cart(Cart.builder()
                            .cno((long) i)
                            .build())
                    .product(Product.builder()
                            .pno((long) 2)
                            .build())
                    .qty(50)
                    .build();
            cartDetailsRepository.save(cartDetails);
        }

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

