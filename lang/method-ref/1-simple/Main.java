public class Main{
    public static void main(String... args){
        Printer printer = Main::printMessage;
        execPrinter(printer, "foo");
        // ↑or↓
        // execPrinter(Main::printMessage, "foo");
    }

    static void execPrinter(Printer printer, String str){
        printer.print(str);
    }

    static void printMessage(String message){
        System.out.println(message);
    }

    @FunctionalInterface
    interface Printer{
        public void print(String msg);
    }
}
