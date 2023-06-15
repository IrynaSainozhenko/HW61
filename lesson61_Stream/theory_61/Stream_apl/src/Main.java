import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // stream api
        List<String> fruits = new ArrayList<>();
        fruits.add("apple");
        fruits.add("orange");
        fruits.add("lemon");
        fruits.add("avocado");
        fruits.add("pineapple");
        System.out.println(fruits);
        // как создать новый лист
        // "apple" -> "Fruit apple"
        // метод map - позволяет получить новую коллекцию
        // которая будет создана из элементов старой
        // логика создания заключена в лямбду
        List<String> fruits2 =
                fruits
                        .stream()
                        .map((fruit) -> "Fruit " + fruit)
                        .toList();
        System.out.println(fruits2);

        List<Integer> fruitsLengthes =
                fruits
                        .stream()     //создали поток
                        .map((a) -> a.length()) // используем мап для создания нового листа
                        .toList();    // закрыли поток == собрали все элементы в лист
        System.out.println(fruitsLengthes);

        // Создайте класс Person с полями: height, name
        // Создайте лист из 5 персон
        // Используя stream api
        // Создайте два листа:
        // - лист имен
        // - лист ростов
        List<Person> people = new ArrayList<>();

        people.add(new Person(167, "Melaniia"));
        people.add(new Person(158, "Kira"));
        people.add(new Person(178, "Dmitrii"));
        people.add(new Person(165, "Amina"));
        people.add(new Person(160, "Anna"));

        System.out.println(people);

        List<Integer> heights =
                people
                    .stream()
                    .map(Person::getHeight)
                    .toList();
        System.out.println(heights);

        List<String> names =
                people
                    .stream()
                    .map(Person::getName)
                    // возвели в верхний регистр
                    .map(String::toUpperCase)
                    .sorted((o1, o2) -> o1.compareTo(o2))
                    .toList();

        System.out.println(names);
        System.out.println(names);


// filter с функциональным интерфейсом Predicate
        // позволяет отобрать элементы удовлетворяющие предикату
        List<Integer> numbers =
                new ArrayList<>(List.of(
                    2, 19, 20, 3, 8, 15));
        List<Integer> filteredNumbers =
                numbers
                    .stream()
                    .filter((a) -> a > 8)
                    .collect(Collectors.toList());

        System.out.println(numbers);
        System.out.println(filteredNumbers);

        // отфильтруем персон > 170 и < 190
        List<Person> filteredPersons =
                people
                    .stream()
                    .filter((a)->a.getHeight() > 170 && a.getHeight()<190)
                    .toList();
        System.out.println(filteredPersons);

        // distinct - оставляет только уникальные элементы
        // чтобы он корректно работал, нужен метод equals!!!
        List<String> cars =
                List.of("BMW", "Opel", "BMW", "Porsche");

        List<String> uniqueCars =
                cars.stream().distinct().toList();

        System.out.println(cars);
        System.out.println(uniqueCars);

        // limit - создает новый лист, на основании старого
        // длиной не больше чем указанная цифра
        List<Integer> numbers2 =
                new ArrayList<>(List.of(
                        2, 19, 20, 3, 8, 15, 2, 19, 20, 3, 8, 15));

        List<Integer> limitedNumbers =
                numbers2.stream().limit(10).toList();

        System.out.println(numbers2);
        System.out.println(limitedNumbers);

        // Терминальные операции - конечные,
        // после них нельзя продолжать - поток закрывается
        // к этому потоку больше нельзя обращаться
        // anyMatch - хотя бы один совпадает,
        // noneMatch - нет совпадений,
        // allMatch - все элементы совпадают == удовлетворяют условию
        List<String> animals = new ArrayList<>();
        animals.add("Bear");
        animals.add("Panda");
        animals.add("Crocodile");
        animals.add("Snake");
        animals.add("Lizard");
        animals.add("Penguin");
        System.out.println(animals);

        // anyMatch - есть хотя бы один элемент удовлетворяющий условию
        boolean hasPanda =
                animals.stream().anyMatch((a)->a.equals("Panda"));
        System.out.println(hasPanda);

        // allMatch - все элементы удовлетворяют условию
        boolean allArePandas =
                animals.stream().allMatch((a)->a.equals("Panda"));
        System.out.println(allArePandas);

        // noneMatch - нет элемента удовлетворяющего условию
        boolean hasNoPanda =
                animals.stream().noneMatch((a)->a.equals("Panda"));
        System.out.println(hasNoPanda);

        // Создайте класс Rectangle
        // с полями length, width - длинна, ширина
        // создайте лист прямоугольников
        // Узнайте, есть ли в листе фигуры с площадью > 10
        // Узнайте, если фигура с площадью равной 16
        // Узнайте все ли фигуры обладают площадью больше 4-х
        List<Rectangle> rectangles = new ArrayList<>();
        rectangles.add(new Rectangle(4, 2));
        rectangles.add(new Rectangle(5, 10));
        rectangles.add(new Rectangle(5, 10));
        rectangles.add(new Rectangle(2, 3));
        rectangles.add(new Rectangle(4, 4));
        rectangles.add(new Rectangle(1, 2));
        System.out.println(rectangles);

        boolean hasRectangleBiggerThenTen =
                rectangles.stream()
                        .map(a -> a.getLength() * a.getWidth())
                        .anyMatch(area -> area > 10);

        boolean hasRectangleEqualsSixteenVer1 =
                rectangles.stream()
                        .anyMatch(Rectangle::isEqualsToSixteen);

        boolean hasRectangleEqualsSixteenVer2 =
                rectangles.stream()
                        .map(Rectangle::calculateArea)
                        .anyMatch(area -> area == 16);
        boolean allRectanglesAreGreaterThenFour =
                rectangles.stream()
                        .map(a -> a.getLength() * a.getWidth())
                        .allMatch(area -> area > 4);

        System.out.println(hasRectangleBiggerThenTen);
        System.out.println(hasRectangleEqualsSixteenVer1);
        System.out.println(hasRectangleEqualsSixteenVer2);
        System.out.println(allRectanglesAreGreaterThenFour);


        // можно узнать количество элементов в стриме
        Long count = numbers2.stream().count();
        System.out.println(count);
        Long numberOfTall =
                people.stream()
                        .filter((p)->p.getHeight() > 1.65)
                        .count();
        System.out.println(numberOfTall);

        // reduce
        // не создает новый стрим
        // возвращает какое-то одно значение
        // Например, можно посчитать сумму
        List<Integer> luckyNumbers =
                List.of(3, 7, 13, 2);

        // хотим просуммировать числа
        Integer sum1 = luckyNumbers.stream()
                .reduce(0, (a, b)-> a+b);

        Integer sum2 = luckyNumbers.stream()
                .reduce(0, Integer::sum);

        Integer[] nums = new Integer[]{5, 10, 13};
        Arrays.stream(nums).sorted();
        System.out.println(sum2);

        //forEach - если нам нужно мутировать - вызвать сайд-эффект
        // forEach ничего не возвращает
        people.forEach(person -> person.setHeight(person.getHeight() + 10));
        System.out.println(people);

        // Итого:
        // map - если нужно получить новый лист и не менять старый
        // reduce - рассчитать какое-то одно значение для листа, например сумма
        // forEach - если нужно изменить объекты исходного листа - мутировать их



    }
}