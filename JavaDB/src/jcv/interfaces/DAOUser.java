
package jcv.interfaces;

import java.util.List;
import jcv.model.User;

/**
 * @author Jovanny Colindres
 */
public interface DAOUser {
    public void registrar(User user) throws Exception;
    public void modificar(User user) throws Exception;
    public void eliminar(User user) throws Exception;
    public List<User> listar() throws Exception;
}
