//
// Name: Roman, Dylan
// Project #4
// 11/4/2025
// Course: cs-2400-03-f25
//
// Description:
// Uses a Max Heap to implement a Priority Queue. Priority queue is tested in an ER room simulator.
//

public class Patient implements Comparable<Patient>{
    private String name;
    private int priority;

    public Patient(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public int compareTo(Patient o) {
        return this.priority - o.priority;
    }

    @Override
    public String toString() {
        return String.format("Patient (%s, %d)",  name, priority);
    }
}
