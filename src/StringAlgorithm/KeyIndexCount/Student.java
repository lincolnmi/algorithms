package StringAlgorithm.KeyIndexCount;

/**
 * Created by Jason on 2016/4/24.
 */
public class Student {
    private String name;
    private int group;

    public Student(String name,int group) {
        setName(name);
        setGroup(group);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public int getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return name+" "+group;
    }
}
