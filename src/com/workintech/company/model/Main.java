package com.workintech.company.model;

import com.workintech.company.enums.Priority;
import com.workintech.company.enums.Status;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Task task1 = new Task("Java Collection", "Write List", "Ann", Priority.LOW, Status.ASSIGNED);
        Task task2 = new Task("Java Collection", "Write Set", "Bob", Priority.LOW, Status.ASSIGNED);
        Task task3 = new Task("Java Collection", "Write LinkedList", "Carol", Priority.LOW, Status.ASSIGNED);
        Task task4 = new Task("Java Collection", "Write Map", "Bob", Priority.LOW, Status.ASSIGNED);
        Task task5 = new Task("Java Collection", "Write ArrayList", "Ann", Priority.LOW, Status.ASSIGNED);
        Task task6 = new Task("Java Collection", "Write List in set", "", Priority.MED, Status.IN_QUEUE);
        Task task7 = new Task("Java Collection", "Write ArrayList", "Bob", Priority.MED, Status.IN_QUEUE);

        Set<Task> totalTasks = new HashSet<>();
        totalTasks.add(task1);
        totalTasks.add(task2);
        totalTasks.add(task3);
        totalTasks.add(task4);
        totalTasks.add(task5);
        totalTasks.add(task6);

        Set<Task> annsTask = new LinkedHashSet<>();
        annsTask.add(task1);
        annsTask.add(task5);

        Set<Task> bobTask = new LinkedHashSet<>();
        bobTask.add(task2);
        bobTask.add(task4);

        Set<Task> carolTask = new LinkedHashSet<>();
        carolTask.add(task3);
        carolTask.add(task7);


        TaskData taskData = new TaskData(annsTask, bobTask, carolTask);


        System.out.println("All tasks: ");
        System.out.println(taskData.getTasks("all"));

        System.out.println("Anns Task: ");
        System.out.println(taskData.getTasks("ann"));

        System.out.println("Bob Task: ");
        System.out.println(taskData.getTasks("bob"));

        System.out.println("Carol Task: ");
        System.out.println(taskData.getTasks("carol"));

        System.out.println("Atanmamış tasklar:");
        System.out.println(taskData.getDifference(totalTasks, taskData.getTasks("all")));

        System.out.println("Birden fazla çalışana atanan tasklar:");
        System.out.println("Ann-Bob: " + taskData.getIntersect(annsTask, bobTask));
        System.out.println("Ann-Carol: " + taskData.getIntersect(annsTask, carolTask));
        System.out.println("Bob-Carol: " + taskData.getIntersect(bobTask, carolTask));
    }

}