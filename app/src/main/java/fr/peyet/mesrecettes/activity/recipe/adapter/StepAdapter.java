package fr.peyet.mesrecettes.activity.recipe.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import fr.peyet.mesrecettes.R;

import java.util.ArrayList;
import java.util.List;

public class StepAdapter extends BaseAdapter {

    private final List<String> steps;
    private final LayoutInflater inflater;

    public StepAdapter(LayoutInflater inflater, List<String> steps) {
        if (steps == null) {
            steps = new ArrayList<>();
        }

        this.steps = steps;
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return this.steps.size();
    }

    @Override
    public String getItem(int position) {
        return this.steps.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vue;

        // Si la vue est recyclée, elle contient déjà le bon layout
        if (convertView != null) {
            // On n'a plus qu'à la récupérer
            vue = convertView;
        } else {
            // Sinon, il faut en effet utiliser le LayoutInflater
            vue = this.inflater.inflate(R.layout.step, null);
        }

        TextView index = vue.findViewById(R.id.step_index);
        index.setText(String.valueOf(position + 1));

        TextView content = vue.findViewById(R.id.step_content);
        content.setText(this.getItem(position));

        return vue;
    }

}
