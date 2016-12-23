package yueshenginfo.com.mynovel.module.review.dto;

import java.util.List;

/**
 * Created by huchao on 2016/12/23.
 * Email 1064224874@qq.com
 */
public class ReviewFloorDto {

    /**
     * comments : [{"_id":"5857c1c9149c7cd17e6c2003","content":"对对","author":{"_id":"5855e2a620d2ff376f9dc68d","avatar":"/avatar/9b/2a/9b2a168d52be23ce365b1fbd40e624c4","nickname":":-(V5大总攻","type":"normal","lv":2,"gender":"male"},"floor":4,"likeCount":0,"created":"2016-12-19T11:17:29.751Z","replyTo":null},{"_id":"5856494d278d3ea955a123d9","content":"嗯","author":{"_id":"571cb8e1eb1a1d2402b08b3c","avatar":"/avatar/c8/cd/c8cd8168edaf77847b26682114ad3aa2","nickname":"开心果^O^＆","type":"normal","lv":8,"gender":"male"},"floor":3,"likeCount":0,"created":"2016-12-18T08:31:09.617Z","replyTo":null},{"_id":"58459cfde74bd5ea3036e169","content":"哪好了？","author":{"_id":"5749eab9542746bc2ed07686","avatar":"/avatar/ae/e9/aee9375b3fe48df0b3d73c37f8ddc962","nickname":"Blue-时尚","type":"normal","lv":7,"gender":"male"},"floor":2,"likeCount":1,"created":"2016-12-05T16:59:41.857Z","replyTo":null},{"_id":"5844412958567dc912866152","content":"同感","author":{"_id":"57be3fce1edc629c04ab20fe","avatar":"/avatar/8a/0c/8a0c5c713c260ba3060494918e4c827c","nickname":"迷恋红尘","type":"normal","lv":5,"gender":"male"},"floor":1,"likeCount":0,"created":"2016-12-04T16:15:37.427Z","replyTo":null}]
     * ok : true
     */

    private boolean ok;
    /**
     * _id : 5857c1c9149c7cd17e6c2003
     * content : 对对
     * author : {"_id":"5855e2a620d2ff376f9dc68d","avatar":"/avatar/9b/2a/9b2a168d52be23ce365b1fbd40e624c4","nickname":":-(V5大总攻","type":"normal","lv":2,"gender":"male"}
     * floor : 4
     * likeCount : 0
     * created : 2016-12-19T11:17:29.751Z
     * replyTo : null
     */

    private List<CommentsVO> comments;

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public List<CommentsVO> getComments() {
        return comments;
    }

    public void setComments(List<CommentsVO> comments) {
        this.comments = comments;
    }

    public static class CommentsVO {
        private String _id;
        private String content;
        /**
         * _id : 5855e2a620d2ff376f9dc68d
         * avatar : /avatar/9b/2a/9b2a168d52be23ce365b1fbd40e624c4
         * nickname : :-(V5大总攻
         * type : normal
         * lv : 2
         * gender : male
         */

        private AuthorVO author;
        private int floor;
        private int likeCount;
        private String created;
        private Object replyTo;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public AuthorVO getAuthor() {
            return author;
        }

        public void setAuthor(AuthorVO author) {
            this.author = author;
        }

        public int getFloor() {
            return floor;
        }

        public void setFloor(int floor) {
            this.floor = floor;
        }

        public int getLikeCount() {
            return likeCount;
        }

        public void setLikeCount(int likeCount) {
            this.likeCount = likeCount;
        }

        public String getCreated() {
            return created;
        }

        public void setCreated(String created) {
            this.created = created;
        }

        public Object getReplyTo() {
            return replyTo;
        }

        public void setReplyTo(Object replyTo) {
            this.replyTo = replyTo;
        }

        public static class AuthorVO {
            private String _id;
            private String avatar;
            private String nickname;
            private String type;
            private int lv;
            private String gender;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public int getLv() {
                return lv;
            }

            public void setLv(int lv) {
                this.lv = lv;
            }

            public String getGender() {
                return gender;
            }

            public void setGender(String gender) {
                this.gender = gender;
            }
        }
    }
}
