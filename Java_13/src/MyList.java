
import java.util.ArrayList;

public class MyList  extends ArrayList<Message>{
    public MyList(){
        this.add(new Message(1, "Andrey"));
        this.add(new Message(2, "Jeka"));
        this.add(new Message(3, "Vitya"));
    }

    @Override
    public String toString(){
        String str = "";
        for(Message m: this){
            str += m;
        }
        return str;
    }
}

