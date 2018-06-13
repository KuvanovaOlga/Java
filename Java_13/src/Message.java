public class Message{
    public String mess;
    public int id;

    public Message(int i, String m){
        id=i;
        mess=m;
    }

    public int getId(){return this.id;}
    public String getMess(){return this.mess;}
}
