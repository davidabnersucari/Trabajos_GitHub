package pe.edu.upeu.sysventas.exeption;

public class ModelNotFoundExeption extends  RuntimeException{
    public ModelNotFoundExeption(String message) {
        super(message);
    }
}
