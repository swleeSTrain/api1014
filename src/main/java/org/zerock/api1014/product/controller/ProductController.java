package org.zerock.api1014.product.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.api1014.common.dto.PageRequestDTO;
import org.zerock.api1014.common.dto.PageResponseDTO;
import org.zerock.api1014.product.dto.ProductListDTO;

@RestController
@RequestMapping("/api/v1/product")
@Log4j2
public class ProductController {

    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    @PreAuthorize("permitAll()")
    @GetMapping("list")
    public ResponseEntity<PageResponseDTO<ProductListDTO>> list(
            @Validated PageRequestDTO pageRequestDTO
    ){
        log.info("--------------------------Product Controller list");
        return ResponseEntity.ok(null);
    }

}
