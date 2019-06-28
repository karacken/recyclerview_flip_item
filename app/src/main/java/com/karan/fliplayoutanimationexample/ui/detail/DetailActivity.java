package com.karan.fliplayoutanimationexample.ui.detail;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.karan.fliplayoutanimationexample.R;
import com.karan.fliplayoutanimationexample.data.model.CricketTeam;
import com.karan.fliplayoutanimationexample.utils.AppConstants;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class DetailActivity extends AppCompatActivity implements HasSupportFragmentInjector {
@Inject
DispatchingAndroidInjector<Fragment> fragmentAndroidInjector;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        showDetailFragment();
    }

    private void showDetailFragment() {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.detail_fragment_container, DetailFragment.newInstance(getCricketTeam()));
        fragmentTransaction.commit();
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentAndroidInjector;
    }

    public CricketTeam getCricketTeam() {
        return getIntent().getParcelableExtra(AppConstants.EXTRA.CRICKET_TEAM);
    }
}
