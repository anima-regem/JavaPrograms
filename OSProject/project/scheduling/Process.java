package scheduling;

import java.util.List;

public class Process {
    String pid;
    int arrTime;
    int srvTime;
    int priority;
    int remainingTime;
    int waitingTime;
    int turnAroundTime;

    public Process(String pid, int arrTime, int srvTime, int priority) {
        this.pid = pid;
        this.arrTime = arrTime;
        this.srvTime = srvTime;
        this.priority = priority;
    }

    public static void display(List<Process> processes) {
        System.out.println("\nProcess\t\tTurnaround Time\t\tWaiting Time");
        for (Process process : processes) {
            System.out.printf("%s\t\t%d\t\t\t%d\n", process.pid, process.turnAroundTime, process.waitingTime);
        }
    }
}
