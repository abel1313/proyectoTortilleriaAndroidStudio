package app.lector.tortilleria_salida.service;

import java.util.List;

import app.lector.tortilleria_salida.dao.ICrudImpl;
import app.lector.tortilleria_salida.model.Usuario;


public class UsuarioServiceImpl extends ICrudImpl<Usuario, Integer> implements IUsuarioService
{

    @Override
    public List<Usuario> findAll() throws Exception {
        return null;
    }
}
