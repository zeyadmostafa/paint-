package paint.controller;

import paint.model.Memento;

public interface CommandInterface 
{
void execute(Memento memento);
}
