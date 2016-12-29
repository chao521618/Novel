package yueshenginfo.com.mynovel.module.home.dto;

import java.util.List;

/**
 * Created by huchao on 2016/12/27.
 * Email 1064224874@qq.com
 */
public class VideoListDto {

    /**
     * topicImg : http://vimg1.ws.126.net/image/snapshot/2016/11/Q/T/VC3UNEQQT.jpg
     * videosource : 新媒体
     * mp4Hd_url : http://flv2.bn.netease.com/videolib3/1612/27/iQUZm5412/HD/iQUZm5412-mobile.mp4
     * topicDesc : “百搭屋”是一个引领软装行业变革的家居软装设计交互平台，汇集众多知名软装设计师和家居买手；百搭屋会以生活方式引导您的软装品味，设计符合您生活品味的、独一无二的生活空间。
     * topicSid : VC3UNEQQH
     * cover : http://vimg3.ws.126.net/image/snapshot/2016/12/S/9/VC8CFUGS9.jpg
     * title : 软装设计师教你如何选择沙发和打理沙发的小技巧
     * playCount : 0
     * replyBoard : video_bbs
     * videoTopic : {"alias":"百搭屋是家居软装设计交互平台","tname":"百搭屋APP","ename":"T1478067865038","tid":"T1478067865038"}
     * sectiontitle :
     * replyid : C8CFOTVM008535RB
     * description : 今天给大家推荐的两款沙发有什么特别的地方吗？这款椅子在舒适度上和形状上比较适合放在家里。沙发椅在材料和款式上是非常有现代风格的。这两款沙发椅是美式包钉扣传统做法，在色彩上都是素色。素色有个特性就是百搭。那么这两款沙发如何打理呢？可以用干毛巾擦拭，也可以用吹风机清理灰尘。
     * mp4_url : http://flv2.bn.netease.com/videolib3/1612/27/iQUZm5412/SD/iQUZm5412-mobile.mp4
     * length : 159
     * playersize : 0
     * m3u8Hd_url : http://flv2.bn.netease.com/videolib3/1612/27/iQUZm5412/HD/movie_index.m3u8
     * vid : VC8CFOTVM
     * m3u8_url : http://flv2.bn.netease.com/videolib3/1612/27/iQUZm5412/SD/movie_index.m3u8
     * ptime : 2016-12-27 16:10:49
     * topicName : 百搭屋APP
     */

    private List<V9LG4B3A0VO> V9LG4B3A0;

    public List<V9LG4B3A0VO> getV9LG4B3A0() {
        return V9LG4B3A0;
    }

    public void setV9LG4B3A0(List<V9LG4B3A0VO> V9LG4B3A0) {
        this.V9LG4B3A0 = V9LG4B3A0;
    }

    public static class V9LG4B3A0VO {
        private String topicImg;
        private String videosource;
        private String mp4Hd_url;
        private String topicDesc;
        private String topicSid;
        private String cover;
        private String title;
        private int playCount;
        private String replyBoard;
        /**
         * alias : 百搭屋是家居软装设计交互平台
         * tname : 百搭屋APP
         * ename : T1478067865038
         * tid : T1478067865038
         */

        private VideoTopicVO videoTopic;
        private String sectiontitle;
        private String replyid;
        private String description;
        private String mp4_url;
        private int length;
        private int playersize;
        private String m3u8Hd_url;
        private String vid;
        private String m3u8_url;
        private String ptime;
        private String topicName;

        public String getTopicImg() {
            return topicImg;
        }

        public void setTopicImg(String topicImg) {
            this.topicImg = topicImg;
        }

        public String getVideosource() {
            return videosource;
        }

        public void setVideosource(String videosource) {
            this.videosource = videosource;
        }

        public String getMp4Hd_url() {
            return mp4Hd_url;
        }

        public void setMp4Hd_url(String mp4Hd_url) {
            this.mp4Hd_url = mp4Hd_url;
        }

        public String getTopicDesc() {
            return topicDesc;
        }

        public void setTopicDesc(String topicDesc) {
            this.topicDesc = topicDesc;
        }

        public String getTopicSid() {
            return topicSid;
        }

        public void setTopicSid(String topicSid) {
            this.topicSid = topicSid;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getPlayCount() {
            return playCount;
        }

        public void setPlayCount(int playCount) {
            this.playCount = playCount;
        }

        public String getReplyBoard() {
            return replyBoard;
        }

        public void setReplyBoard(String replyBoard) {
            this.replyBoard = replyBoard;
        }

        public VideoTopicVO getVideoTopic() {
            return videoTopic;
        }

        public void setVideoTopic(VideoTopicVO videoTopic) {
            this.videoTopic = videoTopic;
        }

        public String getSectiontitle() {
            return sectiontitle;
        }

        public void setSectiontitle(String sectiontitle) {
            this.sectiontitle = sectiontitle;
        }

        public String getReplyid() {
            return replyid;
        }

        public void setReplyid(String replyid) {
            this.replyid = replyid;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getMp4_url() {
            return mp4_url;
        }

        public void setMp4_url(String mp4_url) {
            this.mp4_url = mp4_url;
        }

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public int getPlayersize() {
            return playersize;
        }

        public void setPlayersize(int playersize) {
            this.playersize = playersize;
        }

        public String getM3u8Hd_url() {
            return m3u8Hd_url;
        }

        public void setM3u8Hd_url(String m3u8Hd_url) {
            this.m3u8Hd_url = m3u8Hd_url;
        }

        public String getVid() {
            return vid;
        }

        public void setVid(String vid) {
            this.vid = vid;
        }

        public String getM3u8_url() {
            return m3u8_url;
        }

        public void setM3u8_url(String m3u8_url) {
            this.m3u8_url = m3u8_url;
        }

        public String getPtime() {
            return ptime;
        }

        public void setPtime(String ptime) {
            this.ptime = ptime;
        }

        public String getTopicName() {
            return topicName;
        }

        public void setTopicName(String topicName) {
            this.topicName = topicName;
        }

        public static class VideoTopicVO {
            private String alias;
            private String tname;
            private String ename;
            private String tid;

            public String getAlias() {
                return alias;
            }

            public void setAlias(String alias) {
                this.alias = alias;
            }

            public String getTname() {
                return tname;
            }

            public void setTname(String tname) {
                this.tname = tname;
            }

            public String getEname() {
                return ename;
            }

            public void setEname(String ename) {
                this.ename = ename;
            }

            public String getTid() {
                return tid;
            }

            public void setTid(String tid) {
                this.tid = tid;
            }
        }
    }
}
