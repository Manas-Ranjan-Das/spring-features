package others;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class ClassWithCollections {
    Properties adminEmails;
    List<String> someList;
    Map<String,String> someMap;
    Set<String> someSet;

    public void setAdminEmails(Properties adminEmails) {
        this.adminEmails = adminEmails;
    }

    public void setSomeList(List<String> someList) {
        this.someList = someList;
    }

    public void setSomeMap(Map<String, String> someMap) {
        this.someMap = someMap;
    }

    public void setSomeSet(Set<String> someSet) {
        this.someSet = someSet;
    }

    public Properties getAdminEmails() {
        return adminEmails;
    }

    public List<String> getSomeList() {
        return someList;
    }

    public Map<String, String> getSomeMap() {
        return someMap;
    }

    public Set<String> getSomeSet() {
        return someSet;
    }

    @Override
    public String toString(){
        return adminEmails.toString() +"\n" 
            + someList.toString() +"\n" 
            + someMap.toString() +"\n"
            + someSet.toString();
    }
}
