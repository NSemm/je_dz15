package com.k7.menuAction;

public class ExitMenuAction implements MenuAction{
    @Override
    public void doAction() {
        System.out.println("Selected " + getName() + " action");
    }

    @Override
    public String getName() {
        return "Exit";
    }

    @Override
    public boolean closeAfter() {
        return true;
    }
}
