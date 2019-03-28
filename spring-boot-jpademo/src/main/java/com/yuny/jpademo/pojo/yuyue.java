package com.yuny.jpademo.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class yuyue {

    @Override
    public String toString() {
        return "yuyue{" +
                "id=" + id +
                ", datetime='" + datetime + '\'' +
                ", room=" + room +
                ", name='" + name + '\'' +
                ", neirong='" + neirong + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    private int id;
    private String datetime;
    private int room;
    private String name;
    private String neirong;

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNeirong() {
        return neirong;
    }

    public void setNeirong(String neirong) {
        this.neirong = neirong;
    }

}