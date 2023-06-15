package example02;

public class Main {
    public static void main(String[] args) {

        Nokia3310 nokia = new Nokia3310(); //создали объект Нокии
        IPhone iPhone = new IPhone();  // создали объект Айфона

        Cover coverForNokia = new Cover(nokia); // положили нокиую в обложку
        Cover coverForIPhone = new Cover(iPhone); // положили айфон в обложку
//    Расширенная запись
        Object nokiaFromCoverAsObject = coverForNokia.getPhone();
        Nokia3310 nokiaFromCover = (Nokia3310) nokiaFromCoverAsObject;
//   Упрощенная запись
        IPhone iPhoneFromCover = (IPhone) coverForIPhone.getPhone();

        nokiaFromCover.call();
        iPhoneFromCover.takePhoto();


    }
}
