package observer;

import java.util.ArrayList;
import java.util.List;

public class GroupAdmin implements Sender {


    private UndoableStringBuilder stringBuilder = new UndoableStringBuilder();
    private String name;
    private List<Member> members = new ArrayList();

    public GroupAdmin(String name, String s){
        this.name = name;
        this.stringBuilder =new UndoableStringBuilder(s);
    }

    @Override
    public void register(Member obj) {
        members.add(obj);

    }

    @Override
    public void unregister(Member obj) {
        members.remove(obj);
    }

    @Override
    public void insert(int offset, String obj) {
        stringBuilder.insert(offset, obj);
    }

    @Override
    public void append(String obj) {
        stringBuilder.append(obj);
    }

    @Override
    public void delete(int start, int end) {
        stringBuilder.delete(start,end);

    }

    @Override
    public void undo() {
        stringBuilder.undo();

    }
    public UndoableStringBuilder getStringBuilder() {
        return stringBuilder;
    }

    public void setStringBuilder(UndoableStringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
    }


    public void notifyMembers(){
        for (Member member: members){
            member.update(stringBuilder);
        }
    }
}
