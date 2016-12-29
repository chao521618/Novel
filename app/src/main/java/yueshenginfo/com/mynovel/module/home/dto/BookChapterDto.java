package yueshenginfo.com.mynovel.module.home.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created by huchao on 2016/12/5.
 * Email 1064224874@qq.com
 */
public class BookChapterDto  {

//
//    /**
//     * _id : 5736013f03c072d93f37d6f3
//     * book : 5721d80d843a87e12703f469
//     * chaptersCount1 : 965
//     * chaptersUpdated : 2016-12-05T17:24:37.499Z
//     * "unreadble":false},{"title":"第580章 批斗","link":"http://www.luoqiu.com/read/57830/15382889.html","unreadble":false},{"title":"第581章 你的命是我的","link":"http://www.luoqiu.com/read/57830/15382907.html","unreadble":false},{"title":"第582章 升级的地方","link":"http://www.luoqiu.com/read/57830/15382929.html","unreadble":false},{"title":"第583章 狂升级","link":"http://www.luoqiu.com/read/57830/15382950.html","unreadble":false},{"title":"第584章","link":"http://www.luoqiutml","unreadble":false},{"title":"第597章 我还活着","link":"http://www.luoqiu.com/read/57830readble":false},{"title":"第619章 魔剑，该你登场了！","link":"http://www.luoqiu.com/read/57830/15384081.html","unreadble":false},{"title":"第620章 天价","link":"http://www.luoqiu.com/read/57830/15384097.htm479.html","unreadble":false},{"title":"第741章 三招！","link":"http://www.luoqiu.com/read/57830/15386494.html","unreadble":false},{"title":"第742章 别跟我抢男人","link":"http://www.luoqiu.com/read/57830/15386505.html","unreadble":false},{"title":"第743章 五年",更加不爽","link":"http://www.luoqiu.com/read/57830/32670590.html","unreadble":false}]
//     * updated : 2016-12-05T17:24:37.499Z
//     */
//
//    private MixTocVO mixToc;
//    /**
//     * mixToc : {"_id":"5736013f03c072d93f37d6f3","book":"5721d80d843a87e12703f469","chaptersCount1":965,"chaptersUpdated":"2016-12-05T17:24:37.499Z","chapters":[{"title":"第001章 狂暴系统","link":"http://www.luoqiu.com/read/57830/15222009.html","unreadble":false},{"title":"第002章{"title":"第1828章 我不爽，你会更加不爽","link":"http://www.luoqiu.com/read/57830/32670590.html","unreadble":false}],"updated":"2016-12-05T17:24:37.499Z"}
//     * ok : true
//     */
//
//    private boolean ok;
//
//    public MixTocVO getMixToc() {
//        return mixToc;
//    }
//
//    public void setMixToc(MixTocVO mixToc) {
//        this.mixToc = mixToc;
//    }
//
//    public boolean isOk() {
//        return ok;
//    }
//
//    public void setOk(boolean ok) {
//        this.ok = ok;
//    }
//
//    public static class MixTocVO {
//        private String _id;
//        private String book;
//        private int chaptersCount1;
//        private String chaptersUpdated;
//        private String updated;
//        /**
//         * title : 第001章 狂暴系统
//         * link : http://www.luoqiu.com/read/57830/15222009.html
//         * unreadble : false
//         */
//
//        public List<ChaptersVO> chapters;
//
//        public String get_id() {
//            return _id;
//        }
//
//        public void set_id(String _id) {
//            this._id = _id;
//        }
//
//        public String getBook() {
//            return book;
//        }
//
//        public void setBook(String book) {
//            this.book = book;
//        }
//
//        public int getChaptersCount1() {
//            return chaptersCount1;
//        }
//
//        public void setChaptersCount1(int chaptersCount1) {
//            this.chaptersCount1 = chaptersCount1;
//        }
//
//        public String getChaptersUpdated() {
//            return chaptersUpdated;
//        }
//
//        public void setChaptersUpdated(String chaptersUpdated) {
//            this.chaptersUpdated = chaptersUpdated;
//        }
//
//        public String getUpdated() {
//            return updated;
//        }
//
//        public void setUpdated(String updated) {
//            this.updated = updated;
//        }
//
//        public List<ChaptersVO> getChapters() {
//            return chapters;
//        }
//
//        public void setChapters(List<ChaptersVO> chapters) {
//            this.chapters = chapters;
//        }
//
//        public static class ChaptersVO {
//            //            private String title;
////            private String link;
////            private boolean unreadble;
////
////            public String getTitle() {
////                return title;
////            }
////
////            public void setTitle(String title) {
////                this.title = title;
////            }
////
////            public String getLink() {
////                return link;
////            }
////
////            public void setLink(String link) {
////                this.link = link;
////            }
////
////            public boolean isUnreadble() {
////                return unreadble;
////            }
////
////            public void setUnreadble(boolean unreadble) {
////                this.unreadble = unreadble;
////            }
//            public String title;
//            public String link;
//            public String id;
//        }
//    }
    /**
     * _id:577e528e2160421a02d7380d
     * name:优质书源
     * link:http://vip.zhuishushenqi.com/toc/577e528e2160421a02d7380d
     */
    public mixToc mixToc;
    public static class mixToc implements Serializable {
        public String _id;
        public String book;
        public String chaptersUpdated;
        /**
         * title : 第一章 死在万花丛中
         * link : http://vip.zhuishushenqi.com/chapter/577e5290260289ff64a29213?cv=1467896464908
         * id : 577e5290260289ff64a29213
         * currency : 15
         * unreadble : false
         * isVip : false
         */

        public List<Chapters> chapters;

        public static class Chapters implements Serializable {
            public String title;
            public String link;
            public String id;
            public int currency;
            public boolean unreadble;
            public boolean isVip;
        }
    }
}
