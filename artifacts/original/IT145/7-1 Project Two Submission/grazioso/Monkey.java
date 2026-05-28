public class Monkey extends RescueAnimal {

    // Instance variables specific to monkeys
    private double tailLength;
    private double height;
    private double bodyLength;
    private String species;

    // Constructor
    public Monkey(String name, String gender, String age, String weight, String acquisitionDate, String acquisitionCountry, String trainingStatus, boolean reserved, String inServiceCountry, double tailLength, double height, double bodyLength, String species) {
        setName(name);
        setGender(gender);
        setAge(age);
        setWeight(weight);
        setAcquisitionDate(acquisitionDate);
        setAcquisitionLocation(acquisitionCountry);
        setTrainingStatus(trainingStatus);
        setReserved(reserved);
        setInServiceCountry(inServiceCountry);
        setTailLength(tailLength);
        setHeight(height);
        setBodyLength(bodyLength);
        setSpecies(species);
    }

    // Accessor and mutator methods for Monkey attributes
    public double getTailLength() {
        return tailLength;
    }

    public void setTailLength(double tailLength) {
        this.tailLength = tailLength;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getBodyLength() {
        return bodyLength;
    }

    public void setBodyLength(double bodyLength) {
        this.bodyLength = bodyLength;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public static void main(String[] args) {
        // This is just a placeholder main method
        System.out.println("This is the main method of the Monkey class.");
    }

	
}
