package methodinjection;

import org.springframework.beans.factory.annotation.Lookup;

public abstract class SingletonOne {
    public PrototypeOne genNewPrototypeBean(){
        return getPrototypeOne();
    }

    protected abstract PrototypeOne getPrototypeOne ();
}
