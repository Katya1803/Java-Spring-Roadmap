package com.coffeepoweredcrew.memento.command;

public interface WorkflowCommand {

    void execute();

    void undo();
}
