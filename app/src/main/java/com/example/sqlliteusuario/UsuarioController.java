package com.example.sqlliteusuario;

import android.content.Context;

import java.util.ArrayList;
import java.util.Iterator;

public class UsuarioController {
    Context mContext;
    UsuarioDAO usuarioDAO;

    public UsuarioController(Context mContext) {
        this.mContext = mContext;
        usuarioDAO = new UsuarioDAO(mContext);
    }

    public void save(Usuario u) {
        usuarioDAO.inserir(u);
    }

    public ArrayList<Usuario> listarUsuarios() {
        ArrayList<Usuario> usuarioArreyList = new ArrayList<Usuario>();
        Iterator<Usuario> it = usuarioDAO.listarUsuarios().iterator();
        while (it.hasNext()) {
            Usuario u = it.next();
            usuarioArreyList.add(u);

        }
        return usuarioArreyList;
    }

    public ArrayList<String> getListaNomesUsuarios() {
        ArrayList<String> listaNomeUsuario = new ArrayList<String>();
        for (Usuario u : this.listarUsuarios()) {
            listaNomeUsuario.add(u.getNome());
        }
        return listaNomeUsuario;
    }
}
