package com.example.myapplication.Rotations;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class SwipeRotationsAdapter extends FragmentStatePagerAdapter {

    public SwipeRotationsAdapter(FragmentManager fm){super (fm);}

    @Override
    public Fragment getItem(int position) {
        Fragment rotationsFragment=new FragmentRotation();
        Bundle bundle=new Bundle();
        bundle.putInt("Heure",position+1);
        rotationsFragment.setArguments(bundle);

        return rotationsFragment;
    }

    @Override
    public int getCount() {
        return 10;
    }
}
