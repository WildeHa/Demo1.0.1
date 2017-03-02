package osshao.demo101;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;


public class MainActivity extends AppCompatActivity implements Observer, View.OnClickListener {

//    GlobalVariable globalVariable;
//    Button button;
//    TextView textView;

    private Button buttonEvent1;
    private Button buttonEvent2;
    private Button buttonEvent3;

    private EditText editText;

    private ItemAdapter adapter;
    private ListView listView;
    private ArrayList<EventElement> list;

    private EventElement eventElement;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        globalVariable = (GlobalVariable) getApplication();
//        globalVariable.getObserver().addObserver(this);
//        button = (Button) findViewById(R.id.button);
//        button.setText("Value" + globalVariable.getObserver().getValue());
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                globalVariable.getObserver().setValue("100000");
//            }
//        });
//
//        textView = (TextView) findViewById(R.id.textView);

        buttonEvent1 = (Button) findViewById(R.id.button_event1);
        buttonEvent2 = (Button) findViewById(R.id.button_event2);
        buttonEvent3 = (Button) findViewById(R.id.button_event3);

        buttonEvent1.setOnClickListener(this);
        buttonEvent2.setOnClickListener(this);
        buttonEvent3.setOnClickListener(this);

        editText = (EditText) findViewById(R.id.editText);


        list = new ArrayList<>();
        adapter = new ItemAdapter(list, MainActivity.this);

        listView = (ListView) findViewById(R.id.list_item);

        eventElement = new EventElement();

        eventElement.setTitle("ABC");
        eventElement.setContent("abc");

        list.add(eventElement);

        listView.setAdapter(adapter);

        EventBus.getDefault().register(this);
        startService(new Intent(this, UpdateService.class));

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onFirstEventReceived(FirstEvent firstEvent) {


        eventElement.setTitle(firstEvent.getTitle());
        eventElement.setContent(firstEvent.getContent());

        list.add(eventElement);

        adapter.notifyDataSetChanged();
    }


    @Override
    protected void onStart() {
        super.onStart();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                list.remove(position);
                adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


    @Override
    public void update(Observable o, Object arg) {
//        textView.setText("" +
//                globalVariable.getObserver().getValue());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.button_event1:
//                onFirstEventReceived(new FirstEvent("" + 0));
//                int count = 0;
//                do {
//
//                    Log.v("MainActivity", "Sending Event" + count);
//                    EventBus.getDefault().post(new FirstEvent("" + count));
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    count++;
//
//                } while (count < 20);

//                EventElement eventElement = new EventElement();
//                eventElement.setTitle("123");
//                eventElement.setContent("456");
//                list.add(eventElement);
//                adapter.notifyDataSetChanged();
            case R.id.button_event2:

                break;

            case R.id.button_event3:

                break;
        }
    }


}
