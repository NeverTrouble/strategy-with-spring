package com.nevertrouble.spring.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Slf4j
@Service("sheet2Resolver")
public class Sheet2Resolver implements ExcelResolver {

    private String sheetName = "sheet2";

    @Override
    public String getSheetName() {
        return sheetName;
    }

    @Override
    public void resolve(Object data) {
        log.info("[{}] 解析的数据是: [{}]", sheetName, Objects.toString(data));
    }
}
