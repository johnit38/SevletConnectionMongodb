package PoJo;

import java.util.List;

public class StudentPoJo {
    private int id;
    private String name;
    private List<String> time;
    private List<String> info;

    public StudentPoJo(int id, String name, List<String> time, List<String> info) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.info = info;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getTime() {
        return time;
    }

    public void setTime(List<String> time) {
        this.time = time;
    }

    public List<String> getInfo() {
        return info;
    }

    public void setInfo(List<String> info) {
        this.info = info;
    }
}
