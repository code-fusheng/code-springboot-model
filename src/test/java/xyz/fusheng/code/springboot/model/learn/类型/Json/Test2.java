package xyz.fusheng.code.springboot.model.learn.类型.Json;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Test2 {
    private String desc;
    private List<String> descList;
}
