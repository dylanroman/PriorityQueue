//
// Name: Roman, Dylan
// Project #4
// 11/4/2025
// Course: cs-2400-03-f25
//
// Description:
// Uses a Max Heap to implement a Priority Queue. Priority queue is tested in an ER room simulator.
//

public class ERApp {
    public static void main(String[] args) {
        System.out.println("Emergency Room Simulation by D. Roman\n");

        Patient[] patients = {new Patient("Angela", 3), new Patient("Yeema", 5), new Patient("Gojo", 1), new Patient("Bryce", 6), new Patient("Brimstone", 5), new Patient("Caleb", 4), new Patient("Deelan", 4)};

        PriorityQueueInterface<Patient> hospital = new MaxHeapPriorityQueue<>();

        for  (Patient patient : patients) {
            System.out.println("Add a new " + patient);
            hospital.add(patient);
        }

        System.out.println();

        System.out.printf("All Waiting Patients (%d):\n", hospital.getSize());
        ((MaxHeapPriorityQueue<Patient>) hospital).displayPriorityQueue();

        while(!hospital.isEmpty()) {
            System.out.println("Treat patient: " + hospital.remove());
            System.out.printf("Display all waiting patients (%d):\n", hospital.getSize());

            ((MaxHeapPriorityQueue<Patient>) hospital).displayPriorityQueue();

            if (hospital.getSize() > 0) {
                System.out.printf("Next Patient: %s\n", hospital.peek().name());
            }

            System.out.println();

        }

    }
}
