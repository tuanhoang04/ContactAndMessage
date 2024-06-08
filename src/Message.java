
public class Message{
    private String text;
    private String recipient;
    private int id;

    public Message(String text, String recipient, int id){
        this.text = text;
        this.recipient = recipient;
        this.id = id;
    }

    public String getDetails(){
        return "Contact: " + recipient + "\nText: " + text +"\nID:"+id;
    }

    public String getText(){
        return text;
    }

    public String getRecipient() {
        return recipient;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public void setText(String text) {
        this.text = text;
    }
}
