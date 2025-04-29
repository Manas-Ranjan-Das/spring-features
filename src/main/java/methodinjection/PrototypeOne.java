package methodinjection;


public class PrototypeOne {
    public int index;
    static int count = 0;

    public PrototypeOne() {
        super();
        count++;
        index = count;
    }
}
