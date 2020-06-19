package com.nevertrouble.spring.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Slf4j
@Component
public class ExcelResoverContext {

    /**
     * 这里是 sheetName 对应的 解析器
     */
    private final Map<String, ExcelResover> SHEET_NAME_TO_RESOLVER;

    /**
     * @Autowired 可以注入一个接口的 所有实现   实现的名字：对应的实现的实例
     *
     * 注意，不同的实现，@Service("要有不同的名字")
     *
     * @param excelResolverMap
     */
    @Autowired
    private ExcelResoverContext(Map<String, ExcelResover> excelResolverMap) {
        // SHEET_NAME_TO_RESOLVER = excelResolverMap.entrySet().stream().collect(Collectors.toMap(e -> e.getValue().getSheetName(), Map.Entry::getValue));

        // 为了解析 for 循环
        SHEET_NAME_TO_RESOLVER = new ConcurrentHashMap<>();
        for (Map.Entry<String, ExcelResover> entry : excelResolverMap.entrySet()) {

            // 这个值就是 @Service("双引号里的")
            // 我这里没有使用它, 而是在每个实现里加了一个 sheetName 的字段来标识
            // String beanName = entry.getKey();

            ExcelResover resolver = entry.getValue();
            String sheetName = resolver.getSheetName();

            SHEET_NAME_TO_RESOLVER.put(sheetName, resolver);
        }
    }

    public void resolve(String sheetName, Object data) {

        if (!SHEET_NAME_TO_RESOLVER.containsKey(sheetName)) {
            log.error("没有 SHEET_NAME: [{}] 对应的解析策略!!!", sheetName);
            return;
        }

        // 通过 sheetName 获取到对应的解析实现
        ExcelResover excelResover = SHEET_NAME_TO_RESOLVER.get(sheetName);
        excelResover.resolve(data);
    }
}
