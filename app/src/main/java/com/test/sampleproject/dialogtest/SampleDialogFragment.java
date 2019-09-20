package com.test.sampleproject.dialogtest;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.DialogFragment;

import com.test.sampleproject.R;
import com.test.sampleproject.databinding.DialogSampleBinding;

public class SampleDialogFragment extends DialogFragment {

    private DialogSampleBinding mBinding;
    private String mSetType;
    private SampleListener mListener;

    public static SampleDialogFragment getInstance(String type) {
        SampleDialogFragment fragment = new SampleDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString("type", type);
        fragment.setArguments(bundle);
        return fragment;
    }

    public void setSetType(String setType) {
        mSetType = setType;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.dialog_sample, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof SampleListener){
            mListener = (SampleListener) context;
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String bundleType = getArguments().getString("type");
        mBinding.dialogSampleBundleText.setText(bundleType);
        mBinding.dialogSampleSetText.setText(mSetType);
        mBinding.dialogSampleListener.setOnClickListener(v -> mListener.onClicked());
    }

    public interface SampleListener {

        void onClicked();
    }
}
