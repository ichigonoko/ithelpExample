package nothing.ichigo.example.ithelp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Q1_ListViewCount extends Activity implements AdapterView.OnItemClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.q1_listview);
        list_A = findViewById(R.id.list_A);
        list_B = findViewById(R.id.list_B);
        list_C = findViewById(R.id.list_C);
        for(int i = 0 ; i < 10 ; i ++){
            array_A.add(i +"A");
            array_B.add(i +"B");
        }
        list_A.setAdapter(Creat_adapter(array_A));
        list_A.setOnItemClickListener(this);
        list_B.setAdapter(Creat_adapter(array_B));
        list_B.setOnItemClickListener(this);
        adapter_C = Creat_adapter(array_C);
        list_C.setAdapter(adapter_C);
    }

    private ArrayAdapter<String> Creat_adapter(List list){
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter(this,R.layout.q1_listviewitem,R.id.tv_q1_list_item,list);
        return arrayAdapter;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        TextView tv = view.findViewById(R.id.tv_q1_list_item);
        array_C.add(tv.getText().toString());
        adapter_C.notifyDataSetChanged();
    }

    ArrayAdapter adapter_C;
    List array_A = new ArrayList();
    List array_B = new ArrayList();
    List array_C = new ArrayList();
    ListView list_A;
    ListView list_B;
    ListView list_C;
}
