package lazy;

import java.time.LocalDateTime;

public class NotLazyBean {
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
