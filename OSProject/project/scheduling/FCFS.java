/*

Algorithm: FCFS Scheduling

Inputs:

    List of processes with attributes: arrival time (arrTime), service time (srvTime), process ID (pid), priority, waiting time (waitingTime), and turn-around time (turnAroundTime).
    Dispatcher time (dispTime) - the time it takes to switch between processes.

Outputs:

    Average turn-around time (avgTT) and average waiting time (avgWT).

    1. Start

    2. Initialize a queue named readyQueue to hold the processes.

    3. Add all the processes to the readyQueue.

    4. Initialize variables currentTime, totalTurnAroundTime, and totalWaitingTime to 0.

    5. Print a header indicating the start of FCFS scheduling.

    6. Repeat the following until readyQueue is empty:
            a. If the arrival time of the process at the front of the readyQueue is greater than the current time (currentTime), increment currentTime and continue to the next iteration.
            b. Remove the process from the front of the readyQueue and assign it to currentProcess.
            c. Increment currentTime by dispTime to account for the dispatcher time.
            d. Print the start time of the current process and its ID.
            e. Increment currentTime by the service time of the currentProcess.
            f. Calculate the turn-around time for the currentProcess as the difference between the current time and its arrival time.
            g. Calculate the waiting time for the currentProcess as the difference between its turn-around time and service time.
            h. Update totalWaitingTime and totalTurnAroundTime by adding the waiting and turn-around times of the currentProcess, respectively.

    7. Calculate the average waiting time (avgWT) by dividing totalWaitingTime by the number of processes.

    8. Calculate the average turn-around time (avgTT) by dividing totalTurnAroundTime by the number of processes.

    9. Return an array containing avgTT and avgWT.

    10. End

*/

package scheduling;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FCFS {

    public static float[] schedule(List<Process> processes, int dispTime) {
        Queue<Process> readyQueue = new LinkedList<>();

        readyQueue.addAll(processes);

        int currentTime = 0;
        int totalTurnAroundTime = 0, totalWaitingTime = 0;

        System.out.println("\nFCFS:");

        while (!readyQueue.isEmpty()) {

            if (readyQueue.peek().arrTime > currentTime) {
                currentTime++;
                continue;
            }

            Process currentProcess = readyQueue.poll();
            currentTime += dispTime;
            System.out.printf("T%d: %s(%d)\n", currentTime, currentProcess.pid, currentProcess.priority);
            currentTime += currentProcess.srvTime;
            currentProcess.turnAroundTime = currentTime - currentProcess.arrTime;
            currentProcess.waitingTime = currentProcess.turnAroundTime - currentProcess.srvTime;
            totalWaitingTime += currentProcess.waitingTime;
            totalTurnAroundTime += currentProcess.turnAroundTime;
        }

        float avgWT = totalWaitingTime * 1.0F / processes.size();
        float avgTT = totalTurnAroundTime * 1.0F / processes.size();

        float[] result = { avgTT, avgWT };
        Process.display(processes);

        return result;
    }

}
