package com.letsgotoperfection.cat_facts.catfacts;

import com.letsgotoperfection.cat_facts.data.CatFactsBo;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.observers.TestObserver;

import static io.reactivex.Single.just;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author hossam.
 */

public class CatFactsListPresenterTest {
    @Mock
    private CatFactsListPresenter catFactsListPresenter;
    @Mock
    private CatFactsBo catFactsBo;
    @Mock
    private CatFactsHolder catFactsHolder;
    @Mock
    private CatFactsListContract.View catFactsListContractView;

    @Before
    public void setUpCatFactsListPresenter() {
        // Mockito has a very convenient way to inject mocks by using the @Mock annotation. To
        // inject the mocks in the test the initMocks method needs to be called.
        MockitoAnnotations.initMocks(this);

        // Get a reference to the class under test
        catFactsListPresenter = new CatFactsListPresenter(catFactsListContractView, catFactsBo);

    }

    @Test
    public void onLengthChanged_fetchCatFacts_ReturnsCorrectResult() {
        CatFactsResponse catFactsResponse = provideFakeCatFactsResponse();

        when(catFactsBo.fetchCatFacts(anyInt(), anyInt())).thenReturn(
                just(catFactsResponse)
        );

        catFactsListPresenter.onLengthChanged(50);

        TestObserver<CatFactsResponse> testObserver1 = catFactsBo.fetchCatFacts(50, 1).test();
        testObserver1.assertNoErrors()
                .assertValue(l -> l.getData().size() == 1);

    }

    private CatFactsResponse provideFakeCatFactsResponse() {
        CatFactsResponse catFactsResponse = new CatFactsResponse();


        catFactsResponse.setData(provideFakeCatFactsList());
        return catFactsResponse;
    }

    private List<CatFact> provideFakeCatFactsList() {
        List<CatFact> catFactList = new ArrayList<>();
        catFactList.add(new CatFact("Some Fact", 10));
        return catFactList;
    }

    @Test
    public void onLengthChanged_invokes_notifyDataSetChanged() {
        CatFactsResponse catFactsResponse = provideFakeCatFactsResponse();
        when(catFactsBo.fetchCatFacts(anyInt(), anyInt())).thenReturn(
                just(catFactsResponse)
        );

        catFactsListPresenter.onLengthChanged(50);
        verify(catFactsListContractView).notifyDataSetChanged();
    }


    @Test
    public void onLengthChanged_invokes_HideProgressBar() {
        CatFactsResponse catFactsResponse = provideFakeCatFactsResponse();
        when(catFactsBo.fetchCatFacts(anyInt(), anyInt())).thenReturn(
                just(catFactsResponse)
        );

        catFactsListPresenter.onLengthChanged(50);
        verify(catFactsListContractView).hideProgressBar();
    }

    @Test
    public void onLengthChanged_invokes_ShowProgressBar() {
        CatFactsResponse catFactsResponse = provideFakeCatFactsResponse();
        when(catFactsBo.fetchCatFacts(anyInt(), anyInt())).thenReturn(
                just(catFactsResponse)
        );

        catFactsListPresenter.onLengthChanged(50);
        verify(catFactsListContractView).showProgressBar();
    }

    @Test
    public void onLoadMoreTriggered_invokes_ShowProgressBar() {
        CatFactsResponse catFactsResponse = provideFakeCatFactsResponse();
        when(catFactsBo.fetchCatFacts(anyInt(), anyInt())).thenReturn(
                just(catFactsResponse)
        );

        catFactsListPresenter.onLoadMoreTriggered(50);
        verify(catFactsListContractView).showProgressBar();
    }


    @Test
    public void onLoadMoreTriggered_invokes_HideProgressBar() {
        CatFactsResponse catFactsResponse = provideFakeCatFactsResponse();
        when(catFactsBo.fetchCatFacts(anyInt(), anyInt())).thenReturn(
                just(catFactsResponse)
        );

        catFactsListPresenter.onLoadMoreTriggered(50);
        verify(catFactsListContractView).showProgressBar();
    }

    @Test
    public void onLoadMoreTriggered_invokes_notifyDataSetInserted() {
        CatFactsResponse catFactsResponse = provideFakeCatFactsResponse();
        when(catFactsBo.fetchCatFacts(anyInt(), anyInt())).thenReturn(
                just(catFactsResponse)
        );
        catFactsListPresenter.onLengthChanged(50);

        catFactsListPresenter.onLoadMoreTriggered(50);
        verify(catFactsListContractView).notifyDataSetInserted(1, 2);
    }


    @Test
    public void shareText_invokes_shareText() {
        CatFactsResponse catFactsResponse = provideFakeCatFactsResponse();
        when(catFactsBo.fetchCatFacts(anyInt(), anyInt())).thenReturn(
                just(catFactsResponse)
        );
        catFactsListPresenter.onLengthChanged(50);

        catFactsListPresenter.shareText(0);
        verify(catFactsListContractView).shareText("Some Fact");
    }


    @Test
    public void onBindCatFactViewItemAtPosition_invokes_holderSetCatFactIndex() {
        CatFactsResponse catFactsResponse = provideFakeCatFactsResponse();
        when(catFactsBo.fetchCatFacts(anyInt(), anyInt())).thenReturn(
                just(catFactsResponse)
        );
        catFactsListPresenter.onLengthChanged(50);

        catFactsListPresenter.onBindCatFactViewItemAtPosition(0, catFactsHolder);
        verify(catFactsHolder).setCatFactIndex(0);
    }

    @Test
    public void onBindCatFactViewItemAtPosition_invokes_holderSetCatFactLength() {
        CatFactsResponse catFactsResponse = provideFakeCatFactsResponse();
        when(catFactsBo.fetchCatFacts(anyInt(), anyInt())).thenReturn(
                just(catFactsResponse)
        );
        catFactsListPresenter.onLengthChanged(50);

        catFactsListPresenter.onBindCatFactViewItemAtPosition(0, catFactsHolder);
        verify(catFactsHolder).setCatFactLength(10);
        verify(catFactsHolder).setCatFactText("Some Fact");
    }

    @Test
    public void onBindCatFactViewItemAtPosition_invokes_holderSetCatFactText() {
        CatFactsResponse catFactsResponse = provideFakeCatFactsResponse();
        when(catFactsBo.fetchCatFacts(anyInt(), anyInt())).thenReturn(
                just(catFactsResponse)
        );
        catFactsListPresenter.onLengthChanged(50);

        catFactsListPresenter.onBindCatFactViewItemAtPosition(0, catFactsHolder);
        verify(catFactsHolder).setCatFactText("Some Fact");
    }


}
