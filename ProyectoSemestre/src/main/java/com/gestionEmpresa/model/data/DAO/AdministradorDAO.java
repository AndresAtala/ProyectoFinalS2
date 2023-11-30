package com.gestionEmpresa.model.data.DAO;

import com.gestionEmpresa.model.Administrador;
import org.jooq.DSLContext;

import java.util.List;

import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.table;

public class AdministradorDAO {

    private final DSLContext create;

    public AdministradorDAO(DSLContext create) {
        this.create = create;
    }

    public void agregarAdministrador(Administrador admin) {
        create.insertInto(table("Administrador"))
                .columns(field("rut"), field("nombre"), field("apellido"), field("telefono"), field("rol"))
                .values(admin.getRut(), admin.getNombre(), admin.getApellido(), admin.getTelefono(), admin.getRol())
                .execute();
    }

    public boolean borrarAdministrador(String rut) {
        int filasBorradas = create.deleteFrom(table("Administrador"))
                .where(field("rut").eq(rut))
                .execute();

        // Devolver true si al menos una fila fue borrada
        return filasBorradas > 0;
    }

    public boolean modificarAdministrador(Administrador admin) {
        int filasActualizadas = create.update(table("Administrador"))
                .set(field("nombre"), admin.getNombre())
                .set(field("apellido"), admin.getApellido())
                .set(field("telefono"), admin.getTelefono())
                .set(field("rol"), admin.getRol())
                .where(field("rut").eq(admin.getRut()))
                .execute();
        return filasActualizadas > 0;
    }


    public List<Administrador> obtenerTodosAdministradores() {
        try {
            List<Administrador> administradores = create.selectFrom(table("Administrador"))
                    .fetchInto(Administrador.class);

            System.out.println("Número de administradores encontrados: " + administradores.size());

            // Imprimir los administradores para depuración
            for (Administrador admin : administradores) {
                System.out.println(admin);
            }

            return administradores;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al obtener todos los administradores", e);
        }
    }
}