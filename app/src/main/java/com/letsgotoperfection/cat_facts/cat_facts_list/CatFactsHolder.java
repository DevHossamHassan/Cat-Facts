package com.letsgotoperfection.cat_facts.cat_facts_list;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.letsgotoperfection.cat_facts.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author hossam.
 */

public class CatFactsHolder extends RecyclerView.ViewHolder implements
        CatFactsListContract.RowView {

    @BindView(R.id.tvCatFactIndex)
    TextView tvCatFactIndex;
    @BindView(R.id.tvCatFactLength)
    TextView tvCatFactLength;
    @BindView(R.id.tvCatFactText)
    TextView tvCatFactText;
    @BindView(R.id.imgButtonShare)
    ImageButton imageButtonShare;

    public CatFactsHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void setCatFactText(String catFactText) {
        tvCatFactText.setText(catFactText);
    }

    @Override
    public void setCatFactLength(int catFactLength) {
        String string = String.valueOf(catFactLength);
        tvCatFactLength.setText(string);
    }

    @Override
    public void setCatFactIndex(int catFactIndex) {
        String string = String.valueOf(catFactIndex);
        tvCatFactIndex.setText(string);
    }
}