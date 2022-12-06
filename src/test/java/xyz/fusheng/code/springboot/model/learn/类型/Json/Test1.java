package xyz.fusheng.code.springboot.model.learn.类型.Json;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Test1 {
    private Integer key;
    private String value;
    private Test2 test;
}
