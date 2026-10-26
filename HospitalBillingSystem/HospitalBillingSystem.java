package Assignment;

// Abstract class
abstract class MedicalService {
    protected String serviceId;
    protected String serviceName;
    protected double baseCost;

    public MedicalService(String serviceId, String serviceName, double baseCost) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.baseCost = baseCost;
    }

    // Abstract method
    public abstract double calculateTotalCost();

    // Concrete method
    public void displayServiceInfo() {
        System.out.println("Service ID: " + serviceId);
        System.out.println("Service: " + serviceName);
        System.out.printf("Total Cost: $%.2f\n", calculateTotalCost());
        System.out.println();
    }
}

// Subclass 1: Consultation
class Consultation extends MedicalService {
    private double doctorFee;

    public Consultation(String serviceId, String serviceName, double baseCost, double doctorFee) {
        super(serviceId, serviceName, baseCost);
        this.doctorFee = doctorFee;
    }

    @Override
    public double calculateTotalCost() {
        return baseCost + doctorFee;
    }
}

// Subclass 2: LaboratoryTest
class LaboratoryTest extends MedicalService {
    private double testCharge;

    public LaboratoryTest(String serviceId, String serviceName, double baseCost, double testCharge) {
        super(serviceId, serviceName, baseCost);
        this.testCharge = testCharge;
    }

    @Override
    public double calculateTotalCost() {
        return baseCost + testCharge;
    }
}

// Subclass 3: Ultrasound
class Ultrasound extends MedicalService {
    private double additionalFee;

    public Ultrasound(String serviceId, String serviceName, double baseCost, double additionalFee) {
        super(serviceId, serviceName, baseCost);
        this.additionalFee = additionalFee;
    }

    @Override
    public double calculateTotalCost() {
        return baseCost + additionalFee;
    }
}

// Main class
public class HospitalBillingSystem {
    public static void main(String[] args) {
        MedicalService[] services = new MedicalService[3];

        services[0] = new Consultation("S001", "Consultation", 15.0, 10.0);
        services[1] = new LaboratoryTest("S002", "Laboratory Test", 10.0, 8.0);
        services[2] = new Ultrasound("S003", "Ultrasound", 25.0, 15.0);

        System.out.println("===== HOSPITAL BILLING SYSTEM =====");
        System.out.println();

        double totalBill = 0.0;

        for (MedicalService service : services) {
            service.displayServiceInfo();
            totalBill += service.calculateTotalCost();
        }

        System.out.println("------------------------------");
        System.out.printf("Total Hospital Bill: $%.2f\n", totalBill);
    }
}

