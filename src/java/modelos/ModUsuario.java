/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import entidades.Usuario;
import java.util.List;

/**
 *
 * @author cetecom
 */
public interface ModUsuario {
    
    public void crearUsuario(Usuario usuario) throws Exception;
    
    public void borrarUsuario(Usuario usuario) throws Exception;
    
    public Usuario buscarUsuarioApellido(String apellido) throws Exception;
    
    public List<Usuario> todosUsuarios() throws Exception;
    
    public void editarUsuario(Usuario usuario) throws Exception;
}
