package com.czw.db.mongodb.morphia;

import org.mongodb.morphia.annotations.*;

import java.util.List;

/**
 * @author ZeviChen
 * @Date 2016-09-12 17:59:34
 */
@Entity("employees")
@Indexes(
        @Index(fields = @Field("salary"))
)
class Employee {
    @Id
    private String id;
    private String name;
    @Reference
    private Employee manager;
    @Reference
    private List<Employee> directReports;
    @Property("wage")
    private Double salary;
}
