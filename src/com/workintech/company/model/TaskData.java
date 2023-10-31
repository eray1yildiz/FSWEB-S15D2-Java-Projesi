package com.workintech.company.model;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class TaskData {
    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
    }

    public Set<Task> getTasks(String taskOwner){
        if (taskOwner.equals("ann")){
            return annsTasks;
        }
        if (taskOwner.equals("bob")) {
            return bobsTasks;
        }
        if (taskOwner.equals("carol")) {
            return carolsTasks;
        }
        if (taskOwner.equals("all")) {

            List<Set<Task>> taskList = new ArrayList<>();
            taskList.add(annsTasks);
            taskList.add(bobsTasks);
            taskList.add(carolsTasks);
            return getUnion(taskList);
        }
        return new HashSet<>();
    }



    public Set<Task> getUnion(List<Set<Task>> taskList) {
        Set<Task> result = new HashSet<>();
        for (Set<Task> tasks: taskList){

            result.addAll(tasks);
        }
        return result;
    }
    public Set<Task> getIntersect(Set<Task> set1, Set<Task> set2) {
        Set<Task> copyTask = new HashSet<>(set1);
        copyTask.retainAll(set2);
        return copyTask;
    }
    public Set<Task> getDifference(Set<Task> set1, Set<Task> set2) {
        Set<Task> copyTask = new HashSet<>(set1);
        copyTask.removeAll(set2);
        return copyTask;
    }

}