/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgModelo;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author EDUARD
 */
public class HelpUsuario {

    Session session = null;

    public HelpUsuario() {
        
        
    }

    
    public void ingresarUsuario(int cedula, String nombre, String apellido, String telefono, String correo) throws Exception{
        Usuarios ser = new Usuarios(cedula, nombre, apellido, telefono, correo);
        SessionFactory sf = null;
        Transaction t = null;
        Session s = null;
        
        sf = NewHibernateUtil.getSessionFactory();
        s = sf.openSession();
        t = s.beginTransaction();
        s.save(ser);
        t.commit();
        s.close();
      
    }

    public Usuarios consultarUsuarioCedula(int cedula) {
        SessionFactory sf = NewHibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Usuarios ser = (Usuarios) s.get(Usuarios.class, cedula);
        s.close();
        if (ser != null) {
            return ser;
        }
        return null;
    }

    public void eliminarUsuario(int cedula) {
        java.util.List<Usuarios> lista = new java.util.LinkedList<>();
        SessionFactory sf = NewHibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();
        Query q = s.createQuery("delete from Clientes where cedula = :cedula");
        q.setInteger("id", cedula);
        q.executeUpdate();
        t.commit();
        s.close();

//        SessionFactory sf = HibernateUtil.getSessionFactory();
//        Session s = sf.openSession();
//        Servicios ser = consultarServicioPorId(id);
//        System.out.println("el servicio es " + ser.getNombre());
//        System.out.println("el servicio es " + ser.getId());
//        s.delete(ser);
//        s.close();
    }

    public Usuarios actualizarCliente(int cedula, String nombre, String apellido, String telefono, String correo) {
        SessionFactory sf = NewHibernateUtil.getSessionFactory();

        try {
            Session s = sf.openSession();
            Transaction t = s.beginTransaction();
            Usuarios u = new Usuarios(cedula, nombre, apellido, telefono, correo);
            s.update(u);
            t.commit();
            s.close();
            return u;
        } catch (HibernateException he) {
            he.printStackTrace();
        }

        return null;
    }

    public java.util.List<Usuarios> obtenerClientes() {
        java.util.List<Usuarios> lista = new java.util.LinkedList<>();
        SessionFactory sf = NewHibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Query q = s.createQuery("from Clientes");
        lista = q.list();
        s.close();

        return lista;
    }

    
}
