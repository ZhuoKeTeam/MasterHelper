package com.yalantis.euclid.library;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.fresco.helper.ImageLoader;
import com.team.zhuoke.masterhelper.R;
import com.team.zhuoke.masterhelper.fragment.MasterInfoBean;

import java.util.List;

/**
 * Created by Oleksii Shliama on 1/27/15.
 */
public class EuclidListAdapter extends BaseAdapter {

    public static final String KEY_AVATAR = "avatar";
    public static final String KEY_NAME = "name";
    public static final String KEY_DESCRIPTION_SHORT = "description_short";
    public static final String KEY_DESCRIPTION_FULL = "description_full";

    private final LayoutInflater mInflater;
    private  List<MasterInfoBean> mData;
    private Context context;

    public EuclidListAdapter(Context context, List<MasterInfoBean> masterInfoBeanList) {
        this.context = context;
        mData = masterInfoBeanList;
        mInflater = LayoutInflater.from(context);
    }

    public void setData(List<MasterInfoBean> masterInfoBeanList) {
        mData = masterInfoBeanList;
    }

    @Override
    public int getCount() {
        return mData == null ? 0 : mData.size();
    }

    @Override
    public Object getItem(int position) {
        if (mData != null)
            return mData.get(position);
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.mViewOverlay = convertView.findViewById(R.id.view_avatar_overlay);
            viewHolder.mListItemAvatar = (SimpleDraweeView) convertView.findViewById(R.id.image_view_avatar);
            viewHolder.mListItemName = (TextView) convertView.findViewById(R.id.text_view_name);
            viewHolder.mListItemNickName = (TextView) convertView.findViewById(R.id.text_view_nick_name);
            viewHolder.mListItemDescription = (TextView) convertView.findViewById(R.id.text_view_description);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        MasterInfoBean masterInfoBean = mData.get(position);

        viewHolder.mListItemName.setText(masterInfoBean.getName());
        viewHolder.mListItemNickName.setText(masterInfoBean.getNick_name());
        viewHolder.mListItemDescription.setText(masterInfoBean.getInfo());
        viewHolder.mViewOverlay.setBackgroundDrawable(EuclidFragment.sOverlayShape);

        ImageLoader.loadImage(viewHolder.mListItemAvatar, masterInfoBean.getImg());
        return convertView;
    }

    static class ViewHolder {
        View mViewOverlay;
        TextView mListItemName;
        TextView mListItemNickName;
        TextView mListItemDescription;
        SimpleDraweeView mListItemAvatar;
    }
}
