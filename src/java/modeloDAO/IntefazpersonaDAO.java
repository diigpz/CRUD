
package modeloDAO;

import modelo.Persona;
import java.util.List;

//crea un aray con los datos de editar,eliminar,agregar y ibtener y el cual se reflejara en la base de datos 
public interface IntefazpersonaDAO {
     public List<Persona>getPersonas();
     public Persona getId(int id);
     public int add(Persona p);
     public int update(Persona p);
     public int delete(int id);
}
