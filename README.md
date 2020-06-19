# Spring 中的策略模式

```java

@Component
public class Context {
    
    
    /**
     * Spring 中是 @Autowired 可以注入一个接口的所有实现为一个 Map
     * 
     * key 为实现类的实例的名字： @Service("这个值")
     * value 为实现类的实例
     */
    @Autowired
    Map<String, StrategyInterface> map;
    
}

```

详情运行测试类

`com.nevertrouble.spring.strategy.ExcelResoverContextTest`