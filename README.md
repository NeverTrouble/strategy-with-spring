# Spring 中的策略模式

```java

@Component
public class Context {
    
    
    /**
     * Spring 中是 @Autowired 可以注入一个接口的所有实现为一个 Map
     * 
     * key 为实现类的实例的名字： @Service("这个值")
     * value 为实现类的实例
     * 
     * 这里只是示例可以这样注入
     * 我实践中使用的是构造注入
     */
    @Autowired
    Map<String, StrategyInterface> map;
    
}

@Component
public class Context {
    
    // 多态体现在这里 value 类型是 接口（或父类）
    private final Map<String, StrategyInterface> KEY_TO_STRATEGY;
    
    @Autowired
    public Context(Map<String, StrategyInterface> map) {
        
        KEY_TO_STRATEGY = new HashMap<>();
        for (Map.Entry<String, StrategyInterface> entry : map.entrySet()) {
            
            StrategyInterface strategy = entry.getValue();
            // 这就要求 StrategyInterface 有一个 getKey 的方法，
            // 在各个实现里有不同的返回值用以标识自身，通常就是要的条件
            String key = strategy.getKey();
            
            KEY_TO_STRATEGY.put(key, strategy);
        }
    }
    
    public void use(Object data, String key) {
        if (!KEY_TO_STRATEGY.containsKey(key)) {
            log.error("[{}] 对应的策略不存在", key);
            return;
        }
        
        // 策略体现在这里通过不同的 key 获取不同的策略
        // 多态体现在这里的类型是 接口 （或父类）
        StrategyInterface strategy = KEY_TO_STRATEGY.get(key);
        strategy.use(data);
    }
}

```

详情运行测试类

`com.nevertrouble.spring.strategy.ExcelResoverContextTest`