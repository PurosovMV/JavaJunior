public class Dog extends Animal {
    private String color;
    private double weight;

    public Dog(String name, int age, String color, double weight) {
        super(name, age);
        this.color = color;
        this.weight = weight;
    }

    public Dog(String name, int age) {
        super(name, age);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void makeSound() {
        System.out.println(super.getName() + " say \"gav\"");
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name: " + super.getName() + ", " +
                "age: " + super.getAge() + " years, " +
                "color: " + color + ", " +
                "weight: " + weight + " kg, " +
                '}';
    }


}

