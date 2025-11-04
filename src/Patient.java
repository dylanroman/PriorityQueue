//
// Name: Roman, Dylan
// Project #4
// 11/4/2025
// Course: cs-2400-03-f25
//
// Description:
// Uses a Max Heap to implement a Priority Queue. Priority queue is tested in an ER room simulator.
//

public record Patient(String name, int priority) implements Comparable<Patient>{
    @Override
    public int compareTo(Patient o) {
        if (priority < o.priority) {
            return -1;
        } else if (priority == o.priority) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public String toString() {
        return String.format("Patient(%s, %d)", name, priority);
    }
}
