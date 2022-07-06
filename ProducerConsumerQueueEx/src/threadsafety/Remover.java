package threadsafety;

public class Remover implements Runnable {

    private SharedData data;

    public Remover(SharedData data){
        this.data = data;
    }
    @Override
    public void run(){
        for (int i = 1; i <= 1000 ; i++) {
            data.remove();
        }
    }
}
