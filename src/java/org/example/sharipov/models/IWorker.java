package org.example.sharipov.models;

public interface IWorker {

    int getId();

    void setId(int id);

    double payroll(int day);

    String toString();
}
