package com.example.recyclerviewexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VillagerAdapter extends RecyclerView.Adapter<VillagerAdapter.ViewHolder> {
    //create the basic adapter extending from RecyclerView.Adapter
    //create an inner/helper class that specify the custom ViewHolder,
    //which gives us access to our views

    //you have a list of data to be populated
    //store an instance variable for the list of data to be populated
    private List<Villager> villagers;

    //pass this list into the constructor of the adapter
    public VillagerAdapter(List<Villager> villagers){
        this.villagers = villagers;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //involves inflate a layout from xml and return the ViewHolder
        //very standard code/template looking code
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        //inflate the custom layout
        View villagerView = inflater.inflate(R.layout.item_villager, parent, false);
        //return a new ViewHolder
        ViewHolder viewHolder = new ViewHolder(villagerView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //populate data into the item through holder

        //grab the actual data model (aka Villager Object) based on the position
        Villager villager = villagers.get(position);

        //set the view based on the data and the view names
        holder.textView_name.setText(villager.getName());
        holder.textView_birthday.setText(villager.getBirthday());
        holder.textView_phrase.setText(villager.getPhrase());

        //if I have to load in the image, this is where I have to load it in
    }

    @Override
    public int getItemCount() {
        //returns the total number of items in the list
        return villagers.size();
    }

    //provides a direct reference to each of the view within the data item
    //used to cache the view within the item layout for fast access

    class ViewHolder extends RecyclerView.ViewHolder{
        //all the views you want to set as you render the row
        //name, birthday, phrase, villager

        TextView textView_name;
        TextView textView_birthday;
        TextView textView_phrase;

        //we will add the image view later
        //create constructor to set these
        public ViewHolder(View itemView){
            //itemView -> represents the entire view of each row
            super(itemView);
            //look up each view from the custom layout
            textView_name = itemView.findViewById(R.id.textView_name);
            textView_birthday = itemView.findViewById(R.id.textView_birthday);
            textView_phrase = itemView.findViewById(R.id.textView_phrase);
        }
    }

}
