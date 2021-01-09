package Process;

import java.util.ArrayList;

public class ProcessControlBlock {
    
    private final int pid;
    private ProcessState state;
    // the following two ArrayLists should record when the process starts/stops
    // for statistical purposes
    private ArrayList<Integer> startTimes; // when the process starts running
    private ArrayList<Integer> stopTimes;  // when the process stops running
    
    private static int pidTotal= 0;
    
    public ProcessControlBlock() {
        this.state = ProcessState.NEW;
        this.startTimes = new ArrayList<>();
        this.stopTimes = new ArrayList<>();
        /* TODO: you need to add some code here DONE
         * Hint: every process should get a unique PID */
        this.pid = pidTotal;
        pidTotal += 1;
    }

    public ProcessState getState() {
        return this.state;
    }
    
    public void setState(ProcessState state, int currentClockTime) {
        /* TODO: you need to add some code here DONE
         * Hint: update this.state, but also include currentClockTime
         * in startTimes/stopTimes */

        if (state == ProcessState.RUNNING && this.state != ProcessState.RUNNING)
            startTimes.add(currentClockTime);
        else if (state == ProcessState.TERMINATED)
            stopTimes.add(currentClockTime);
        else if (state == ProcessState.READY && this.state == ProcessState.RUNNING)
            stopTimes.add(currentClockTime);

        this.state = state;
    }
    
    public int getPid() { 
        return this.pid;
    }
    
    public ArrayList<Integer> getStartTimes() {
        return startTimes;
    }
    
    public ArrayList<Integer> getStopTimes() {
        return stopTimes;
    }

}
