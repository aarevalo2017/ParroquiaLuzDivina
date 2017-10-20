/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import dao.ErogantesDAO;
import dto.ErogantesDTO;

/**
 *
 * @author Alejandra Coello
 */
public class Test {
    public static void main(String[] args) {
        ErogantesDAO dao = new ErogantesDAO();
        for (ErogantesDTO item : dao.readAll()) {
            System.out.println(item.getNombre());
        }
//        Probamos los metodos creados
//        ComunidadesDAO dao = new ComunidadesDAO();
//        ComunidadesDTO comunidad = new ComunidadesDTO("1111", "ISAAC FALTO", 19);
//        dao.create(new ComunidadesDTO("1111", "aaaa", 11));
//        dao.create(new ComunidadesDTO("2222", "bbbb", 22));
//        dao.update(comunidad);
//        dao.delete("1111");
//        
//        ComunidadesDTO comunidad = dao.read("1111");
//        System.out.println("Rut: " + alumnocomunidad.getRut());
//        System.out.println("Nombre: " + comunidad.getNombre());
//        System.out.println("Edad: " + comunidad.getEdad());
//        
//        for ( ComunidadesDTO aux: dao.readAll()  ) {
//            System.out.println("Rut: " +aux.getRut());
//            System.out.println("Nombre: " +aux.getNombre());
//            System.out.println("Edad: " +aux.getEdad());
//        }
    }
}
