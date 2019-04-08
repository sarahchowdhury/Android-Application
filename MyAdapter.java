package bd.ac.uiu.mcc;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private ArrayList<User> mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView textView1,textView2;
        ImageView imageView;
        public MyViewHolder(TextView v,TextView v1,ImageView i) {
            super(v);
            textView1 = v;
            textView2=v1;
            imageView=i;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(ArrayList<User> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        TextView v = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_view, parent, false);
        TextView v1 = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_view, parent, false);
        ImageView i = (ImageView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_view, parent, false);

        MyViewHolder vh = new MyViewHolder(v,v1,i);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.textView1.setText(mDataset.get(position).name);
        holder.textView2.setText(mDataset.get(position).email);
        holder.imageView.setImageResource(mDataset.get(position).image);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
