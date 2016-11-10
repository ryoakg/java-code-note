// この InstanceCounter と Countee の関係のまま
// extends する感じの事は出来ないかな? と思ったけど無理っぽい気がした
class InstanceCounter {
    private int count;
    int get() { return count; }
    void incr(){ count++; }
    void decr(){ count--; }

    class Countee {
        Countee(){
            incr();
        }

        protected void finalize() {
            decr();
        }
    }
}


class Foo extends InstanceCounter {
    public class Bar {
        int a;
        Bar(){
            a = 10;
        }
    }
}


class Main{
    public static void main(String... args){
        Foo f = new Foo();
        f.new Bar();
    }
}
