package com.servme.todoapp.constant;

public enum TodoStatus {

    INITIAL(0),
    STARTED(1),
    COMPLETED(2),
    SNOOZED(3),
    OVERDUE(4);

    int id;
    TodoStatus(int id){
        this.id= id;
    }
}
