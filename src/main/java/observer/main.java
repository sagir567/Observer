package observer;

public class main {





    public static void main (String [] args){


        GroupAdmin math = new GroupAdmin("math", "wellcom to out new class");
        ConcreteMember dani = new ConcreteMember(math,"dani");
        ConcreteMember amit = new ConcreteMember(math,"amit");
        ConcreteMember guy = new ConcreteMember(math,"guy");

        math.setStringBuilder(new UndoableStringBuilder("first hello") );
        math.append( "\nhello again ");
        math.insert(3, "shittttt");



    }
}
