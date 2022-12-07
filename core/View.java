package core;

public interface View<T> {
    void cadastrar() throws Exception;
    void alterar() throws Exception;
    void excluir() throws Exception;
    void listar() throws Exception;
}
