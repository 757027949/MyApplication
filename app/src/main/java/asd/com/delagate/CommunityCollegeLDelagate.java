package asd.com.delagate;

import com.zhy.adapter.abslistview.ViewHolder;
import com.zhy.adapter.abslistview.base.ItemViewDelegate;

import asd.com.myapplication.R;

/**
 * Created by Administrator on 2016/9/28.
 */

public class CommunityCollegeLDelagate implements ItemViewDelegate<String> {

    @Override
    public int getItemViewLayoutId() {
        return R.layout.layout_item_community_college_l;
    }

    @Override
    public boolean isForViewType(String item, int position) {
        return position % 2 == 0;
    }

    @Override
    public void convert(ViewHolder holder, String chatMessage, int position) {
    }
}
