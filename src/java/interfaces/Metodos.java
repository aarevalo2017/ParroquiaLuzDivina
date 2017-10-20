/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;

/**
 *
 * @author Alejandra Coello
 */
public interface Metodos<Generico> {
    //La interface va a trabajar con un tipo de dato llamado Object
    
    //Metodos a trabajar
    public boolean create(Generico generico); //
    public boolean update(Generico generico);
    public boolean delete(Object pk);
    public Generico read(Object pk);
    public List<Generico> readAll();
}
