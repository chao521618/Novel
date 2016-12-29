package yueshenginfo.com.mynovel.module.news.dto;

import java.util.List;

/**
 * Created by huchao on 2016/12/29.
 * Email 1064224874@qq.com
 */
public class NewsDto {

    /**
     * postid : PHOT23S22000100A
     * hasCover : false
     * hasHead : 1
     * replyCount : 35851
     * hasImg : 1
     * digest :
     * hasIcon : false
     * docid : 9IG74V5H00963VRO_C9EIDNEAbjlishidaiupdateDoc
     * title : 郑州百余辆公车警车拍卖 最低3000一辆
     * order : 1
     * priority : 340
     * lmodify : 2016-12-29 08:55:49
     * boardid : photoview_bbs
     * ads : [{"title":"俄坠机第二个黑匣子水下打捞画面曝光","tag":"photoset","imgsrc":"http://cms-bucket.nosdn.127.net/58a425b2ad954ecf905af05a588a2e7620161229102714.jpeg","subtitle":"","url":"00AO0001|2224263"},{"title":"冬泳小哥-32℃赤膊畅游冰河 泼水成冰","tag":"photoset","imgsrc":"http://cms-bucket.nosdn.127.net/d14c6e5864944adfa7d668d7806dda6520161229083901.jpeg","subtitle":"","url":"00AP0001|2224205"},{"title":"探访70后隐居道长 穿\"阴阳服\"画龙习武","tag":"photoset","imgsrc":"http://cms-bucket.nosdn.127.net/7125e116ad3a42fd85c42057bddf748c20161229080704.jpeg","subtitle":"","url":"00AP0001|2224210"},{"docid":"C9ESMP9T000181FM","title":"睡服女神：标签不重要|年度态度","tag":"doc","imgsrc":"http://cms-bucket.nosdn.127.net/3e662a5da9f8420ea26a86aa83c9e65620161229110628.jpeg","subtitle":"","url":"C9ESMP9T000181FM"},{"title":"航拍日渐\u201c消瘦\u201d的鄱阳湖 湖面变草原","tag":"photoset","imgsrc":"http://cms-bucket.nosdn.127.net/2590b8e680c34d44aa6e3f7f1f7995d120161229100715.jpeg","subtitle":"","url":"00AP0001|2224253"}]
     * photosetID : 00AP0001|2224194
     * imgsum : 5
     * topic_background : http://img2.cache.netease.com/m/newsapp/reading/cover1/C1348646712614.jpg
     * template : normal1
     * votecount : 33568
     * skipID : 00AP0001|2224194
     * alias : Top News
     * skipType : photoset
     * cid : C1348646712614
     * hasAD : 1
     * imgextra : [{"imgsrc":"http://cms-bucket.nosdn.127.net/e6b6c2a4833241b7a40a3571f192c68b20161229075857.jpeg"},{"imgsrc":"http://cms-bucket.nosdn.127.net/ecc250988d084d7b99a9301d67f630c520161229075858.jpeg"}]
     * source : 网易原创
     * ename : androidnews
     * tname : 头条
     * imgsrc : http://cms-bucket.nosdn.127.net/dc1a72554ca5410c8c15258fafcc58ff20161229075859.jpeg
     * ptime : 2016-12-29 08:00:23
     */

    private List<T1348647909107Dto> T1348647909107;

    public List<T1348647909107Dto> getT1348647909107() {
        return T1348647909107;
    }

    public void setT1348647909107(List<T1348647909107Dto> T1348647909107) {
        this.T1348647909107 = T1348647909107;
    }

    public static class T1348647909107Dto {
        private String postid;
        private boolean hasCover;
        private int hasHead;
        private int replyCount;
        private int hasImg;
        private String digest;
        private boolean hasIcon;
        private String docid;
        private String title;
        private int order;
        private int priority;
        private String lmodify;
        private String boardid;
        private String photosetID;
        private int imgsum;
        private String topic_background;
        private String template;
        private int votecount;
        private String skipID;
        private String alias;
        private String skipType;
        private String cid;
        private int hasAD;
        private String source;
        private String ename;
        private String tname;
        private String imgsrc;
        private String ptime;
        /**
         * title : 俄坠机第二个黑匣子水下打捞画面曝光
         * tag : photoset
         * imgsrc : http://cms-bucket.nosdn.127.net/58a425b2ad954ecf905af05a588a2e7620161229102714.jpeg
         * subtitle :
         * url : 00AO0001|2224263
         */

