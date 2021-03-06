/*
------------------------
Dan Javier Olvera Villeda
UNIVERSIDAD VERACRUZANA
------------------------
 */

package Modelo;

import javafx.collections.ObservableList;

/**
 * Clave del programa: <br>
 * Autor: olver <br>
 * Fecha: <br>
 * Descripción: Interfaz que ofrece operaciones para una clase de acceso a la tabla InstitucionVinculada
 */
public interface InstitucionVinculadaDAO {
    /**
     * Crea una fila nueva en la tabla InstitucionVinculada
     * @param institucionVinculada Objeto que representa una fila de la tabla InstitucionVinculada
     * @return Booleano que indica si se pudo crear con exito una nueva fila en la tabla InstitucionVinculada con el elemento introducido
     */
    public boolean create(InstitucionVinculadaVO institucionVinculada);
    /**
     * Crea una lista con todas las filas de la tabla InstitucionVinculada
     * @return Lista con todas las filas de la tabla InstitucionVinculada
     */
    public ObservableList<InstitucionVinculadaVO> readAll();
    /**
     * Crea un objeto, recuperando los valores de una fila específica de la tabla InstitucionVinculada
     * @param nombreInstitucion Nombre de la institucion vinculada que se desea recuperar de la base de datos
     * @return Objeto con los valores de la fila que se quería recuperar
     */
    public InstitucionVinculadaVO read(String nombreInstitucion);
    /**
     * Actualiza una fila especifica con los valores del elemento introducido
     * @param nombreInstitucion nombre de la institucionVinculada que se desea actualizar en la base de datos
     * @param institucionVinculada Objeto que representa una fila de la tabla InstitucionVinculada
     * @return Booleano que indica si se pudo actualizar la fila de la tabla InstitucionVinculada con éxito
     */
    public boolean update(String nombreInstitucion, InstitucionVinculadaVO institucionVinculada);
    /**
     * Borra una fila especifica de la tabla InstitucionVinculada
     * @param institucionVinculada Objeto que representa una fila de la tabla InstitucionVinculada
     * @return Booleano que indica si se pudo eliminar la fila especificada de la tabla InstitucionVinculada con éxito
     */
    public boolean delete(InstitucionVinculadaVO institucionVinculada);
    /**
     * Borra una fila de la tabla InstitucionVinculada, especificado por su nombre en la base de datos
     * @param nombreInstitucion nombre de la institucion vinculada que se desea eliminar de la base de datos
     * @return Booleano que indica si se pudo eliminar la fila especificada de la tabla InstitucionVinculada con éxito
     */
    public boolean delete(String nombreInstitucion);
}
