package mvpframework.bwie.com.day2mn.view;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import mvpframework.bwie.com.day2mn.MyAdapter.Adapter;
import mvpframework.bwie.com.day2mn.MyAdapter.EndLessOnScrollListener;
import mvpframework.bwie.com.day2mn.MyAdapter.MyDecoration;
import mvpframework.bwie.com.day2mn.R;
import mvpframework.bwie.com.day2mn.bean.MusicBean;
import mvpframework.bwie.com.day2mn.presenter.LibiaoPersenter;

public class LibiaoActivity extends AppCompatActivity implements   SwipeRefreshLayout.OnRefreshListener,ILibiaoActivity  {
    private int offer;
    private RecyclerView mRv;
    private LibiaoPersenter persenter;
    private SwipeRefreshLayout mLayoutSwipeRefresh;
    private Adapter adapter;
    private LinearLayoutManager mlinearLayoutManager;
    private ArrayList<String> psp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libiao);

        initData();
        initView();

        persenter = new LibiaoPersenter(this);
        persenter.getMusic(offer + "");

        mlinearLayoutManager = new LinearLayoutManager(this);
        mRv.setLayoutManager(mlinearLayoutManager);
        mRv.addItemDecoration(new MyDecoration(this, MyDecoration.VERTICAL_LIST));

        mRv.addOnScrollListener(new EndLessOnScrollListener(mlinearLayoutManager) {
            @Override
            public void onLoadMore(int currentPage) {
                loadMoreData();
            }
        });

    }


    private void initView() {
        mRv = (RecyclerView) findViewById(R.id.rv);


        mLayoutSwipeRefresh = (SwipeRefreshLayout) findViewById(R.id.layout_swipe_refresh);


        //这个是下拉刷新出现的那个圈圈要显示的颜色
        mLayoutSwipeRefresh.setColorSchemeResources(
                R.color.colorAccent,
                R.color.colorPrimary,
                R.color.colorPrimaryDark
        );

    }

    private void loadMoreData(){
        for (int i =0; i < 10; i++){
            psp.add("嘿，我是“上拉加载”生出来的"+i);
            adapter.notifyDataSetChanged();

        }
    }
    private void initData(){
        psp = new ArrayList<>();

        for (int i = 0; i < 20; i++){
            psp.add("Item"+i);
        }
    }
    private void updateData(){
        //我在List最前面加入一条数据
        psp.add(0, "嘿，我是“下拉刷新”生出来的");
    }


    @Override
    public void showRv(List<MusicBean.SongListBean> list) {
        adapter = new Adapter( list,psp,LibiaoActivity.this);
        mRv.setAdapter(adapter);
    }




    @Override
    public void onRefresh() {
        updateData();
        psp.add(0, "嘿，我是“下拉刷新”生出来的");

        //数据重新加载完成后，提示数据发生改变，并且设置现在不在刷新
        adapter.notifyDataSetChanged();
        mLayoutSwipeRefresh.setRefreshing(false);
    }
}
