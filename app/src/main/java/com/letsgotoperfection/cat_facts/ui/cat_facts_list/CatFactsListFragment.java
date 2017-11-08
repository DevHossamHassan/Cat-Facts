package com.letsgotoperfection.cat_facts.ui.cat_facts_list;

import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.letsgotoperfection.cat_facts.R;
import com.letsgotoperfection.cat_facts.listeners.OnSeekBarProgressChanged;
import com.letsgotoperfection.cat_facts.ui.base.BaseFragment;
import com.xw.repo.BubbleSeekBar;

import butterknife.BindView;

/**
 * @author hossam.
 */

public class CatFactsListFragment extends BaseFragment<CatFactsListContract.Presenter>
        implements CatFactsListContract.View {
    @BindView(R.id.recyclerViewCatFacts)
    RecyclerView recyclerViewCatFacts;
    @BindView(R.id.bubbleSeekBar)
    BubbleSeekBar bubbleSeekBar;
    BubbleSeekBar.OnProgressChangedListener progressChangedListener =
            new OnSeekBarProgressChanged() {
                @Override
                public void getProgressOnActionUp(
                        BubbleSeekBar bubbleSeekBar, int progress, float progressFloat) {
                    Toast.makeText(getViewContext().getActivity(), "The Selected Length is = " +
                            Math.round(progress), Toast.LENGTH_LONG).show();
                }
            };

    @Override
    protected int getFragmentLayoutResourceId() {
        return R.layout.fragment_cat_facts;
    }

    @Override
    protected int getFragmentTitleResourceId() {
        return R.string.app_name;
    }

    @Override
    protected void init() {
        bubbleSeekBar.setOnProgressChangedListener(progressChangedListener);
    }

    @Override
    public void ShowProgressBar() {

    }

    @Override
    public void HideProgressBar() {

    }
}
