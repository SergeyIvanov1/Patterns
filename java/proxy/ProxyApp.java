package proxy;

//Паттерн Proxy предоставляет объект-заменитель вместо настоящего объекта.
//Этот объект контролирует доступ к оригинальному объекту. Используется очень часто.
//Mockito.spy() или аннотации @Spy

//Ленивая загрузка
//Пример реализации виртуального прокси
// Здесь реализация заместителя. Т.е. например мы рефакторим код и нам не нужно,
// чтобы картинка грузилась сразу из конструктора (мы не можем поменять код RealImage),
// мы создаем Proxy, который также реализует интерфейс,
// но часть работы реального сервиса он делает, а загрузка выносится в зависимость
//Прокси Позволяет позволяет работать с собой как с реальным объектом,
//откладывая создание до того времени как это действительно нужно. Т.е. некая оптимизация

//Также пример с удаленным прокси. Это типа VPN. Если я из России не могу зайти на сайт,
// то с помощью прокси можно зайти через другую страну

//Может работать как фильтр, напр логи
public class ProxyApp {
    public static void main(String[] args) {
        Image image = new ProxyImage("D://image.jpg");
        image.display();
    }
}

interface Image{
    void display();
}

class RealImage implements Image {

    String file;

    public RealImage(String file) {
        this.file = file;
        load();
    }

    void load(){
        System.out.println("Load " + file);
    }

    @Override
    public void display() {
        System.out.println("Watch " + file);
    }
}

class ProxyImage implements Image{

    String file;
    RealImage image;
    public ProxyImage(String file) {
        this.file = file;
    }

    @Override
    public void display() {
        if (image == null) {
            image = new RealImage(file);
        }
        image.display();
    }
}
