public class Main {
    public static void main(String[] args) {
        // панда внутри клетки
        PandaCage pandaCage = new PandaCage(new Panda());
        // можем вызвать метод класс Panda
        pandaCage.prisoner.eatBamboo();
        // сможем ли мы в PandaCage положить тигра?
        TigerCage tigerCage = new TigerCage(new Tiger());
        // можем вызвать метод от заключенного - это метод класса Tiger
        tigerCage.prisoner.roar();

        // Как бы это выглядело без дженериков
        ObjectCage objectCage1 = new ObjectCage(new Panda());
        ObjectCage objectCage2 = new ObjectCage(new Tiger());
        // нет никакого ограничения, что можем пеместить внутрь
        ObjectCage objectCage3 = new ObjectCage(tigerCage);
        // Какая проблема?
        // 1. во-первых нет ограничений, что мы можем туда положить
        // 2. мы не можем вызвать методов специфических для конкретных классов
        // например, не можем вызвать метод eat bamboo
        // objectCage2.prisoner.eatBamboo();  // - eatBamboo() - горит красным
        // - потому что у класса объект нет такого метода

        // Поэтому нам и нужны дженерики
        // Мы сможем сделать универсальный класс, и методы будут нам доступны
        Cage<Panda> cage1 = new Cage<>(new Panda());
        // в отличие от ObjectCage - нам доступны методы
        cage1.prisoner.eatBamboo();
        // Не можем создать клетку с человеком -
        // потому что у нас ограничения public class Cage <T extends Animal>
        // Cage<Person> cage2 = new Cage<Person>(new Person()); // с ошибкой
     }
}