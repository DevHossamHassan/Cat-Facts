package com.letsgotoperfection.cat_facts.cat_facts_list;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.letsgotoperfection.cat_facts.R;
import com.letsgotoperfection.cat_facts.base.BaseFragment;
import com.letsgotoperfection.cat_facts.data.AppCatFactsDao;
import com.letsgotoperfection.cat_facts.data.CatFactsBo;
import com.letsgotoperfection.cat_facts.listeners.OnRecyclerViewScrollToTheEnd;
import com.letsgotoperfection.cat_facts.listeners.OnSeekBarProgressChanged;
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
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;
    CatFactsAdapter catFactsAdapter;
    BubbleSeekBar.OnProgressChangedListener progressChangedListener =
            new OnSeekBarProgressChanged() {
                @Override
                public void getProgressOnActionUp(
                        BubbleSeekBar bubbleSeekBar, int progress, float progressFloat) {
                    presenter.onLengthChanged(Math.round(progress));
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
        presenter = new CatFactsListPresenter(this, new CatFactsBo(
                new AppCatFactsDao()));

        bubbleSeekBar.setOnProgressChangedListener(progressChangedListener);
        swipeRefreshLayout.setEnabled(false);

        catFactsAdapter = new CatFactsAdapter((CatFactsListPresenter) presenter);
        prepareRecyclerView();
    }

    private void prepareRecyclerView() {
        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerViewCatFacts.setHasFixedSize(true);
        recyclerViewCatFacts.setItemAnimator(new DefaultItemAnimator());
        recyclerViewCatFacts.setLayoutManager(linearLayoutManager);
        recyclerViewCatFacts.setAdapter(catFactsAdapter);

        recyclerViewCatFacts.addOnScrollListener(
                new OnRecyclerViewScrollToTheEnd(linearLayoutManager) {
                    @Override
                    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                        super.onScrolled(recyclerView, dx, dy);
                        if (linearLayoutManager.findLastCompletelyVisibleItemPosition() ==
                                catFactsAdapter.getItemCount() - 1) {
                            presenter.onLoadMoreTriggered(bubbleSeekBar.getProgress());

                        }
                    }
                });
    }


    @Override
    public void ShowProgressBar() {
        swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void HideProgressBar() {
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void notifyDataSetChanged() {
        catFactsAdapter.notifyDataSetChanged();
    }

    @Override
    public void notifyDataSetInserted(int totalItems, int i) {
        catFactsAdapter.notifyItemRangeInserted(totalItems, i);
    }
}
