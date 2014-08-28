package com.campusclipper.android;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class ViewCouponActivity extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Toast.makeText(getActivity(), "onCreate of ViewCouponActivity is called!!", Toast.LENGTH_LONG).show();
		View rootView = inflater.inflate(R.layout.fragment_view_coupon, container, false);
		

		Button mButtonUpTown = (Button) rootView.findViewById(R.id.buttonUpTown);
		mButtonUpTown.setOnClickListener(new CategoryListener(getFragmentManager()));
		
		Button mButtonMidTown = (Button) rootView.findViewById(R.id.buttonMidTown);
		mButtonMidTown.setOnClickListener(new CategoryListener(getFragmentManager()));
		
		Button mButtonDownTown = (Button) rootView.findViewById(R.id.buttonDownTown);
		mButtonDownTown.setOnClickListener(new CategoryListener(getFragmentManager()));
		
		
		return rootView;
	}	
	
	
	private class CategoryListener implements OnClickListener {

		FragmentManager mg;
		
		public CategoryListener(FragmentManager mg) {
			this.mg = mg;
		}
		
		@Override
		public void onClick(View v) {
			
			
			// Toast.makeText(getActivity(),
			// "All Button is clicked!!",
			// Toast.LENGTH_LONG).show();
			FragmentTransaction trans = mg.beginTransaction();
			/*
			 * IMPORTANT: We use the "root frame" defined in "root_fragment.xml"
			 * as the reference to replace fragment
			 */
			trans.replace(R.id.root_frame, new CouponDetail());

			/*
			 * IMPORTANT: The following lines allow us to add the fragment to
			 * the stack and return to it later, by pressing back
			 */
			trans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
			trans.addToBackStack(null);
			trans.commit();
		}

	}


	
}
