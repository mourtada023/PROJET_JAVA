package displayer;

public class SpeedDisplayer extends DisplayerWithLatency {
    private int speed;

    public SpeedDisplayer(int Width, int latency,int speed){
        super(Width,latency);
        this.speed=speed;
    }
    public void shift(){
        for( int i=0; i< this.speed; i++){
            super.shift();
        }
    }
}
