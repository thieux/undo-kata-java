package com.mathieupauly.undokatajava;

public class UndoEditor {
    private boolean appendLogged;
    private String deleted;

    public void setAppendLogged(boolean appendLogged) {
        this.appendLogged = appendLogged;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public String undo(String buffer) {
        if (deleted != null) {
            return buffer + deleted;
        }
        if (appendLogged) {
            return buffer.substring(0, buffer.length() - 1);
        }
        return buffer;
    }
}