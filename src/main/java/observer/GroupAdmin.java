package observer;

import java.util.ArrayList;
import java.util.List;

public class GroupAdmin implements Sender {


    private UndoableStringBuilder stringBuilder = new UndoableStringBuilder();
    private String name;
    private List<ConcreteMember> members = new ArrayList();

    public GroupAdmin(String name, String s){
        this.name = name;
        this.stringBuilder =new UndoableStringBuilder(s);
    }

    @Override
    public void register(Member obj) {
        members.add((ConcreteMember) obj);
    }

    @Override
    public void unregister(Member obj) {
        members.remove(obj);
    }

    @Override
    public void insert(int offset, String obj) {
        stringBuilder.insert(offset, obj);
        notifyMembers();
    }

    @Override
    public void append(String obj) {
        stringBuilder.append(obj);
        notifyMembers();
    }

    @Override
    public void delete(int start, int end) {
        stringBuilder.delete(start,end);
        notifyMembers();

    }

    @Override
    public void undo() {
        stringBuilder.undo();
        notifyMembers();

    }
    public UndoableStringBuilder getStringBuilder() {
        return stringBuilder;
    }

    public void setStringBuilder(UndoableStringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
        notifyMembers();
    }


    public void notifyMembers(){
        for (ConcreteMember member: members){
            member.update(stringBuilder);
        }
    }
}
