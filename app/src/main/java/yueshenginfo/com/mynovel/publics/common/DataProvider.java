package yueshenginfo.com.mynovel.publics.common;

import java.util.ArrayList;

import yueshenginfo.com.mynovel.module.home.dto.BookShelfBean;

/**
 * Created by huchao on 2016/12/1.
 * Email 1064224874@qq.com
 */
public class DataProvider {


    public static ArrayList<BookShelfBean> bookShelf() {
        ArrayList<BookShelfBean> mBookShelfBean = new ArrayList<>();
        mBookShelfBean.add(new BookShelfBean("http://img3.imgtn.bdimg.com/it/u=2403822027,419118684&fm=21&gp=0.jpg","斗罗大陆","完结","已读10.2%"));
        mBookShelfBean.add(new BookShelfBean("http://img2.imgtn.bdimg.com/it/u=2370302811,891295877&fm=21&gp=0.jpg","斗罗大陆","未完结","已读83.2%"));
        mBookShelfBean.add(new BookShelfBean("http://img3.imgtn.bdimg.com/it/u=3228557436,21245517&fm=21&gp=0.jpg","斗罗大陆之无上之境","未完结","未读"));
        mBookShelfBean.add(new BookShelfBean("http://img3.imgtn.bdimg.com/it/u=2403822027,419118684&fm=21&gp=0.jpg","斗罗大陆","完结","已读10.2%"));
        mBookShelfBean.add(new BookShelfBean("http://img2.imgtn.bdimg.com/it/u=2370302811,891295877&fm=21&gp=0.jpg","斗罗大陆","未完结","已读83.2%"));
        mBookShelfBean.add(new BookShelfBean("http://img3.imgtn.bdimg.com/it/u=3228557436,21245517&fm=21&gp=0.jpg","斗罗大陆之无上之境","未完结","未读"));
        mBookShelfBean.add(new BookShelfBean("http://img3.imgtn.bdimg.com/it/u=2403822027,419118684&fm=21&gp=0.jpg","斗罗大陆","完结","已读10.2%"));
        mBookShelfBean.add(new BookShelfBean("http://img2.imgtn.bdimg.com/it/u=2370302811,891295877&fm=21&gp=0.jpg","斗罗大陆","未完结","已读83.2%"));
        mBookShelfBean.add(new BookShelfBean("http://img3.imgtn.bdimg.com/it/u=3228557436,21245517&fm=21&gp=0.jpg","斗罗大陆之无上之境","未完结","未读"));
        return mBookShelfBean;
    }
}
