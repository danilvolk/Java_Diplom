package ru.netology.javacore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class TodoServer {

    //...
    private int port;
    private Todos todos;
    GsonBuilder gsonBuilder = new GsonBuilder();
    private Gson gson = gsonBuilder.create();

    public TodoServer(int port, Todos todos) {
        this.port = port;
        this.todos = todos;

    }

    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Starting server at " + port + "...");

        while (true) {
            try (
                    Socket socket = serverSocket.accept();
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                String input = in.readLine();
                Task task = gson.fromJson(input, Task.class);

                if (task.getType().equals("ADD")) {
                    todos.addTask(task.getTask());
                    System.out.println(todos.getAllTasks());
                    out.println(todos.getAllTasks());
                } else if (task.getTask().equals("REMOVE")) {
                    todos.removeTask(task.getTask());
                    out.println(todos.getAllTasks());
                    System.out.println(todos.getAllTasks());
                }

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
