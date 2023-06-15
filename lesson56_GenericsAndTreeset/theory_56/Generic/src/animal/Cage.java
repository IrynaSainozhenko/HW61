public class Cage <T> extends Animal{
    T prisoner;

    public Cage(T prisoner) {
        this.prisoner = prisoner;
    }
}
