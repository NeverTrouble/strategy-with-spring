package com.nevertrouble.spring.strategy;

public interface ExcelResover {

    /**
     * 强制实现有这个字段，设置有意义的值
     * 这就是个 key
     *
     * @return sheetName
     */
    String getSheetName();

    /**
     * 具体的解析
     *
     * @param data 数据
     */
    void resolve(Object data);
}
