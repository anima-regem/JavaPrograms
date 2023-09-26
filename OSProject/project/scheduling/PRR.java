/*

Algorithm: Priority Round Robin (PRR) Scheduling

Inputs:
- List of processes with attributes: arrival time (arrTime), service time (srvTime), process ID (pid), priority, remaining time (remainingTime), waiting time (waitingTime), and turn-around time (turnAroundTime).
- Dispatcher time (dispTime) - the time it takes to switch between processes.

Outputs:
- Average turn-around time (avgTT) and average waiting time (avgWT).

1. Start

2. Initialize currentProcess and prevProcess as null
3. Initialize currentTime, HPCTimeQuantum, and LPCTimeQuantum
4. Initialize totalTurnAroundTime and totalWaitingTime as 0
5. Initialize notCompleted as false

6. Create an empty queue named "arrQueue" to hold processes that have arrived but not yet started
7. Add all processes to "arrQueue"

8. Create an empty queue named "readyQueue" to hold processes that are ready for execution

9. Print "PRR Scheduling:" to indicate the start of the Priority Round Robin scheduling

10. While "arrQueue" is not empty or "readyQueue" is not empty, repeat steps 11-34

    10.1. While "arrQueue" is not empty and "arrQueue.peek().arrTime" is less than or equal to "currentTime", repeat steps 11.1-11.3
        10.1.1. Dequeue a process from "arrQueue" and assign it to "process"
        10.1.2. Set "process.remainingTime" to "process.srvTime"
        10.1.3. Enqueue "process" into "readyQueue"

    10.2. If "notCompleted" is true, enqueue "currentProcess" back into "readyQueue", and set "notCompleted" as false

    10.3. If "readyQueue" is empty, increment "currentTime" by 1 and move to the next iteration. This simulates time passing when no processes are ready.

    10.4. If "prevProcess" is null or "prevProcess.pid" is not equal to "readyQueue.peek().pid", repeat steps 11.4-11.5
        10.4.1. Increment "currentTime" by "dispTime" to account for the dispatcher time
        10.4.2. Set "prevProcess" as "readyQueue.peek()"

    10.5. Dequeue a process from the front of "readyQueue" and assign it to "currentProcess"

    10.6. Set "timeQuantum" based on the priority of "currentProcess":
        - If priority is less than 3, use HPCTimeQuantum
        - Else, use LPCTimeQuantum

    10.7. If "currentProcess.remainingTime" is greater than "timeQuantum", repeat steps 11.7-11.8
        10.7.1. Decrement "currentProcess.remainingTime" by "timeQuantum"
        10.7.2. Increment "currentTime" by "timeQuantum"
        10.7.3. Set "notCompleted" as true to indicate that the process was not completed within this time slice

    10.8. Else, execute the remaining time of "currentProcess", repeat steps 11.8-11.11
        10.8.1. Increment "currentTime" by "currentProcess.remainingTime"
        10.8.2. Calculate "currentProcess.turnAroundTime" as "currentTime - currentProcess.arrTime"
        10.8.3. Calculate "currentProcess.waitingTime" as "currentProcess.turnAroundTime - currentProcess.srvTime"
        10.8.4. Increment "totalTurnAroundTime" by "currentProcess.turnAroundTime"
        10.8.5. Increment "totalWaitingTime" by "currentProcess.waitingTime"

11. Calculate "avgWT" by dividing "totalWaitingTime" by the number of processes
12. Calculate "avgTT" by dividing "totalTurnAroundTime" by the number of processes

13. Display the process details using "Process.display(processes)"

14. Return an array containing "avgTT" and "avgWT"

15. End


*/


package scheduling;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PRR {
    public static float[] schedule(List<Process> processes, int dispTime) {

        Process currentProcess = null, prevProcess = null;
        int currentTime = 0;

        int HPCTimeQuantum = 4, LPCTimeQuantum = 2;
        int totalTurnAroundTime = 0, totalWaitingTime = 0;

        boolean notCompleted = false;

        Queue<Process> arrQueue = new LinkedList<Process>();

        arrQueue.addAll(processes);

        Queue<Process> readyQueue = new LinkedList<>();

        System.out.println("\nPRR:");

        while (!arrQueue.isEmpty() || !readyQueue.isEmpty()) {
            while (!arrQueue.isEmpty() && arrQueue.peek().arrTime <= currentTime) {
                Process process = arrQueue.poll();
                process.remainingTime = process.srvTime;
                readyQueue.add(process);
            }

            if (notCompleted) {
                readyQueue.add(currentProcess);
                notCompleted = false;
            }

            if (readyQueue.isEmpty()) {
                currentTime++;
                continue;
            }

            if (prevProcess == null || !prevProcess.pid.equals(readyQueue.peek().pid)) {
                currentTime += dispTime;
                prevProcess = readyQueue.peek();
                System.out.printf("T%d: %s(%d)\n", currentTime, prevProcess.pid, prevProcess.priority);
            }

            currentProcess = readyQueue.poll();
            int timeQuantum = currentProcess.priority < 3 ? HPCTimeQuantum : LPCTimeQuantum;
            if (currentProcess.remainingTime > timeQuantum) {
                currentProcess.remainingTime -= timeQuantum;
                currentTime += timeQuantum;
                notCompleted = true;
            } else {
                currentTime += currentProcess.remainingTime;
                currentProcess.turnAroundTime = currentTime - currentProcess.arrTime;
                currentProcess.waitingTime = currentProcess.turnAroundTime - currentProcess.srvTime;
                totalTurnAroundTime += currentProcess.turnAroundTime;
                totalWaitingTime += currentProcess.waitingTime;
            }

        }

        float avgWT = totalWaitingTime * 1.0F / processes.size();
        float avgTT = totalTurnAroundTime * 1.0F / processes.size();

        float[] result = { avgTT, avgWT };
        Process.display(processes);

        return result;
    }

}
