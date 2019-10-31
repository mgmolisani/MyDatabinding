package com.example.android.databinding.basicsample.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.example.android.databinding.basicsample.R;
import com.example.android.databinding.basicsample.data.SimpleViewModel;
import com.example.android.databinding.basicsample.databinding.PlainActivityBinding;

public class PlainOldActivity
        extends AppCompatActivity {
    private SimpleViewModel viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        PlainActivityBinding binding = DataBindingUtil.setContentView(this,
                                                                      R.layout.plain_activity);

        this.viewModel = ViewModelProviders.of(this)
                                           .get(SimpleViewModel.class);
        binding.setViewmodel(this.viewModel);
        binding.setLifecycleOwner(this);
    }
}
