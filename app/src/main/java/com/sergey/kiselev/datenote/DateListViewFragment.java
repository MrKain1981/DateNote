package com.sergey.kiselev.datenote;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.sergey.kiselev.datenote.model.DateNoteElement;
import com.sergey.kiselev.datenote.model.DateNoteList;
import com.sergey.kiselev.datenote.model.DateNoteSeparator;
import com.sergey.kiselev.datenote.model.DateNoteSimple;
import com.sergey.kiselev.datenote.model.ElementType;
import com.sergey.kiselev.datenote.utils.Constants;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class DateListViewFragment extends Fragment {

    private RecyclerView dateNoteRecycler;
    private DateCardAdapter dateCardAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_date_list_view, container, false);

        dateNoteRecycler = root.findViewById(R.id.date_list_recycler);
        dateCardAdapter = new DateCardAdapter(getContext(), DateNoteList.getInstance(getContext()).getAllDateNotes());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        dateNoteRecycler.setLayoutManager(linearLayoutManager);
        dateNoteRecycler.setAdapter(dateCardAdapter);

        return root;
    }

    private class DateCardAdapter extends RecyclerView.Adapter<DateCardViewHolder> {

        Context context;
        List<DateNoteElement> dateNotes;

        public DateCardAdapter(Context context, List<DateNoteElement> dateNotes) {
            this.context = context;
            this.dateNotes = dateNotes;
        }

        @Override
        public int getItemViewType(int position) {
            if (dateNotes.get(position).getElementType() == ElementType.DATE_NOTE) {
                return 0;
            } else {
                return 1;
            }
        }

        @NonNull
        @Override
        public DateCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView;
            if (viewType == 0) {
                itemView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
            } else {
                itemView = LayoutInflater.from(context).inflate(R.layout.list_separator_item, parent, false);
            }

            return new DateCardViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull DateCardViewHolder holder, int position) {
            holder.fillItem(dateNotes.get(holder.getAdapterPosition()));

        }

        @Override
        public int getItemCount() {
            if (dateNotes.isEmpty()) {
                return 0;
            } else {
                return dateNotes.size();
            }
        }
    }

    private static class DateCardViewHolder extends RecyclerView.ViewHolder {

        //private CardView item;
        private TextView title;
        private TextView description;
        private TextView noteDate;
        private TextView dayOfWeek;

        public DateCardViewHolder(View itemView) {
            super(itemView);

            //item = itemView.findViewById(R.id.list_item_card);


//            title = itemView.findViewById(R.id.list_item_title);
//            description = itemView.findViewById(R.id.list_item_description);
//            noteDate = itemView.findViewById(R.id.list_item_note_date);
//            dayOfWeek = itemView.findViewById(R.id.list_item_day_of_week);

        }

        private void fillDateNoteSimple(DateNoteSimple dn) {
            title = itemView.findViewById(R.id.list_item_title);
            description = itemView.findViewById(R.id.list_item_description);
            noteDate = itemView.findViewById(R.id.list_item_note_date);
            dayOfWeek = itemView.findViewById(R.id.list_item_day_of_week);

            Date dt = dn.getDate();
            Calendar c = Calendar.getInstance();

            title.setText(dn.getTitle());
            description.setText(dn.getDescription());
            noteDate.setText(new SimpleDateFormat(Constants.DATE_PATTERN, Locale.ROOT).format(dt));

            c.setTime(dt);
            int dayWeek = c.get(c.DAY_OF_WEEK);
            if (c.getFirstDayOfWeek() == c.MONDAY) {
                switch (dayWeek) {
                    case 1: {
                        dayOfWeek.setText(R.string.monday_short);
                        break;
                    }
                    case 2: {
                        dayOfWeek.setText(R.string.tuesday_short);
                        break;
                    }
                    case 3: {
                        dayOfWeek.setText(R.string.wednesday_short);
                        break;
                    }
                    case 4: {
                        dayOfWeek.setText(R.string.thursday_short);
                        break;
                    }
                    case 5: {
                        dayOfWeek.setText(R.string.friday_short);
                        break;
                    }
                    case 6: {
                        dayOfWeek.setText(R.string.saturday_short);
                        break;
                    }
                    case 7: {
                        dayOfWeek.setText(R.string.sunday_short);
                        break;
                    }
                }
            } else {
                switch (dayWeek) {
                    case 1: {
                        dayOfWeek.setText(R.string.sunday_short);
                        break;
                    }
                    case 2: {
                        dayOfWeek.setText(R.string.monday_short);
                        break;
                    }
                    case 3: {
                        dayOfWeek.setText(R.string.tuesday_short);
                        break;
                    }
                    case 4: {
                        dayOfWeek.setText(R.string.wednesday_short);
                        break;
                    }
                    case 5: {
                        dayOfWeek.setText(R.string.thursday_short);
                        break;
                    }
                    case 6: {
                        dayOfWeek.setText(R.string.friday_short);
                        break;
                    }
                    case 7: {
                        dayOfWeek.setText(R.string.saturday_short);
                        break;
                    }
                }
            }

        }

        private void fillSeparator(DateNoteSeparator dateNote) {
            title = itemView.findViewById(R.id.list_item_separator_title);
            title.setText(dateNote.getTitle());
        }

        public void fillItem(DateNoteElement dateNote) {
            if (dateNote.getElementType() == ElementType.DATE_NOTE) {
                fillDateNoteSimple((DateNoteSimple) dateNote);
            }
            else {
                fillSeparator((DateNoteSeparator) dateNote);
            }

        }
    }

}
