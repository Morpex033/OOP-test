package org.example.sharipov.models;

public class FixedWorker implements IWorker {
    private int id;
    private double pay;
    private String name;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double payroll(int day) {
        return (pay * day) / 20.8;
    }

    public FixedWorker(int id, double pay, String name) {
        this.id = id;
        this.pay = pay;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Id: " + getId() + "  Pay: " + payroll(31) + "  Name: " + getName();
    }
}
