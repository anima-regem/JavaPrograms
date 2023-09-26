/*

Algorithm: Priority-Premptive (PP) Scheduling

Inputs:
- List of processes with attributes: arrival time (arrTime), service time (srvTime), process ID (pid), priority, remaining time (remainingTime), waiting time (waitingTime), and turn-around time (turnAroundTime).
- Dispatcher time (dispTime) - the time it takes to switch between processes.

Outputs:
- Average turn-around time (avgTT) and average waiting time (avgWT).

1. Start

2. Initialize currentProcess and prevProcess as null
3. Initialize currentTime, totalTurnAroundTime, and totalWaitingTime as 0
4. Create an empty queue named "arrQueue" to hold processes that have arrived but not yet started
5. Add all processes to "arrQueue"
6. Create a priority queue named "priorityQueue" that prioritizes processes based on their priority

7. Print "PP Scheduling:" to indicate the start of the Priority-Premptive scheduling

8. While "arrQueue" is not empty or "priorityQueue" is not empty, repeat steps 9-28

    8.1. While "arrQueue" is not empty and "arrQueue.peek().arrTime" is less than or equal to "currentTime", repeat steps 9.1-9.3
        8.1.1. Dequeue a process from "arrQueue" and assign it to "process"
        8.1.2. Set "process.remainingTime" to "process.srvTime"
        8.1.3. Enqueue "process" into "priorityQueue"

    8.2. If "priorityQueue" is empty, increment "currentTime" by 1 and move to the next iteration. This represents time passing when no processes are ready.

    8.3. If "prevProcess" is null or "prevProcess.pid" is not equal to "priorityQueue.peek().pid", repeat steps 9.4-9.5
        8.3.1. Increment "currentTime" by "dispTime" to account for the dispatcher time
        8.3.2. Set "prevProcess" as "priorityQueue.peek()"

    8.4. Set "currentProcess" as "priorityQueue.peek()"
    8.5. Decrement "currentProcess.remainingTime" by 1 to simulate the process executing for a unit of time

    8.6. If "currentProcess.remainingTime" becomes 0, repeat steps 9.6-9.8
        8.6.1. Calculate "currentProcess.turnAroundTime" as "currentTime - currentProcess.arrTime + 1"
        8.6.2. Calculate "currentProcess.waitingTime" as "currentProcess.turnAroundTime - currentProcess.srvTime"
        8.6.3. Increment "totalTurnAroundTime" by "currentProcess.turnAroundTime"
        8.6.4. Increment "totalWaitingTime" by "currentProcess.waitingTime"
        8.6.5. Dequeue the front process from "priorityQueue"

    8.7. Increment "currentTime" by 1 to move the simulation time forward

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

public class PP {
    public static float[] schedule(List<Process> processes, int dispTime) {

        Process currentProcess = null, prevProcess = null;
        int currentTime = 0;
        int totalTurnAroundTime = 0, totalWaitingTime = 0;

        Queue<Process> arrQueue = new LinkedList<Process>();

        arrQueue.addAll(processes);

        PriorityQueue<Process> priorityQueue = new PriorityQueue<>((t1, t2) -> t1.priority - t2.priority);

        System.out.println("\nPP:");

        while (!arrQueue.isEmpty() || !priorityQueue.isEmpty()) {
            while (!arrQueue.isEmpty() && arrQueue.peek().arrTime <= currentTime) {
                Process process = arrQueue.poll();
                process.remainingTime = process.srvTime;
                priorityQueue.add(process);
            }

            if (priorityQueue.isEmpty()) {
                currentTime++;
                continue;
            }

            if (prevProcess == null || !prevProcess.pid.equals(priorityQueue.peek().pid)) {
                currentTime += dispTime;
                prevProcess = priorityQueue.peek();
                System.out.printf("T%d: %s(%d)\n", currentTime, prevProcess.pid, prevProcess.priority);
            }

            currentProcess = priorityQueue.peek();
            currentProcess.remainingTime--;

            if (currentProcess.remainingTime == 0) {
                currentProcess.turnAroundTime = currentTime - currentProcess.arrTime + 1;
                currentProcess.waitingTime = currentProcess.turnAroundTime - currentProcess.srvTime;
                totalTurnAroundTime += currentProcess.turnAroundTime;
                totalWaitingTime += currentProcess.waitingTime;
                priorityQueue.poll();
            }
            currentTime++;
        }

        float avgWT = totalWaitingTime * 1.0F / processes.size();
        float avgTT = totalTurnAroundTime * 1.0F / processes.size();

        float[] result = { avgTT, avgWT };
        Process.display(processes);

        return result;
    }

}
