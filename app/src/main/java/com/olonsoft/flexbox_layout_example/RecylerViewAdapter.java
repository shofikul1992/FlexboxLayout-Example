package com.olonsoft.flexbox_layout_example;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
public class RecylerViewAdapter extends  RecyclerView.Adapter<ViewHolder> {

        private List<Models> itemDtoList;

    public RecylerViewAdapter(List<Models> itemDtoList) {
            this.itemDtoList = itemDtoList;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_flxbox, parent, false);

            final TextView textItem = (TextView)itemView.findViewById(R.id.flex_box_recycler_view_text_item);
            textItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(), "You click text : " + textItem.getText(), Toast.LENGTH_SHORT).show();
                }
            });

            ViewHolder ret = new ViewHolder(itemView);
            return ret;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {

            Models itemDto = itemDtoList.get(position);
            // Set item image resource id.
            // holder.getImageItem().setImageResource(itemDto.getImageId());
            // Set item text.
            holder.getTextItem().setText(itemDto.getText());
        }

        @Override
        public int getItemCount() {
            int ret = 0;
            if(this.itemDtoList!=null)
            {
                ret = itemDtoList.size();
            }
            return ret;
        }
    }


 class ViewHolder extends RecyclerView.ViewHolder {

    private TextView textItem;

    public ViewHolder(View itemView) {
        super(itemView);
        if(itemView!=null) {
            textItem = itemView.findViewById(R.id.flex_box_recycler_view_text_item);
        }
    }

    public TextView getTextItem() {
        return textItem;
    }
}


