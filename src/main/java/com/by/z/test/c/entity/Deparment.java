package com.by.z.test.c.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 部门实体建模
 *
 * @author zwp
 */
@Entity
@Table(name = "deparment")
public class Deparment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
