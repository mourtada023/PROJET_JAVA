package displayer;


public class DisplayerWithLatency  extends LedDisplayer{
    protected int latency;
    public DisplayerWithLatency(int Width,int latency){
        super(Width);
        this.latency=latency;
    }
    public void setMessage(){
        String msgwhithlatency= Message;
        for (int i =0 ; i<this.latency; i++){
            msgwhithlatency= msgwhithlatency+"";

        }
        super.setMessage(msgwhithlatency);

    }

    
}
