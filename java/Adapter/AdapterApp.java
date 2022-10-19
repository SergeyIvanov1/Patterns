package Adapter;

//адаптер — это паттерн проектирования,
// который позволяет объектам с несовместимыми интерфейсами работать вместе.
//СОЗДАЕТ КЛАСС-ОБОЛОЧКУ С ТРЕБУЕМЫМ ИНТЕРФЕЙСОМ

//Обращаемся к VectorGraphicsInterface, реализованному в VectorAdapterFromRaster,
//который перенаправляет обращение к RasterGraphics
public class AdapterApp {
    public static void main(String[] args) {

//можно реализовать двумя способами:
//1. Через наследование
        VectorGraphicsInterface g1 = new VectorAdapterFromRaster();
        g1.drawLine();
        g1.drawSquare();

//2. Через композицию
        VectorGraphicsInterface g2 = new VectorAdapterFromRaster2();
        g2.drawLine();
        g2.drawSquare();
    }
}

interface VectorGraphicsInterface {
    void drawLine();
    void drawSquare();
}

//есть класс, который умеет рисовать линию и квадрат,
//но клиент говорит, что нужно раюботать с VectorGraphicsInterface
//НО у них разные сигнатуры методов. Выходом станет создание адаптера
class RasterGraphics {
    void drawRasterLine() {
        System.out.println("Рисуем линию");
    }

    void drawRasterSquare() {
        System.out.println("Рисуем квадрат");
    }
}

//Адаптер1. Реализация через наследование
//реализуем методы интерфейса путем вызова методов родителя
class VectorAdapterFromRaster extends RasterGraphics implements VectorGraphicsInterface {

    @Override
    public void drawLine() {
        drawRasterLine();
    }

    @Override
    public void drawSquare() {
        drawRasterSquare();
    }
}

//Адаптер2. Реализация через композицию. Здесь вместо extends получаем зависимость
//реализуем методы интерфейса путем вызова методов зависимости.
class VectorAdapterFromRaster2 implements VectorGraphicsInterface {
    RasterGraphics raster = new RasterGraphics();

    @Override
    public void drawLine() {
        raster.drawRasterLine();
    }

    @Override
    public void drawSquare() {
        raster.drawRasterSquare();
    }
    // Также зависимость можно передать через конструктор VectorAdapterFromRaster2

}
