package asd.com.myapplication;

import android.graphics.Canvas;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.orhanobut.logger.Logger;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import asd.com.retrofit.MRetrofigService;
import asd.com.retrofit.RetrofitUtil;
import asd.com.retrofit.bean.Cook;
import asd.com.retrofit.bean.Tngou;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class Activity_retrofit extends AppCompatActivity implements Callback<Tngou> {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private List<Cook> listCooks = new ArrayList<>();
    CommonAdapter<Cook> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        ButterKnife.bind(this);

//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,6);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (1 < position && position < 7) {
                    return 3;//3代表 当前(position)item占据3列  总6列  所以一行可以放2个
                } else if (9 < position && position < 19) {//设定position10-18为  三个一行的
                    return 2;
                } else {
                    return 6;
                }
            }
        });
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
                super.onDraw(c, parent, state);
            }
        });

        adapter = new CommonAdapter<Cook>(Activity_retrofit.this, R.layout.layout_retrofig_rxandroid_item, listCooks) {
            @Override
            protected void convert(ViewHolder holder, Cook cook, int position) {
                Glide.with(mContext).load("http://tnfs.tngou.net/img" + cook.getImg()).into((ImageView) holder.getView(R.id.image));
                holder.setText(R.id.title, cook.getName());
                holder.setText(R.id.mes, cook.getDescription());
            }
        };
        recyclerView.setAdapter(adapter);

        retrofitAxandroid();
//        retrofit();
    }

    private void retrofitAxandroid() {
        RetrofitUtil.getInstance().getRetrofit().create(MRetrofigService.class)
                .getTngouByPost_("cook", 0, 1, 10)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Tngou>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Tngou tngou) {
                        listCooks.addAll(tngou.getTngou());
                        adapter.notifyDataSetChanged();
                    }
                });
               /* .subscribe(new Action1<Tngou>() {
                    @Override
                    public void call(Tngou tngou) {
                        listCooks.addAll(tngou.getTngou());
                        adapter.notifyDataSetChanged();
                    }
                });*/
    }

    private void retrofit() {
        Retrofit retrofit = RetrofitUtil.getInstance().getRetrofit();

        MRetrofigService mRetrofigService = retrofit.create(MRetrofigService.class);
//        Call<Tngou> call = mRetrofigService.getTngouByGet("cook", 0, 1, 10);
//        Call<Tngou> call = mRetrofigService.getTngouByGet("top", 0, 1, 10);
        Call<Tngou> call = mRetrofigService.getTngouByPost("cook", 0, 1, 10);
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<Tngou> call, Response<Tngou> response) {
        List<Cook> cooks = response.body().getTngou();
        listCooks.addAll(cooks);
        adapter.notifyDataSetChanged();
        Logger.e(cooks.size() + "------------");
        /*Observable.from(cooks).subscribe(new Action1<Cook>() {
            @Override
            public void call(Cook cook) {

            }
        });*/
    }

    @Override
    public void onFailure(Call<Tngou> call, Throwable t) {
        t.printStackTrace();
    }
}