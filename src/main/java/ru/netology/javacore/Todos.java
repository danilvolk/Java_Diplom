package ru.netology.javacore;

import java.util.*;
import java.util.stream.Collectors;

public class Todos {
    List<String> todosList = new ArrayList<>();
    public void addTask(String task) {
        todosList.add(task);


        //...
    }

    public void removeTask(String task) {
        todosList.remove(task);
        //...
    }

    public String getAllTasks() {
        StringBuilder sb = new StringBuilder();
        Collections.sort(todosList);
        for (String todos:todosList) {
            sb.append(todos + " ");

        }
        return sb.toString();
        //...
    }

}
