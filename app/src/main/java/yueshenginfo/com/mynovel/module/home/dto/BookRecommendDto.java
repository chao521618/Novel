package yueshenginfo.com.mynovel.module.home.dto;

import java.util.List;

/**
 * Created by huchao on 2016/12/14.
 * Email 1064224874@qq.com
 */
public class BookRecommendDto {

    /**
     * books : [{"_id":"536c79e8958ff186030000a3","title":"特种兵在都市","author":"夜十三","shortIntro":"他性格嚣张狂妄，为达目的不折手段。他痞气十足，各种美女为他痴狂。在这繁华的都市，杨洛上演了一场激情四射的热血人生。","cover":"/agent/http://img1.readnovel.com/incoming/book/0/40/120040_mr.jpg","hasCp":true,"latelyFollower":108985,"latelyFollowerBase":0,"minRetentionRatio":0,"retentionRatio":37.09,"updated":"2016-12-11T16:54:37.184Z","chaptersCount":2211,"lastChapter":"第2210章 霍家兄弟"},{"_id":"565eb60d4e47b55a5ded7127","title":"都市奇门医圣","author":"一念（红薯网）","shortIntro":"实习医生叶皓轩，意外的得到一本古书上的玄术与医道传承，自此开始了不一样的人生，他银针渡人，术法渡鬼，成就济世仁心，都市生活逍遥自在，校花、御姐加熟女，教师、医生...","cover":"/cover/147159726279785","hasCp":true,"latelyFollower":65385,"latelyFollowerBase":105156,"minRetentionRatio":69.42,"retentionRatio":41.7,"updated":"2016-12-13T08:44:23.112Z","chaptersCount":2436,"lastChapter":"第2436章　感觉"},{"_id":"5684f7638cb1e9f26992edf2","title":"龙符","author":"梦入神机","shortIntro":"苍茫大地，未来变革，混乱之中，龙蛇并起，谁是真龙，谁又是蟒蛇？或是天地众生，皆可成龙？朝廷，江湖门派，世外仙道，千年世家，蛮族，魔神，妖族，上古巫道，千百势力，...","cover":"/agent/http://static.zongheng.com/upload/cover/2015/12/1451542120546.jpg","hasCp":true,"latelyFollower":78243,"latelyFollowerBase":0,"minRetentionRatio":0,"retentionRatio":47.27,"updated":"2016-12-14T00:24:24.479Z","chaptersCount":762,"lastChapter":"第七百六十三章  大势已成"},{"_id":"56cd10bb32dc12e56764cf25","title":"天骄战纪","author":"萧瑾瑜","shortIntro":"苍图大陆，茫茫无垠。有古老宗门盘踞十方古域，有世外仙道屹立青冥之上，有太古妖神统领黑暗大渊，缔造了不知多少的辉煌篇章。就在这大千世界中，一个名叫林寻的少年，独自...","cover":"/agent/http://static.zongheng.com/upload/cover/2016/02/1456282051781.png","hasCp":true,"latelyFollower":45527,"latelyFollowerBase":0,"minRetentionRatio":0,"retentionRatio":39.63,"updated":"2016-12-13T16:04:55.482Z","chaptersCount":637,"lastChapter":"冠盖满京华 第六百三十四章 风云变幻"},{"_id":"5721d80d843a87e12703f469","title":"最强升级系统","author":"大海好多水","shortIntro":"你见过杀鸡爆出神级血脉的没有？你见过杀蛤蟆爆出神品武技的没有？你见过整个世界的女人为他一个人男人疯狂的没有？肩扛屠龙刀，手握诸神剑，哥就问一句，\u201c妈的，还有谁？\u201d宅男龙飞带着一款狂暴系统穿越而来，杀怪升级，杀人也升级，碾压三界，打爆一切不服者！","cover":"/agent/http://rm2.kingreader.com/book/1074191/m/%5B640%5D_%E6%9C%80%E5%BC%BA%E5%8D%87%E7%BA%A7%E7%B3%BB%E7%BB%9F.jpg","hasCp":true,"latelyFollower":71773,"latelyFollowerBase":2331,"minRetentionRatio":73.32,"retentionRatio":41.83,"updated":"2016-12-13T17:24:43.584Z","chaptersCount":1858,"lastChapter":"第1858章 势不两立"},{"_id":"557e0b2bdcfc794e1a1cd8b2","title":"雪鹰领主","author":"我吃西红柿","shortIntro":"深渊恶魔降临\u2026\u2026 异世界来客潜伏人间\u2026\u2026 神灵们在窥伺这座世界\u2026\u2026 然而，这是夏族统治的世界！夏族的强者们征战四方，巡守天地海洋，灭杀一切威胁！ 这群强者有一个...","cover":"/cover/147521131159596","hasCp":true,"latelyFollower":148638,"latelyFollowerBase":0,"minRetentionRatio":0,"retentionRatio":79.01,"updated":"2016-12-13T17:54:24.181Z","chaptersCount":1017,"lastChapter":"第1019章 转世  竟然还有高手？"}]
     * ok : true
     */

    private boolean ok;
    /**
     * _id : 536c79e8958ff186030000a3
     * title : 特种兵在都市
     * author : 夜十三
     * shortIntro : 他性格嚣张狂妄，为达目的不折手段。他痞气十足，各种美女为他痴狂。在这繁华的都市，杨洛上演了一场激情四射的热血人生。
     * cover : /agent/http://img1.readnovel.com/incoming/book/0/40/120040_mr.jpg
     * hasCp : true
     * latelyFollower : 108985
     * latelyFollowerBase : 0
     * minRetentionRatio : 0
     * retentionRatio : 37.09
     * updated : 2016-12-11T16:54:37.184Z
     * chaptersCount : 2211
     * lastChapter : 第2210章 霍家兄弟
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
        private boolean hasCp;
        private int latelyFollower;
        private int latelyFollowerBase;
        private float minRetentionRatio;
        private double retentionRatio;
        private String updated;
        private int chaptersCount;
        private String lastChapter;

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

        public boolean isHasCp() {
            return hasCp;
        }

        public void setHasCp(boolean hasCp) {
            this.hasCp = hasCp;
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

        public void setMinRetentionRatio(int minRetentionRatio) {
            this.minRetentionRatio = minRetentionRatio;
        }

        public double getRetentionRatio() {
            return retentionRatio;
        }

        public void setRetentionRatio(double retentionRatio) {
            this.retentionRatio = retentionRatio;
        }

        public String getUpdated() {
            return updated;
        }

        public void setUpdated(String updated) {
            this.updated = updated;
        }

        public int getChaptersCount() {
            return chaptersCount;
        }

        public void setChaptersCount(int chaptersCount) {
            this.chaptersCount = chaptersCount;
        }

        public String getLastChapter() {
            return lastChapter;
        }

        public void setLastChapter(String lastChapter) {
            this.lastChapter = lastChapter;
        }
    }
}
