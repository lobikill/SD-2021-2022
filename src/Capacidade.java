import java.time.LocalDate;
import java.util.concurrent.locks.ReentrantLock;

public class Capacidade {

    private LocalDate dia;
    private int capacidade,maxCapacidade;
    private ReentrantLock lock;

    public Capacidade(LocalDate dia, int capacidade, int maxCapacidade) {
        this.dia = dia;
        this.capacidade = capacidade;
        this.maxCapacidade = maxCapacidade;
        this.lock = new ReentrantLock();
    }

    public LocalDate getDia(){
        try {
            lock.lock();
            return this.dia;
        } finally {
            lock.unlock();
        }
    }

    public void decrementa(){
        try {
            lock.lock();
            capacidade--;
        } finally {
            lock.unlock();
        }
    }

    public void incrementa(){
        try {
            lock.lock();
            capacidade++;
        } finally {
            lock.unlock();
        }
    }

    public boolean isFull(){
        try {
            lock.lock();
            if(capacidade < maxCapacidade)
                return false;
            return true;
        } finally {
            lock.unlock();
        }
    }

    public String toString(){
        try {
            lock.lock();
            StringBuilder strBldr = new StringBuilder();
            strBldr.append("{"+this.dia.toString()+";"+this.capacidade+"/"+this.maxCapacidade+"}");

            return strBldr.toString();
        } finally {
            lock.unlock();
        }
    }
}
