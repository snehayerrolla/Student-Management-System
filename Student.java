class Student {

    private String name;
    private String rollNumber;
    private double marks;

    // Constructor
    public Student(String name, String rollNumber, double marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    // Getters
    public String getRollNumber() {
        return rollNumber;
    }

    public void display() {
        System.out.println("Name       : " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.printf("Marks      : %.2f\n", marks);
        System.out.println("---------------------------");
    }

    // Update method
    public void update(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }
}