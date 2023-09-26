import java.io.IOException;
import java.util.List;

import scheduling.ProcessFileReader;
import scheduling.SPN;
import scheduling.PP;
import scheduling.PRR;
import scheduling.Process;
import scheduling.FCFS;

public class A1 {
    public static void main(String[] args) throws IOException {
        ProcessFileReader pfr = new ProcessFileReader();
        pfr.getProcess(args[0]);
        List<Process> processes = pfr.processes;
        int dispTime = pfr.dispTime;

        float[] FCFSResult = FCFS.schedule(processes, dispTime);
        float[] SPNResult = SPN.schedule(processes, dispTime);
        float[] PPResult = PP.schedule(processes, dispTime);
        float[] PRRResult = PRR.schedule(processes, dispTime);

        System.out.println("\nSummary\nAlgorithm\tAverage Turnaround Time\t\tAverage Waiting Time");
        System.out.printf("FCFS\t\t%.2f\t\t\t\t%.2f\n", FCFSResult[0], FCFSResult[1]);
        System.out.printf("SPN\t\t%.2f\t\t\t\t%.2f\n", SPNResult[0], SPNResult[1]);
        System.out.printf("PP\t\t%.2f\t\t\t\t%.2f\n", PPResult[0], PPResult[1]);
        System.out.printf("PRR\t\t%.2f\t\t\t\t%.2f\n\n", PRRResult[0], PRRResult[1]);
    }
}
