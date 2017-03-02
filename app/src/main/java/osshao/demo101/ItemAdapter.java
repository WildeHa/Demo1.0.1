package osshao.demo101;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by LSCM on 2/3/2017.
 */

public class ItemAdapter extends BaseAdapter {

    private List<EventElement> list;
    private LayoutInflater inflater;

    Context context;

    public ItemAdapter(List<EventElement> data, Context context) {

        list = data;

        inflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {

            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.element_layout, null);
            viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.tv_title);
            viewHolder.tvContent = (TextView) convertView.findViewById(R.id.tv_content);

            convertView.setTag(viewHolder);

        } else {

            viewHolder = (ViewHolder) convertView.getTag();

        }

        viewHolder.tvTitle.setText(list.get(position).getTitle());
        viewHolder.tvContent.setText(list.get(position).getContent());

        return convertView;

    }

    class ViewHolder {
        TextView tvTitle, tvContent;
    }
}
