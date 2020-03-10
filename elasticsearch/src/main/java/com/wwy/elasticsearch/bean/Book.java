package com.wwy.elasticsearch.bean;

import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "depp",type="book")
public class Book {
    private Integer id;
    private String name;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
