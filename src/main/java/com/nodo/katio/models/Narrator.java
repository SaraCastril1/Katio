package com.nodo.katio.models;

public class Narrator {

    @Override
    public String toString() {
        return "Narrator [Id=" + Id + ", Name=" + Name + ", LastName=" + LastName + ", Lenguages=" + Lenguages
                + ", Genre=" + Genre + "]";
    }

    private long Id;
    private String Name;
    private String LastName;
    private Lenguages Lenguages;
    private String Genre;

}
