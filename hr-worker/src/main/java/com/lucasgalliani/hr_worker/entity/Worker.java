package com.lucasgalliani.hr_worker.entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_worker")
public class Worker  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double dailyInCome;

    public Worker(){}

    public Worker(Long id, String name, Double dailyInCome) {
        this.id = id;
        this.name = name;
        this.dailyInCome = dailyInCome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getDailyInCome() {
        return dailyInCome;
    }

    public void setDailyInCome(Double dailyInCome) {
        this.dailyInCome = dailyInCome;
    }
}
