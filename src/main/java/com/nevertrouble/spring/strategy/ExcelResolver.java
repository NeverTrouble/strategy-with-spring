package com.nevertrouble.spring.strategy;

public interface ExcelResolver {
    /**
     * 这里是举例子，如果有不同的 Excel 模板
     * 就还可以加字段用来标识，用来筛选属于这个 Excel 模板的 resolver
     */
//    String getExcelName();

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
