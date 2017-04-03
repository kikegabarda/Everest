/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import entidades.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author cetecom
 */
@Stateless
public class UsuarioSB implements ModUsuario {
    @PersistenceContext(unitName = "userProyectPU")
    protected EntityManager em;

    @Override
    public void crearUsuario(Usuario usuario) {

        try {
            em.persist(usuario);
        } catch (Exception ex) {
            throw ex;
        }

    }

    @Override
    public void borrarUsuario(Usuario usuario)  {

        try {
            em.remove(usuario);
        } catch (Exception e) {
            throw e;
        }

    }

    @Override
    public Usuario buscarUsuarioApellido(String apellido) {


        //"Usuario.findByApellido"
        try {
             return em.find(Usuario.class, apellido);
        } catch (Exception e) {
            throw e;
        }
       
        
    }

    @Override
    public void editarUsuario(Usuario usuario)  {

        try {
            usuario = em.merge(usuario);
        } catch (Exception e) {
            throw e;
        }

    }

    
    @Override
    public List<Usuario> todosUsuarios() throws Exception {
        return findUsuarioEntities(true, -1, -1);
    }

    public List<Usuario> findUsuarioEntities(int maxResults, int firstResult) {
        return findUsuarioEntities(false, maxResults, firstResult);
    }

    private List<Usuario> findUsuarioEntities(boolean all, int maxResults, int firstResult) {

        try {

            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Usuario.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();

        } catch (Exception e) {
            throw e;
        }
    }
}
