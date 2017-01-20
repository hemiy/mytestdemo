package hemiy.qinghui.com.mytestdemo.model;

/**
 * Created by hemiy on 16/6/10.
 */
public class ResultEntity {



    /**

     * id : d5a01006-2e5d-4679-be7c-7ba59e3a33f1
     * content : <p>11233313<br/></p>
     * createTime : 2016-06-02 13:57:04.0
     * title : 12313
     * releaseId : d5a01006-2e5d-4679-be7c-7ba59e3a33f1
     * editId : 001
     * messageUUID : d5a01006-2e5d-4679-be7c-7ba59e3a33f1
     * classifyKey : 0
     * releaseTime : 2016-06-02 13:59:55.0
     * outChain :
     * topicImage :
     * messageState : 1
     * authorId : 001
     */

    private String id;
    private String content;
    private String createTime;
    private String title;
    private String releaseId;
    private String editId;
    private String messageUUID;
    private String classifyKey;
    private String releaseTime;
    private String outChain;
    private String topicImage;
    private String messageState;
    private String authorId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseId() {
        return releaseId;
    }

    public void setReleaseId(String releaseId) {
        this.releaseId = releaseId;
    }

    public String getEditId() {
        return editId;
    }

    public void setEditId(String editId) {
        this.editId = editId;
    }

    public String getMessageUUID() {
        return messageUUID;
    }

    public void setMessageUUID(String messageUUID) {
        this.messageUUID = messageUUID;
    }

    public String getClassifyKey() {
        return classifyKey;
    }

    public void setClassifyKey(String classifyKey) {
        this.classifyKey = classifyKey;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getOutChain() {
        return outChain;
    }

    public void setOutChain(String outChain) {
        this.outChain = outChain;
    }

    public String getTopicImage() {
        return topicImage;
    }

    public void setTopicImage(String topicImage) {
        this.topicImage = topicImage;
    }

    public String getMessageState() {
        return messageState;
    }

    public void setMessageState(String messageState) {
        this.messageState = messageState;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public ResultEntity(String id, String content, String createTime, String title, String releaseId, String editId, String messageUUID, String classifyKey, String releaseTime, String outChain, String topicImage, String messageState, String authorId) {
        this.id = id;
        this.content = content;
        this.createTime = createTime;
        this.title = title;
        this.releaseId = releaseId;
        this.editId = editId;
        this.messageUUID = messageUUID;
        this.classifyKey = classifyKey;
        this.releaseTime = releaseTime;
        this.outChain = outChain;
        this.topicImage = topicImage;
        this.messageState = messageState;
        this.authorId = authorId;
    }

    public ResultEntity() {
    }

    @Override
    public String toString() {
        return "ResultEntity{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                ", createTime='" + createTime + '\'' +
                ", title='" + title + '\'' +
                ", releaseId='" + releaseId + '\'' +
                ", editId='" + editId + '\'' +
                ", messageUUID='" + messageUUID + '\'' +
                ", classifyKey='" + classifyKey + '\'' +
                ", releaseTime='" + releaseTime + '\'' +
                ", outChain='" + outChain + '\'' +
                ", topicImage='" + topicImage + '\'' +
                ", messageState='" + messageState + '\'' +
                ", authorId='" + authorId + '\'' +
                '}';
    }
}
