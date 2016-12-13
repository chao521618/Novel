package yueshenginfo.com.mynovel.module.morenovel.dto;

import java.util.List;

/**
 * Created by huchao on 2016/12/12.
 * Email 1064224874@qq.com
 */
public class BooksDto {



    private boolean ok;
    /**
     * _id : 5816b415b06d1d32157790b1
     * title : 圣墟
     * author : 辰东
     * shortIntro : 在破败中崛起，在寂灭中复苏。 沧海成尘，雷电枯竭，那一缕幽雾又一次临近大地，世间的枷锁被打开了，一个全新的世界就此揭开神秘的一角……
     * cover : /agent/http://qidian.qpic.cn/qdbimg/349573/1004608738/180
     * site : zhuishuvip
     * majorCate : 玄幻
     * latelyFollower : 153810
     * latelyFollowerBase : 0
     * minRetentionRatio : 0
     * retentionRatio : 71.05
     * lastChapter : 第83章 大林寺震世
     * tags : ["玄幻","东方玄幻"]
     */

    private List<BooksVO> books;

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public List<BooksVO> getBooks() {
        return books;
    }

    public void setBooks(List<BooksVO> books) {
        this.books = books;
    }

    public static class BooksVO {
        private String _id;
        private String title;
        private String author;
        private String shortIntro;
        private String cover;
        private String site;
        private String majorCate;
        private int latelyFollower;
        private int latelyFollowerBase;
        private float minRetentionRatio;
        private float retentionRatio;
        private String lastChapter;
        private List<String> tags;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getShortIntro() {
            return shortIntro;
        }

        public void setShortIntro(String shortIntro) {
            this.shortIntro = shortIntro;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getSite() {
            return site;
        }

        public void setSite(String site) {
            this.site = site;
        }

        public String getMajorCate() {
            return majorCate;
        }

        public void setMajorCate(String majorCate) {
            this.majorCate = majorCate;
        }

        public int getLatelyFollower() {
            return latelyFollower;
        }

        public void setLatelyFollower(int latelyFollower) {
            this.latelyFollower = latelyFollower;
        }

        public int getLatelyFollowerBase() {
            return latelyFollowerBase;
        }

        public void setLatelyFollowerBase(int latelyFollowerBase) {
            this.latelyFollowerBase = latelyFollowerBase;
        }

        public float getMinRetentionRatio() {
            return minRetentionRatio;
        }

        public void setMinRetentionRatio(float minRetentionRatio) {
            this.minRetentionRatio = minRetentionRatio;
        }

        public float getRetentionRatio() {
            return retentionRatio;
        }

        public void setRetentionRatio(float retentionRatio) {
            this.retentionRatio = retentionRatio;
        }

        public String getLastChapter() {
            return lastChapter;
        }

        public void setLastChapter(String lastChapter) {
            this.lastChapter = lastChapter;
        }

        public List<String> getTags() {
            return tags;
        }

        public void setTags(List<String> tags) {
            this.tags = tags;
        }
    }
}
