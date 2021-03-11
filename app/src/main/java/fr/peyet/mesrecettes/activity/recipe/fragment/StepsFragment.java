package fr.peyet.mesrecettes.activity.recipe.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.fragment.app.Fragment;
import fr.peyet.mesrecettes.R;
import fr.peyet.mesrecettes.activity.recipe.adapter.StepAdapter;

import java.util.List;

public class StepsFragment extends Fragment {
    private final List<String> steps;

    public StepsFragment(List<String> steps) {
        this.steps = steps;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.step_fragment, container, false);

        ListView steps = view.findViewById(R.id.receipe_steps);
        steps.setAdapter(new StepAdapter(inflater, this.steps));

        return view;
    }

}
