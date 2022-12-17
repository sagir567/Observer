package observer;

public class ConcreteMember implements Member{

    UndoableStringBuilder stringBuilder = new UndoableStringBuilder();
    String name ;

    public ConcreteMember(GroupAdmin admin, String name){
        this.name = name;
        this.stringBuilder= admin.getStringBuilder().;
    }

    @Override
    public void update(UndoableStringBuilder usb) {

    }
}
