package observer;

public class ConcreteMember implements Member{

    UndoableStringBuilder stringBuilder = new UndoableStringBuilder();
    String name;
    GroupAdmin admin;



    public ConcreteMember(GroupAdmin admin, String name){
        this.name = name;
        this.stringBuilder= admin.getStringBuilder();
        this.admin = admin;
        admin.register(this);

    }

    @Override
    public void update(UndoableStringBuilder usb) {
        stringBuilder = admin.getStringBuilder();
        System.out.println(name+": new update:"+stringBuilder);

    }
}
