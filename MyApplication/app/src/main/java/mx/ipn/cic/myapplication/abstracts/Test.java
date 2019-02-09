package mx.ipn.cic.myapplication.abstracts;

public class Test {

    private static String TAG = "Test";

    public static void main(String[] args) {

//        ClaseAbstracta abstracta = new ClaseAbstracta() {
//            @Override
//            public float metodoAbstracto(int entero) {
//
//                System.out.println("Método Abstracto");
//
//                return entero*2;
//            }
//
//            @Override
//            public void metodoAbstractoDos() {
//
//                System.out.println("Método Abstracto Dos");
//
//            }
//        };
//
//        abstracta.metodoUno();
//
//        abstracta.metodoDos();
//
//        float valor = abstracta.metodoAbstracto(3);
//
//        abstracta.metodoAbstractoDos();


        Interfaz interfaz = new Interfaz() {
            @Override
            public void metodoInterfazUno() {
                System.out.println("Método metodoInterfazUno");
            }

            @Override
            public void metodoInterfazDos() {
                System.out.println("Método metodoInterfazDos");
            }
        };

        interfaz.metodoInterfazUno();

        interfaz.metodoInterfazDos();

    }

}
