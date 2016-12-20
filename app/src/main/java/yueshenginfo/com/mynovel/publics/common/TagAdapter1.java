package yueshenginfo.com.mynovel.publics.common;

import android.view.View;

import com.zhy.view.flowlayout.FlowLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by huchao on 2016/12/20.
 * Email 1064224874@qq.com
 */

    public abstract class TagAdapter1<T>
    {
        private List<T> mTagDatas;
        private OnDataChangedListener mOnDataChangedListener;
        private HashSet<Integer> mCheckedPosList = new HashSet<Integer>();

        public TagAdapter1(List<T> datas)
        {
            mTagDatas = datas;
        }

        public TagAdapter1(T[] datas)
        {
            mTagDatas = new ArrayList<T>(Arrays.asList(datas));
        }

        static interface OnDataChangedListener
        {
            void onChanged();
        }

        void setOnDataChangedListener(OnDataChangedListener listener)
        {
            mOnDataChangedListener = listener;
        }

        public void setSelectedList(int... pos)
        {
            for (int i = 0; i < pos.length; i++)
                mCheckedPosList.add(pos[i]);
            notifyDataChanged();
        }

        public void setSelectedList(Set<Integer> set)
        {

            mCheckedPosList.clear();
            if (set != null)
                mCheckedPosList.addAll(set);
            notifyDataChanged();
        }

        HashSet<Integer> getPreCheckedList()
        {
            return mCheckedPosList;
        }


        public int getCount()
        {
            return mTagDatas == null ? 0 : mTagDatas.size();
        }

        public void notifyDataChanged()
        {
            mOnDataChangedListener.onChanged();
        }

        public T getItem(int position)
        {
            return mTagDatas.get(position);
        }

        public abstract View getView(FlowLayout parent, int position, T t);

        public boolean setSelected(int position, T t)
        {
            return false;
        }


    }
