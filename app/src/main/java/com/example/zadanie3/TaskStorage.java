package com.example.zadanie3;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// klasa reprezentująca bazę na pytania
public class TaskStorage {
    private static TaskStorage instance = new TaskStorage();

    private List<Task> tasks;

    private TaskStorage() {
        tasks = new ArrayList<>();
        for (int i = 1; i <= 150; ++i) {
            Task task = new Task();
            task.setName("Zadanie #" + i);
            if (i % 3 == 0) {
                task.setCategory(Category.STUDIES);
            } else {
                task.setCategory(Category.HOME);
            }
            task.setDone(i % 3 == 0);
            tasks.add(task);
        }
    }

    public static TaskStorage getInstance() {
        return instance;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public Task getTask(UUID id) {
        for (Task task : tasks) {
            if (task.getId().equals(id))
                return task;
        }
        return null;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }
}