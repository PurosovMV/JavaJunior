public class Cat extends Animal {
    private String color;

    public Cat(String name, int age) {
        super(name, age);
    }

    public Cat(String name, int age, String color) {
        super(name, age);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void jump() {
        System.out.println(super.getName() + "made a jump");
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name: " + super.getName() + ", " +
                " age: " + super.getAge() + " years, " +
                " color: " + color +
                '}';
    }
}