        private List<AdsDto> ads;
        /**
         * imgsrc : http://cms-bucket.nosdn.127.net/e6b6c2a4833241b7a40a3571f192c68b20161229075857.jpeg
         */

        private List<ImgextraDto> imgextra;

        public String getPostid() {
            return postid;
        }

        public void setPostid(String postid) {
            this.postid = postid;
        }

        public boolean isHasCover() {
            return hasCover;
        }

        public void setHasCover(boolean hasCover) {
            this.hasCover = hasCover;
        }

        public int getHasHead() {
            return hasHead;
        }

        public void setHasHead(int hasHead) {
            this.hasHead = hasHead;
        }

        public int getReplyCount() {
            return replyCount;
        }

        public void setReplyCount(int replyCount) {
            this.replyCount = replyCount;
        }

        public int getHasImg() {
            return hasImg;
        }

        public void setHasImg(int hasImg) {
            this.hasImg = hasImg;
        }

        public String getDigest() {
            return digest;
        }

        public void setDigest(String digest) {
            this.digest = digest;
        }

        public boolean isHasIcon() {
            return hasIcon;
        }

        public void setHasIcon(boolean hasIcon) {
            this.hasIcon = hasIcon;
        }

        public String getDocid() {
            return docid;
        }

        public void setDocid(String docid) {
            this.docid = docid;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public String getLmodify() {
            return lmodify;
        }

        public void setLmodify(String lmodify) {
            this.lmodify = lmodify;
        }

        public String getBoardid() {
            return boardid;
        }

        public void setBoardid(String boardid) {
            this.boardid = boardid;
        }

        public String getPhotosetID() {
            return photosetID;
        }

        public void setPhotosetID(String photosetID) {
            this.photosetID = photosetID;
        }

        public int getImgsum() {
            return imgsum;
        }

        public void setImgsum(int imgsum) {
            this.imgsum = imgsum;
        }

        public String getTopic_background() {
            return topic_background;
        }

        public void setTopic_background(String topic_background) {
            this.topic_background = topic_background;
        }

        public String getTemplate() {
            return template;
        }

        public void setTemplate(String template) {
            this.template = template;
        }

        public int getVotecount() {
            return votecount;
        }

        public void setVotecount(int votecount) {
            this.votecount = votecount;
        }

        public String getSkipID() {
            return skipID;
        }

        public void setSkipID(String skipID) {
            this.skipID = skipID;
        }

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public String getSkipType() {
            return skipType;
        }

        public void setSkipType(String skipType) {
            this.skipType = skipType;
        }

        public String getCid() {
            return cid;
        }

        public void setCid(String cid) {
            this.cid = cid;
        }

        public int getHasAD() {
            return hasAD;
        }

        public void setHasAD(int hasAD) {
            this.hasAD = hasAD;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getEname() {
            return ename;
        }

        public void setEname(String ename) {
            this.ename = ename;
        }

        public String getTname() {
            return tname;
        }

        public void setTname(String tname) {
            this.tname = tname;
        }

        public String getImgsrc() {
            return imgsrc;
        }

        public void setImgsrc(String imgsrc) {
            this.imgsrc = imgsrc;
        }

        public String getPtime() {
            return ptime;
        }

        public void setPtime(String ptime) {
            this.ptime = ptime;
        }

        public List<AdsDto> getAds() {
            return ads;
        }

        public void setAds(List<AdsDto> ads) {
            this.ads = ads;
        }

        public List<ImgextraDto> getImgextra() {
            return imgextra;
        }

        public void setImgextra(List<ImgextraDto> imgextra) {
            this.imgextra = imgextra;
        }

        public static class AdsDto {
            private String title;
            private String tag;
            private String imgsrc;
            private String subtitle;
            private String url;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getTag() {
                return tag;
            }

            public void setTag(String tag) {
                this.tag = tag;
            }

            public String getImgsrc() {
                return imgsrc;
            }

            public void setImgsrc(String imgsrc) {
                this.imgsrc = imgsrc;
            }

            public String getSubtitle() {
                return subtitle;
            }

            public void setSubtitle(String subtitle) {
                this.subtitle = subtitle;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class ImgextraDto {
            private String imgsrc;

            public String getImgsrc() {
                return imgsrc;
            }

            public void setImgsrc(String imgsrc) {
                this.imgsrc = imgsrc;
            }
        }
    }
}
