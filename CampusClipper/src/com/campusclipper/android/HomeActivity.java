package com.campusclipper.android;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class HomeActivity extends Fragment {
	

	Button mButtonAll;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		
		View rootView = inflater.inflate(R.layout.fragment_home, container, false);
		
		mButtonAll = (Button) rootView.findViewById(R.id.button1);
		mButtonAll.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(getActivity(), "Clicked! Yay", Toast.LENGTH_LONG).show();
				Fragment newFragment = new ViewCouponActivity();	
				FragmentTransaction transaction = getFragmentManager().beginTransaction();
				//transaction.replace(R.id.pager, newFragment);
				transaction.replace(((ViewGroup)getView().getParent()).getId(), newFragment);
				transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
				transaction.addToBackStack(null);
				transaction.commit();
				
			}
		});
		return rootView;
	}

}
