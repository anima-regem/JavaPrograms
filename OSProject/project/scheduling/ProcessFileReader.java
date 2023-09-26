package scheduling;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProcessFileReader {
    public List<Process> processes = new ArrayList<>();
    public int dispTime;

    public void getProcess(String filename) throws IOException {
            Scanner scanner = new Scanner(new File(filename));
            processes.clear();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();

                if (line.startsWith("DISP:")) {
                    dispTime = Integer.parseInt(line.split(":")[1].trim());
                }

                // Check for the beginning of a process entry
                if (line.startsWith("PID:")) {
                    String pid = line.split(":")[1].trim();
                    int arrTime = Integer.parseInt(scanner.nextLine().split(":")[1].trim());
                    int srvTime = Integer.parseInt(scanner.nextLine().split(":")[1].trim());
                    int priority = Integer.parseInt(scanner.nextLine().split(":")[1].trim());

                    // Create a new Process object and add it to the list
                    processes.add(new Process(pid, arrTime, srvTime, priority));
                }
            }

            // Now, 'processes' list contains all the Process objects read from the file


            scanner.close();
    }
}
