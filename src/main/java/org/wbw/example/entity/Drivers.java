package org.wbw.example.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author wbw
 * @description: TODO
 * @date 2022-3-23 0:09
 */
@Data
@Document(collection = "drivers")
public class Drivers {
    @Id
    private String id;
    private String name;
    private Integer age;
}
