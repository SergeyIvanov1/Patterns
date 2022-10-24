package facade;

public class FacadeApp {
    public static void main(String[] args) {
//        Power power = new Power();
//        power.on();
//
//        DVDRom dvdRom = new DVDRom();
//        dvdRom.load();
//
//        HDD hdd = new HDD();
//        hdd.copyFromDVD(dvdRom);

//        Фасад работает так: теперь можно, что сверху не писать,
//        а создать один класс и все остальное скрыть в нем. Фасад объеденил внутри все классы \
//        и определил порядок вызовов их методов
        Computer computer = new Computer();
        computer.copy();
    }
}

//Facade
class Computer{
    Power power = new Power();
    DVDRom dvdRom = new DVDRom();
    HDD hdd = new HDD();

    void copy(){
        power.on();
        dvdRom.load();
        hdd.copyFromDVD(dvdRom);
    }
}

class Power{
    void on(){
        System.out.println("Включение питания");
    }

    void oаа(){
        System.out.println("Выключение питания");
    }
}

class DVDRom{
    private boolean data = false;

    public boolean hasData() {
        return data;
    }

    void load(){
        data = true;
    }

    void unload(){
        data = false;
    }
}

class HDD{
    void copyFromDVD(DVDRom dvd){
        if (dvd.hasData()){
            System.out.println("Происходит копирование данных с диска");
        } else {
            System.out.println("Вставьте диск с данными");
        }
    }
}

