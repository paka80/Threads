public class StatsManagment {

    private int boxesType1;
    private int boxesType2;
    private int boxesType3;
    private int boxesDock1;
    private int boxesDock2;

    public StatsManagment() {
        this.boxesType1 = 0;
        this.boxesType2 = 0;
        this.boxesType3 = 0;
        this.boxesDock1 = 0;
        this.boxesDock2 = 0;
    }

    public void printStats() {
        System.out.println("==== System Statistics ====");

        // Number of boxes by type
        System.out.println("Number of boxes by type:");
        System.out.println(" - Type 1: " + boxesType1);
        System.out.println(" - Type 2: " + boxesType2);
        System.out.println(" - Type 3: " + boxesType3);
        System.out.println();

        // Number of boxes in docks
        System.out.println("Number of boxes in docks:");
        System.out.println(" - Dock 1 (Type 1): " + boxesDock1);
        System.out.println(" - Dock 2 (Type 2): " + boxesDock2);
        System.out.println(" - Dock End: (Type 1): " + (boxesType1 - boxesDock1) + " | (Type2): " + (boxesType2 - boxesDock2) + " | (Type3): " + boxesType3);

        System.out.println();

        // Total number of boxes
        int totalBoxes = boxesType1 + boxesType2 + boxesType3;
        System.out.println("Total number of boxes in the system: " + totalBoxes);
        int totalDockedBoxes = boxesDock1 + boxesDock2 + boxesType3;
        System.out.println("Total number of docked boxes: " + totalDockedBoxes);
        int totalRejectedBoxes = (boxesType1 - boxesDock1) + (boxesType2 - boxesDock2);
        System.out.println("Total number of rejected boxes: " + totalRejectedBoxes);
        System.out.println();

        // Percentages of correctly docked boxes
        double dock1Percentage = boxesType1 > 0 ? (boxesDock1 / (double) boxesType1) * 100 : 0.0;
        double dock2Percentage = boxesType2 > 0 ? (boxesDock2 / (double) boxesType2) * 100 : 0.0;

        System.out.println("Percentage of correctly docked boxes:");
        System.out.printf(" - Type 1 (Dock 1): %.2f%%%n", dock1Percentage);
        System.out.printf(" - Type 2 (Dock 2): %.2f%%%n", dock2Percentage);
        System.out.println("================================");
    }

    public void addBox1() {
        this.boxesType1++;
    }
    public void addBox2() {
        this.boxesType2++;
    }
    public void addBox3() {
        this.boxesType3++;
    }
    public void addDock1() {
        this.boxesDock1++;
    }
    public void addDock2() {
        this.boxesDock2++;
    }

}
