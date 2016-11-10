import java.io.*;

class Main{
    public static void main(String... args){
        try(BufferedReader in = new BufferedReader(new FileReader("/etc/passwd"))){
            in
                .lines()
                .forEach(System.out::println);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
