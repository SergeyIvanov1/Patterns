package Decorator;
//структурный шаблон проектирования, предназначенный для динамического подключения
// дополнительного поведения к объекту. Шаблон Декоратор предоставляет
// хорошую и гибкую альтернативу практике создания подклассов с целью расширения функциональности.

public class DecoratorApp {
    public static void main(String[] args) {
//        PrinterInterface printer = new Printer("Hello"); //Output: Hello
//        PrinterInterface printer = new QuotesDecorator(new Printer("Hello")); //Output: "Hello"
//        PrinterInterface printer = new LeftBracketDecorator(new Printer("Hello")); //Output: [Hello
//        PrinterInterface printer = new RightBracketDecorator(new Printer("Hello")); //Output: Hello]
//        PrinterInterface printer = new LeftBracketDecorator(new RightBracketDecorator(new Printer("Hello"))); //Output: [Hello]

        PrinterInterface printer = new QuotesDecorator(new LeftBracketDecorator(new RightBracketDecorator(new Printer("Hello")))); //Output: "[Hello]"
        //QuotesDecorator печатает левую кавычку, вызывает - (new LeftBracketDecorator).print()
        //LeftBracketDecorator печатает левую скобку, вызывает - (new RightBracketDecorator).print()
        //RightBracketDecorator вызывает Printer.print()
        //Printer печатает - Hello
        //RightBracketDecorator завершает метод и печатает правую скобку
        //QuotesDecorator завершает метод и печатает правую кавычку

        printer.print();
    }
}

interface PrinterInterface {
    void print();
}

class Printer implements PrinterInterface {
    String value;
    public Printer(String value) {this.value = value;}

    @Override
    public void print() {System.out.print(value);}
}
// если декоратор один, то писать абстрактный класс не имеет смысла
abstract class Decorator implements PrinterInterface {
    PrinterInterface component;
    public Decorator(PrinterInterface component) {this.component = component;}
}
//далее реализация трех декораторов
class QuotesDecorator extends Decorator {
    public QuotesDecorator(PrinterInterface component) {super(component);}

    @Override
    public void print() {
        System.out.print("\"");
        component.print();
        System.out.print("\"");
    }
}

class LeftBracketDecorator extends Decorator {
    public LeftBracketDecorator(PrinterInterface component) {super(component);}

    @Override
    public void print() {
        System.out.print("[");
        component.print();
    }
}

class RightBracketDecorator extends Decorator {
    public RightBracketDecorator(PrinterInterface component) {super(component);}

    @Override
    public void print() {
        component.print();
        System.out.print("]");
    }
}