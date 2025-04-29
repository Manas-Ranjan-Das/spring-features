package lazy;

import java.sql.Time;
import java.time.LocalDateTime;

public class LazyBean {
    String desc;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        System.out.println(LocalDateTime.now());
        System.out.println(desc);
        this.desc = desc;
    }

}
