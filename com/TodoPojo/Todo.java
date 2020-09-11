package com.TodoPojo;
import java.sql.Timestamp;
public class Todo {
   private int id;
  private String name,description,status;
  private Timestamp time;

    @Override
    public String toString() {
        return "Todo{" + "id=" + id + ", name=" + name + ", description=" + description + ", status=" + status + ", time=" + time + '}';
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Todo() {
    }
    public Todo(int id, String name, String description, String status, Timestamp time) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.time = time;
    }

}
