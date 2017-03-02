package osshao.demo101;

import android.app.Application;

import java.util.Observable;

/**
 * Created by LSCM on 1/3/2017.
 */

public class GlobalVariable extends Application {

    Test test;

    @Override
    public void onCreate() {
        super.onCreate();
        test = new Test();
    }

    Test getObserver() {
        return test;
    }
}

class Test extends Observable {

    private String name = "Test the text";

    public String getValue() {

        return name;

    }

    void setValue(String name) {

        this.name = name;
        setChanged();
        notifyObservers();

    }
}
