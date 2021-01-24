/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.util.List;

/**
 *
 * @author javy
 */
public interface CRUD {
    
    public <T> List<T> listar();
    public Object list(int id, String tipo);
    public boolean agregar(Object obj);
    public boolean editar(Object obj);
    public boolean remover(int id, String tipo);
    
}
