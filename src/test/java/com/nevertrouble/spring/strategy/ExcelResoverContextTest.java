package com.nevertrouble.spring.strategy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ExcelResoverContextTest {

    @Autowired
    private ExcelResolverContext resoverContext;

    @Test
    void resolve() {
        // 不同的 sheet 会走不同的解析器
        resoverContext.resolve("sheet1", "aha");
        resoverContext.resolve("sheet2", "bhb");
    }
}
