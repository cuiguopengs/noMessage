package sample;

public class MessageUser {
    private EnumMessageShowType showType;

    private String messageInfo;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessageInfo() {
        return messageInfo;
    }

    public void setMessageInfo(String messageInfo) {
        this.messageInfo = messageInfo;
    }

    public EnumMessageShowType getShowType() {
        return showType;
    }

    public void setShowType(EnumMessageShowType showType) {
        this.showType = showType;
    }
}
