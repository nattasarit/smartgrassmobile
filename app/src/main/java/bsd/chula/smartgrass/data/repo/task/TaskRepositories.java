package bsd.chula.smartgrass.data.repo.task;

import bsd.chula.smartgrass.data.model.Order;

/**
 * Created by Dev_Tee on 1/28/17.
 */

public class TaskRepositories implements TaskRepository {


    @Override
    public void selectAllTasks(SelectAllTasksCallback callback) {

    }

    @Override
    public void selectTaskItem(int id, SelectTaskItemCallback callback) {

    }

    @Override
    public void updateTaskItem(Order order, UpdateTaskItemCallback callback) {

    }

    @Override
    public void deleteTaskItem(DeleteTaskItemCallback callback) {

    }
}
