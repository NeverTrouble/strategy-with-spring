package com.nevertrouble.spring.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;


/**
 * sheet1 对应的解析
 */
@Slf4j
@Service("sheet1Resolver")
public class Sheet1Resolver implements ExcelResolver {

    private String sheetName = "sheet1";

    @Override
    public String getSheetName() {
        return sheetName;
    }

    @Override
    public void resolve(Object data) {
        log.info("正在进行的是 [{}], [{}]", sheetName, Objects.toString(data));
    }
}
