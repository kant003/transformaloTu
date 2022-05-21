package com.cebem.transformatolotu.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "quote")
public class Quote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    Integer id;

    @Column(nullable=false)
    String text;

    @Column(nullable = false)
    String name;
    public Integer getId(){
        return id;
    }

    public String getText(){
        return text;
    }

    public String getName(){
        return name;
    }
}
