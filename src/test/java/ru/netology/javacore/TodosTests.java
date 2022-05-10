package ru.netology.javacore;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodosTests {
    Todos todos;

    @Test
    public void testAddTask() {
        todos = new Todos();
        String expected = "Гулять ";
        todos.addTask("Гулять");

        String result = todos.getAllTasks();
        assertEquals(expected, result);
    }

    @Test
    public void testRemoveTask() {
        todos = new Todos();
        String expected = "Гулять Играть Спать ";
        todos.addTask("Гулять");
        todos.addTask("Спать");
        todos.addTask("Играть");
        todos.addTask("Читать");
        todos.removeTask("Читать");
        String result = todos.getAllTasks();
        assertEquals(expected, result);
    }
    @Test
    public void testSortTodos() {
        todos = new Todos();
        String expected = "Гулять Играть Спать Читать ";
        todos.addTask("Спать");
        todos.addTask("Играть");
        todos.addTask("Гулять");
        todos.addTask("Читать");
        String result = todos.getAllTasks();
        assertEquals(expected, result);

    }

    // ваши тесты для класса Todos
}
