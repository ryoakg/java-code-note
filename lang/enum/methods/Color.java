enum Color{
    BLACK,
    WHITE;

    @Override
    public String toString(){
        return String.format("<%s(%d)>", this.name(), this.ordinal());
    }

    // 面倒なので main を中に入れている
    public static void main(String... args){
        for (Color c : Color.values())
            System.out.printf("%s: %d, %s\n", c.name(), c.ordinal(), c.toString());
    }
}
