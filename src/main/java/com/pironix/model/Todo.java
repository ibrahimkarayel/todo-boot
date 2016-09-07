package com.pironix.model;

import com.pironix.utils.TodoCategories;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


/**
 * The User_Todo Entity Class
 * <p>
 * Created by ibrahim
 *
 * @author ibrahim KARAYEL
 * @version 1.0
 * @since 9/3/2016.
 */
@Entity()
@Table(name = "todo", schema = "tododb")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "todo_name")
    private String todoName;

    @Column(name = "description")
    private String description;

    @Column(name = "content")
    private String content;


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "task_date", nullable = false)

    private Date taskDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "created_date")
    private Date createdDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private TodoCategories category;

    private String status;

    @Column(name = "user_id")
    private int userId;


    public Todo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTodoName() {
        return todoName;
    }

    public void setTodoName(String todoName) {
        this.todoName = todoName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(Date taskDate) {
        this.taskDate = taskDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public TodoCategories getCategory() {
        return category;
    }

    public void setCategory(TodoCategories category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Todo)) return false;

        Todo todo = (Todo) o;

        if (id != todo.id) return false;
        if (userId != todo.userId) return false;
        if (todoName != null ? !todoName.equals(todo.todoName) : todo.todoName != null) return false;
        if (description != null ? !description.equals(todo.description) : todo.description != null) return false;
        if (content != null ? !content.equals(todo.content) : todo.content != null) return false;
        if (taskDate != null ? !taskDate.equals(todo.taskDate) : todo.taskDate != null) return false;
        if (createdDate != null ? !createdDate.equals(todo.createdDate) : todo.createdDate != null) return false;
        if (category != todo.category) return false;
        return status != null ? status.equals(todo.status) : todo.status == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (todoName != null ? todoName.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (taskDate != null ? taskDate.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + userId;
        return result;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", todoName='" + todoName + '\'' +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                ", taskDate=" + taskDate +
                ", createdDate=" + createdDate +
                ", category=" + category +
                ", status='" + status + '\'' +
                ", userId=" + userId +
                '}';
    }
}
