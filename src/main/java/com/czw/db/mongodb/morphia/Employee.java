package com.czw.db.mongodb.morphia;

import java.util.List;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Field;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Index;
import org.mongodb.morphia.annotations.Indexes;
import org.mongodb.morphia.annotations.Property;
import org.mongodb.morphia.annotations.Reference;

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
