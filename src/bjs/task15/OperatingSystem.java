package bjs.task15;

import java.util.HashMap;

/**
 * Created by YM on 21.11.2015.
 * Class which presents information about operation system
 */
public class OperatingSystem {
    /**Name on the operation system*/
    private String operationSystem;
    /**Human readable computer name*/
    private String computerName;

    /**Instance of the current computer*/
    private Computer computer;

    /**Stores all installed applications*/
    private HashMap<String, Application> installedApplications;

    /**
     * Sets reference to the current computer
     * @param computer Current computer object
     */
    OperatingSystem (Computer computer) {
        this.computer = computer;
        installedApplications = new HashMap<String, Application>();
    }

    /**
     * Presents system requirements.
     */
    private class SystemRequirements {
        /**The CPU clock rate in GHz*/
        private final double MIN_PROCESSOR_CLOCK_RATE = 1;
        /**Random access memory size in Gb*/
        private final double MIN_RANDOM_ACCESS_MEMORY_SIZE = 2;
        /**Size of the fixed memory storage in Gb. E.g. hard-drive*/
        private final int MIN_FIXED_MEMORY_SIZE = 100;
    }

    /**
     * Checks system requirements
     * @return True if input system requirement is equal or greater than predefined
     */
    public boolean checkSystemRequirements() {
        SystemRequirements systemRequirements = new SystemRequirements();

        return computer.getProcessorClockRate() >= systemRequirements.MIN_PROCESSOR_CLOCK_RATE &&
                computer.getRandomAccessMemorySize() >= systemRequirements.MIN_RANDOM_ACCESS_MEMORY_SIZE &&
                computer.getFixedMemorySize() >= systemRequirements.MIN_FIXED_MEMORY_SIZE;
    }

    /**
     * Installs application into the operation system
     * @param application Application object
     * @return Number of the application installed
     */
    public int installApplication(Application application) {
        installedApplications.put(application.getApplicationId(), application);
        return installedApplications.size();
    }

    /**
     * Gets installed application by Id
     * @param applicationId Application Id
     * @return Returns installed application
     */
    public Application getApplication(String applicationId) {
        return installedApplications.get(applicationId);
    }

    /**
     * Shut down operation system
     */
    public void shutDown() {
        System.out.println("Operating system " + operationSystem + " is shut down.");

        installedApplications.clear();
        computer = null;
        computerName = null;
        operationSystem = null;
    }

    /**
     * Overrides Object.toString method
     * @return String with operation system characteristics and installed applications
     */
    @Override
    public String toString() {
        String result;
        result = "Operation system: " + getOperationSystem() + "\n";
        result += "Computer name: " + getComputerName() + "\n\n";

        result += "Installed applications: \n";

        for (String applicationId: installedApplications.keySet()) {
            result += "\t" + applicationId + "\n";
        }

        result += "\n";

        return result;
    }

    /**
     * Sets operating system type
     * @param operationSystem Type of the operation system
     */
    public void setOperationSystem(String operationSystem) {
        if (!operationSystem.isEmpty())
            this.operationSystem = operationSystem;
    }

    /**
     * Sets computer name
     * @param computerName Computer name
     */
    public void setComputerName(String computerName) {
        if (!computerName.isEmpty()) {
            this.computerName = computerName;
        }
    }

    /**
     * Gets operation system type
     * @return Operation system type
     */
    public String getOperationSystem() {
        return operationSystem;
    }

    /**
     * Gets computer name
     * @return computer name
     */
    public String getComputerName() {
        return computerName;
    }
}
