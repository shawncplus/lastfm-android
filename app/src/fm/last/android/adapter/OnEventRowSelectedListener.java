package fm.last.android.adapter;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import fm.last.android.OnListRowSelectedListener;
import fm.last.android.R;

/**
 * Highlighting of EventListSectionAdapter
 * 
 * @author Lukasz Wisniewski
 */
public class OnEventRowSelectedListener extends OnListRowSelectedListener {

	public OnEventRowSelectedListener(ListView listView) {
		super(listView);
	}

	@Override
	public void onItemSelected(AdapterView<?> adapter, View view, int position,
			long id) {
		if(mPreviousSelectedView != null) {
			mPreviousSelectedView.setBackgroundResource(mRestResource);
			((TextView)mPreviousSelectedView.findViewById(R.id.ExtendedRowBiggerText)).setTextColor(0xFF333333);
			((TextView)mPreviousSelectedView.findViewById(R.id.ExtendedRowSmallerText0)).setTextColor(0xFF666666);
			((TextView)mPreviousSelectedView.findViewById(R.id.ExtendedRowSmallerText1)).setTextColor(0xFF666666);		
		}
		
		if(position >= 0 && mListView.isFocused() && mListView.getAdapter().isEnabled(position) 
				&& view != null) {
			view.setBackgroundResource(mHighlightResource);
			((TextView)view.findViewById(R.id.ExtendedRowBiggerText)).setTextColor(0xFFFFFFFF);
			((TextView)view.findViewById(R.id.ExtendedRowSmallerText0)).setTextColor(0xFFFFFFFF);
			((TextView)view.findViewById(R.id.ExtendedRowSmallerText1)).setTextColor(0xFFFFFFFF);
			mPreviousSelectedView = view;
		}
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		if(mPreviousSelectedView != null) {
			mPreviousSelectedView.setBackgroundResource(mRestResource);
			((TextView)mPreviousSelectedView.findViewById(R.id.ExtendedRowBiggerText)).setTextColor(0xFF333333);
			((TextView)mPreviousSelectedView.findViewById(R.id.ExtendedRowSmallerText0)).setTextColor(0xFF666666);
			((TextView)mPreviousSelectedView.findViewById(R.id.ExtendedRowSmallerText1)).setTextColor(0xFF666666);
		}
		mPreviousSelectedView = null;
	}

}