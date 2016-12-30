package yueshenginfo.com.mynovel.module.news.event;

import java.util.List;

import yueshenginfo.com.mynovel.module.news.dto.HeadsNewsDto;

/**
 * Created by huchao on 2016/12/29.
 * Email 1064224874@qq.com
 */
public class TypeEvent2 {
    public List<HeadsNewsDto.T1348647909107Dto> mArrayList;

    public TypeEvent2(List<HeadsNewsDto.T1348647909107Dto> mArrayList) {
        this.mArrayList = mArrayList;
    }
//    public int type;
//
//    public TypeEvent(List<HeadsNewsDto.T1348647909107Dto> mArrayList, int type) {
//        this.mArrayList = mArrayList;
//        this.type = type;
//    }


    public List<HeadsNewsDto.T1348647909107Dto> getmArrayList() {
        return mArrayList;
    }

    public void setmArrayList(List<HeadsNewsDto.T1348647909107Dto> mArrayList) {
        this.mArrayList = mArrayList;
    }
}
