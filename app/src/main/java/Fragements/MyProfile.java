package Fragements;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cashifygames.R;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MyProfile  extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragement_my_profile, null);
    }

}
