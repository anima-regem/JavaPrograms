/*

Algorithm: Shortest Process Next (SPN) Scheduling

Inputs:
- List of processes with attributes: arrival time (arrTime), service time (srvTime), process ID (pid), priority, waiting time (waitingTime), and turn-around time (turnAroundTime).
- Dispatcher time (dispTime) - the time it takes to switch between processes.

Outputs:
- Average turn-around time (avgTT) and average waiting time (avgWT).

1. Start

2. Initialize currentProcess as null
3. Initialize currentTime, totalTurnAroundTime, and totalWaitingTime as 0

4. Create an empty queue named "arrQueue" to hold processes that have arrived but not yet started
5. Add all processes to "arrQueue"

6. Create a priority queue named "priorityQueue" that prioritizes processes based on their service time

7. Print "SPN Scheduling:" to indicate the start of the Shortest Process Next scheduling

8. While "arrQueue" is not empty or "priorityQueue" is not empty, repeat steps 9-28

    8.1. While "arrQueue" is not empty and "arrQueue.peek().arrTime" is less than or equal to "currentTime", repeat steps 9.1-9.2
        8.1.1. Enqueue the process from "arrQueue" into "priorityQueue"
    
    8.2. If "priorityQueue" is empty, increment "currentTime" by 1 and move to the next iteration. This represents time passing when no processes are ready.

    8.3. Dequeue a process from the front of "priorityQueue" and assign it to "currentProcess"
    8.4. Increment "currentTime" by "dispTime" to account for the dispatcher time
    8.5. Print the start time of "currentProcess" and its ID

    8.6. Increment "currentTime" by "currentProcess.srvTime"
    8.7. Calculate "currentProcess.turnAroundTime" as "currentTime + currentProcess.arrTime"
    8.8. Calculate "currentProcess.waitingTime" as "currentProcess.turnAroundTime - currentProcess.srvTime"
    8.9. Increment "totalTurnAroundTime" by "currentProcess.turnAroundTime"
    8.10. Increment "totalWaitingTime" by "currentProcess.waitingTime"

9. Calculate "avgWT" by dividing "totalWaitingTime" by the number of processes
10. Calculate "avgTT" by dividing "totalTurnAroundTime" by the number of processes

11. Display the process details using "Process.display(processes)"

12. Return an array containing "avgTT" and "avgWT"

13. End


*/


package scheduling;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class SPN {
    public static float[] schedule(List<Process> processes, int dispTime) {

        Process currentProcess = null;
        int currentTime = 0;

        int totalTurnAroundTime = 0, totalWaitingTime = 0;

        Queue<Process> arrQueue = new LinkedList<Process>();

        arrQueue.addAll(processes);

        PriorityQueue<Process> priorityQueue = new PriorityQueue<>((t1, t2) -> t1.srvTime - t2.srvTime);

        System.out.println("\nSPN:");

        while (!arrQueue.isEmpty() || !priorityQueue.isEmpty()) {

            while (!arrQueue.isEmpty() && arrQueue.peek().arrTime <= currentTime) {
                priorityQueue.add(arrQueue.poll());
            }

            if (priorityQueue.isEmpty()) {
                currentTime++;
                continue;
            }

            currentProcess = priorityQueue.poll();
            currentTime += dispTime;
            System.out.printf("T%d: %s(%d)\n", currentTime, currentProcess.pid,
                    currentProcess.priority);

            currentTime += currentProcess.srvTime;

            currentProcess.turnAroundTime = currentTime + currentProcess.arrTime;
            currentProcess.waitingTime = currentProcess.turnAroundTime - currentProcess.srvTime;
            totalTurnAroundTime += currentProcess.turnAroundTime;
            totalWaitingTime += currentProcess.waitingTime;

        }

        float avgWT = totalWaitingTime * 1.0F / processes.size();
        float avgTT = totalTurnAroundTime * 1.0F / processes.size();

        float[] result = { avgTT, avgWT };
        Process.display(processes);

        return result;
    }

}
