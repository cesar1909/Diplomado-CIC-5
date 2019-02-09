package mx.ipn.cic.myapplication.abstracts;

public abstract class ClaseAbstracta {

    private static String TAG = ClaseAbstracta.class.getName();

    public abstract float metodoAbstracto(int entero);
    public abstract void metodoAbstractoDos();

    public void metodoUno(){
        System.out.println("Método Uno");
    }

    public int metodoDos(){
        System.out.println("Método DOS");

        return 1;
    }

}
