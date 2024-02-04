import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException {

        List<Animal> animalArray = new ArrayList<>();

        animalArray.add(new Cat("Musya", 3, "white"));
        animalArray.add(new Cat("Vasya", 5, "grey"));
        animalArray.add(new Dog("Grey", 1, "grey", 12));
        animalArray.add(new Dog("Danya", 10, "black", 10));


        Class<?> animalClass = null;
        for (Animal animal : animalArray) {
            System.out.println(animal);
            if (animal.getClass().equals(Cat.class)) {
                animalClass = Class.forName("Cat");
            } else {
                animalClass = Class.forName("Dog");
            }


            //список полей
            Field[] superFields = animalClass.getSuperclass().getDeclaredFields();
            Field[] classFields = animalClass.getDeclaredFields();
            Field[] allFields = new Field[superFields.length + classFields.length];

            Arrays.setAll(allFields, i ->
                    (i < classFields.length ? classFields[i] : superFields[i - classFields.length]));

            for (Field field : allFields) {
                System.out.println("Field: " + field.getName() + ", type: " + field.getType().getName());
            }
            System.out.println();

            // Вывести все методы классов:
            Method[] methods = animalClass.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println("Method: " + method.getName() +
                        ", Return type: " + method.getReturnType() +
                        ", parameter types" + Arrays.toString(method.getParameterTypes()));
            }
            System.out.println();

            // Вызов метода "makeSound()":
            Method makeSoundMethod;
            try {
                makeSoundMethod = animalClass.getDeclaredMethod("makeSound");
                makeSoundMethod.invoke(animal);
                System.out.println();
            } catch (NoSuchMethodException e) {
                System.out.println("У этого животного нет метода \"makeSound()\" \n");

            }
        }
    }
}

