package yueshenginfo.com.mynovel.module.review.dto;

import java.util.List;

/**
 * Created by huchao on 2016/12/23.
 * Email 1064224874@qq.com
 */
public class CommunityDto {

    /**
     * posts : [{"_id":"57dea3c431de9dcd7898e442","book":{"_id":"560ae1e8223ca85564401a5a","title":"最强修炼系统","cover":"/agent/http://media.tadu.com/5/4/4/d/544d9562f9c84d26b6d2faec70f6537b_250_200.jpg"},"title":"作者加油更新。","author":{"_id":"5794d1b153cc962125c723b7","avatar":"/avatar/b6/d5/b6d53f4049888f3969c8acaf815a10a3","nickname":"刁兒郎也是種態度","type":"normal","lv":5,"gender":"male"},"type":"normal","likeCount":1,"block":"book","state":"normal","updated":"2016-09-18T14:25:47.176Z","created":"2016-09-18T14:25:08.813Z","commentCount":1,"voteCount":0}]
     * ok : true
     */

    private boolean ok;
    /**
     * _id : 57dea3c431de9dcd7898e442
     * book : {"_id":"560ae1e8223ca85564401a5a","title":"最强修炼系统","cover":"/agent/http://media.tadu.com/5/4/4/d/544d9562f9c84d26b6d2faec70f6537b_250_200.jpg"}
     * title : 作者加油更新。
     * author : {"_id":"5794d1b153cc962125c723b7","avatar":"/avatar/b6/d5/b6d53f4049888f3969c8acaf815a10a3","nickname":"刁兒郎也是種態度","type":"normal","lv":5,"gender":"male"}
     * type : normal
     * likeCount : 1
     * block : book
     * state : normal
     * updated : 2016-09-18T14:25:47.176Z
     * created : 2016-09-18T14:25:08.813Z
     * commentCount : 1
     * voteCount : 0
     */

    private List<PostsVO> posts;

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public List<PostsVO> getPosts() {
        return posts;
    }

    public void setPosts(List<PostsVO> posts) {
        this.posts = posts;
    }

    public static class PostsVO {
        private String _id;
        /**
         * _id : 560ae1e8223ca85564401a5a
         * title : 最强修炼系统
         * cover : /agent/http://media.tadu.com/5/4/4/d/544d9562f9c84d26b6d2faec70f6537b_250_200.jpg
         */

        private BookVO book;
        private String title;
        /**
         * _id : 5794d1b153cc962125c723b7
         * avatar : /avatar/b6/d5/b6d53f4049888f3969c8acaf815a10a3
         * nickname : 刁兒郎也是種態度
         * type : normal
         * lv : 5
         * gender : male
         */

        private AuthorVO author;
        private String type;
        private int likeCount;
        private String block;
        private String state;
        private String updated;
        private String created;
        private int commentCount;
        private int voteCount;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public BookVO getBook() {
            return book;
        }

        public void setBook(BookVO book) {
            this.book = book;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public AuthorVO getAuthor() {
            return author;
        }

        public void setAuthor(AuthorVO author) {
            this.author = author;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getLikeCount() {
            return likeCount;
        }

        public void setLikeCount(int likeCount) {
            this.likeCount = likeCount;
        }

        public String getBlock() {
            return block;
        }

        public void setBlock(String block) {
            this.block = block;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getUpdated() {
            return updated;
        }

        public void setUpdated(String updated) {
            this.updated = updated;
        }

        public String getCreated() {
            return created;
        }

        public void setCreated(String created) {
            this.created = created;
        }

        public int getCommentCount() {
            return commentCount;
        }

        public void setCommentCount(int commentCount) {
            this.commentCount = commentCount;
        }

        public int getVoteCount() {
            return voteCount;
        }

        public void setVoteCount(int voteCount) {
            this.voteCount = voteCount;
        }

        public static class BookVO {
            private String _id;
            private String title;
            private String cover;

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

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }
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
